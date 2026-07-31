package me.nomurahiroshi.inventorymanagementservlet.model;

import java.io.Serializable;

public class Search implements Serializable {
    private String order;
    private String keyword;

    public Search() {}
    public Search(String order, String keyword) {
        this.order = order;
        this.keyword = keyword;
    }

    public String getOrder() {
        return order;
    }

    public String getKeyword() {
        return keyword;
    }
}
