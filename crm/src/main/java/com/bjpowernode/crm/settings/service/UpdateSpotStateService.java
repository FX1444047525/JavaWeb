package com.bjpowernode.crm.settings.service;

import com.bjpowernode.crm.exception.LoginException;
import com.bjpowernode.crm.settings.domain.User;

public interface UpdateSpotStateService {
    int update(String id, String state) throws LoginException;
}
