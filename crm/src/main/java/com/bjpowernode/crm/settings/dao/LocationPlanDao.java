package com.bjpowernode.crm.settings.dao;

import java.util.Map;

public interface LocationPlanDao {
    void save(Map<String, String> map);
    String getHtml(String id);
}
