package me.nomurahiroshi.inventorymanagementservlet.model;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemsDAO;

import java.util.List;

public class ReadLogic {
    public List<Item> execute() {
        ItemsDAO dao = new ItemsDAO();
        List<Item> itemList = dao.readItems();
        return itemList;
    }
}
