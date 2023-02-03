package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.dao.SpotDao;
import com.bjpowernode.crm.settings.service.SpotService;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

public class SpotServiceImpl implements SpotService {
    private SpotDao spotDao = SqlSessionUtil.getSqlSession().getMapper(SpotDao.class);
    @Override
    public List<Map<Object,Object>> getSpot(String id) {
        List<Map<Object,Object>> spot = spotDao.getSpotList(id);
        return spot;
    }
}
