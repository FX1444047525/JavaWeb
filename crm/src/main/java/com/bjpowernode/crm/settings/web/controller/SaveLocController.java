package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.service.LocationService;
import com.bjpowernode.crm.settings.service.impl.LocationServiceImpl;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SaveLocController", value = "/SaveLocController")
public class SaveLocController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //保存路径规划信息
            save(request,response);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws LoginException, IOException {
        System.out.println("进入到保存路径规划信息操作");

        String id = request.getParameter("id");
        String location = request.getParameter("location");
        String all_dist = request.getParameter("all_dist");
        String best_distlist = request.getParameter("best_distlist");
        String htmlfile = request.getParameter("htmlfile");

        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）

         String creat_time = sdf.format(date);
         System.out.println(creat_time);
//        JSONObject jsonObject = GetRequestJsonUtils.getRequestJsonObject(request);
//        JSONObject object =JSONObject.parseObject("{\"location\":\"西安京东仓库 109.08077 34.492309,陕西师范大学 108.952589 34.204784,西安电子科技大学 108.833538 34.123186,西安交通大学 108.98378 34.246207,西北大学 108.874582 34.144994,西北政法大学 108.915733 34.153856,西安外国语大学 108.875929 34.135531,西京学院 108.92929 34.133062,长安大学 108.955348 34.230772,西安体育学院 108.93509 34.237611,西安建筑科技大学 108.968564 34.234122,西安欧亚学院 108.922753 34.177152,西北农林科技大学 108.07249 34.286067\",\"all_dist\": \"291.5127\",\"best_distlist\": [ [ 10, 5, 3, 7, 8, 6, 12, 2, 9, 11, 4], [ 13]],\"htmlfile\": \"./airline/1672661123386552.html\"}");
//        JSONObject location = jsonObject.getJSONObject("location");
//        String location = jsonObject.getString("location");
//        String all_dist = jsonObject.getString("all_dist");
//        String best_distlist = jsonObject.getString("best_distlist");
//        String htmlfile = jsonObject.getString("htmlfile");


        LocationService us = (LocationService) ServiceFactory.getService(new LocationServiceImpl());

        try {
            us.save(id,location,all_dist,best_distlist,htmlfile,creat_time);
            //保存成功，返回true
            PrintJson.printJsonFlag(response, true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
