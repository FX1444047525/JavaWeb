package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.dao.UpdateSpotStateDao;
import com.bjpowernode.crm.settings.dao.UserDao;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UpdateSpotStateService;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UpdateSpotStateServiceImpl implements UpdateSpotStateService {
    private UpdateSpotStateDao updateSpotStateDao = SqlSessionUtil.getSqlSession().getMapper(UpdateSpotStateDao.class);

    public int update(String id, String state) throws LoginException {

        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);
        map.put("state", state);

       int num = updateSpotStateDao.update(map);


       System.out.println("更新状态成功");
        return num;

    }
}
