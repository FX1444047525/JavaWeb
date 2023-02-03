package com.bjpowernode.crm.settings.dao;

import com.bjpowernode.crm.settings.domain.TaskSpot;

import java.util.List;
import java.util.Map;

public interface SpotDao {
    List<Map<Object,Object>> getSpotList(String id);
}
