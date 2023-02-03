package com.bjpowernode.crm.settings.domain;

public class Locationplan {
    private String id;
    private String location;
    private String all_dist;
    private String best_distlist;
    private String htmlfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAll_dist() {
        return all_dist;
    }

    public void setAll_dist(String all_dist) {
        this.all_dist = all_dist;
    }

    public String getBest_distlist() {
        return best_distlist;
    }

    public void setBest_distlist(String best_distlist) {
        this.best_distlist = best_distlist;
    }

    public String getHtmlfile() {
        return htmlfile;
    }

    public void setHtmlfile(String htmlfile) {
        this.htmlfile = htmlfile;
    }
}
