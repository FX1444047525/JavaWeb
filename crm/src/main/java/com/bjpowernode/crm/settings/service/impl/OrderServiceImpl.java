package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.dao.OrderDao;
import com.bjpowernode.crm.settings.domain.Order;
import com.bjpowernode.crm.settings.service.OrderService;
import com.bjpowernode.crm.utils.SqlSessionUtil;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = SqlSessionUtil.getSqlSession().getMapper(OrderDao.class);

    public List<Order> getOrder() {
        List<Order> order = orderDao.getOrder();
        return  order;
    }
}
