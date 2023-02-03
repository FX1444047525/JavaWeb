package com.bjpowernode.crm.settings.domain;

import java.util.List;

//用来封装UserController接口里返回给前端的所有未完成订单和对应的html
public class Test {
    private String html;
    private List<Order> order;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
