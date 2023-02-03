package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.dao.LocationPlanDao;
import com.bjpowernode.crm.settings.dao.UpdateSpotStateDao;
import com.bjpowernode.crm.settings.service.LocationService;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class LocationServiceImpl implements LocationService{
    private LocationPlanDao locationPlanDao = SqlSessionUtil.getSqlSession().getMapper(LocationPlanDao.class);

    @Override
    public void save(String id,String location, String all_dist, String best_distlist, String htmlfile,String creat_time) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id",id);
        map.put("location",location);
        map.put("all_dist",all_dist);
        map.put("best_distlist",best_distlist);
        map.put("htmlfile",htmlfile);
        map.put("creat_time",creat_time);

        locationPlanDao.save(map);
        System.out.println("路径规划信息保存成功！");

    }
}
