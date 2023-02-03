package com.bjpowernode.crm.settings.domain;

public class Order {
    private String id;
    private String detail;
    private String startSpot;
    private String endSpot;
    private String sendTel;
    private String getTel;
    private String state;
    private String deliveryState;

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStartSpot() {
        return startSpot;
    }

    public void setStartSpot(String startSpot) {
        this.startSpot = startSpot;
    }

    public String getEndSpot() {
        return endSpot;
    }

    public void setEndSpot(String endSpot) {
        this.endSpot = endSpot;
    }

    public String getSendTel() {
        return sendTel;
    }

    public void setSendTel(String sendTel) {
        this.sendTel = sendTel;
    }

    public String getGetTel() {
        return getTel;
    }

    public void setGetTel(String getTel) {
        this.getTel = getTel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
