package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemsDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class ReadLogic {
    public List<Item> execute() {
        ItemsDAO dao = new ItemsDAO();
        List<Item> itemList = dao.readItems();
        return itemList;
    }
}
