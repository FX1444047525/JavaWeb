package com.bjpowernode.crm.settings.web.controller;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.service.UpdateSpotStateService;
import com.bjpowernode.crm.settings.service.impl.UpdateSpotStateServiceImpl;
import com.bjpowernode.crm.utils.PrintJson;
import com.bjpowernode.crm.utils.ServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SpotController", value = "/SpotController")
public class SpotController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //更新任务节点完成状态
            update(request,response);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        System.out.println("进入到更新节点状态操作");

        String id = request.getParameter("id");
        String state = request.getParameter("state");

        UpdateSpotStateService us = (UpdateSpotStateService) ServiceFactory.getService(new UpdateSpotStateServiceImpl());

        try {
            int num = us.update(id,state);
            if (num == 1)
                //运行到这里，说明更新成功，于是返回true
                PrintJson.printJsonFlag(response, true);
            else if (num == 0){
                //更新不成功，返回false
                PrintJson.printJsonFlag(response, false);
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
