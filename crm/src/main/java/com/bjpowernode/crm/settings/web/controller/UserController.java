package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.settings.domain.*;
import com.bjpowernode.crm.settings.service.GetHtmlService;
import com.bjpowernode.crm.settings.service.OrderService;
import com.bjpowernode.crm.settings.service.SpotService;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.settings.service.impl.GetHtmlServiceImpl;
import com.bjpowernode.crm.settings.service.impl.OrderServiceImpl;
import com.bjpowernode.crm.settings.service.impl.SpotServiceImpl;
import com.bjpowernode.crm.settings.service.impl.UserServiceImpl;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到验证登录操作");

        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        //将密码的明文形式转换为MD5的密文形式
//        loginPwd = MD5Util.getMD5(loginPwd);
        //接收浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("--------------ip:"+ip);

        //未来业务层开发，统一使用代理类形态的接口对象
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try {

            User user = us.login(loginAct,loginPwd,ip);

//            request.getSession().setAttribute("user", user);

            //如果程序执行到此处，说明业务层没有为controller抛出任何的异常
            //表示登录成功
            /*
                {"success":true}
             */
            //            PrintJson.printJsonFlag(response, true);

            String identity = user.getIdentity();
            //登录的是管理员，则返回所有订单
            if (identity.equals("0")){
                OrderService we = (OrderService) ServiceFactory.getService(new OrderServiceImpl());
                //取出所有未完成订单
                List<Order> order = we.getOrder();
                //将所有为完成订单的id从小到大拼接起来，方便借此获取路径规划表里的html地址
                String id = "";
                for(int i=0;i<order.size();i++){
                    String s = order.get(i).getId();
                    System.out.println("未完成订单的编号"+s);
                    id = id + s;
                }
                System.out.println("拼接后的id"+id);
//                if(id.equals("100110021003100410051006100710081009101010111012")){
//                    System.out.println("字符串相等");
//                }

                //获取未完成订单对应的的html地址
                GetHtmlService ht = (GetHtmlService) ServiceFactory.getService(new GetHtmlServiceImpl());
                String html = ht.gethtml(id);
                System.out.println(html);

                //Test类用来封装List<Order>和html的
                Test test = new Test();
                test.setOrder(order);
                test.setHtml(html);


//                PrintJson.printJsonObj(response, order);
                PrintJson.printJsonObj(response, test);

            }
            //登录的是配送员，则返回配送员昵称,该配送员的所有节点，路线规划图
            else if (identity.equals("1")){
                String id = user.getId();

                SpotService  sp = (SpotService) ServiceFactory.getService(new SpotServiceImpl());
                List<Map<Object,Object>> spot = sp.getSpot(id);

                //获取配送员昵称，及该配送员需要配送的节点信息（地址，时间，状态）
                String name = user.getName();
                Test1 test1 = new Test1();
                test1.setName(name);
                test1.setSpotImf(spot);
                PrintJson.printJsonObj(response, test1);

//                List<String> name = Collections.singletonList(user.getName());
//               Map<String, List<String>> map = new HashMap<>();
//               map.put("配送员昵称",name);
//               map.put("该配送员需要配送的所有节点",spot);
//                Map<String,String> map = new HashMap<String,String>();
//                map.put("配送员昵称",user.getName());
//                map.put("该配送员需要配送的所有节点",spot);
//                map.put("配送路线规划图地址",url);
//select spot from tab_taskspot a JOIN tab_user b on a.userid = b.id WHERE b.id=？
//                PrintJson.printJsonObj(response, map);
                //这里的obj就不是键值对形式，那么response结果就是1，不是键值对形式
//                PrintJson.printJsonObj(response, 1);

            }


        }catch(Exception e){
            e.printStackTrace();

            //一旦程序执行了catch块的信息，说明业务层为我们验证登录失败，为controller抛出了异常
            //表示登录失败
            /*
                {"success":true,"msg":?}
             */
            String msg = e.getMessage();
            /*

                我们现在作为contoller，需要为ajax请求提供多项信息

                可以有两种手段来处理：
                    （1）将多项信息打包成为map，将map解析为json串
                    （2）创建一个Vo
                            private boolean success;
                            private String msg;

                    如果对于展现的信息将来还会大量的使用，我们创建一个vo类，使用方便
                    如果对于展现的信息只有在这个需求中能够使用，我们使用map就可以了
             */
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }
    }
}




































