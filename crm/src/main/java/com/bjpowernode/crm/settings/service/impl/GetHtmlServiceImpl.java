package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.dao.LocationPlanDao;
import com.bjpowernode.crm.settings.service.GetHtmlService;
import com.bjpowernode.crm.utils.SqlSessionUtil;

public class GetHtmlServiceImpl implements GetHtmlService {
    private LocationPlanDao locationPlanDao = SqlSessionUtil.getSqlSession().getMapper(LocationPlanDao.class);

    public String gethtml(String id){

        String html = locationPlanDao.getHtml(id);
        return html;
    }
}
