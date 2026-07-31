package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class ReadItemLogic {
    public List<Item> execute() {
        ItemDAO dao = new ItemDAO();
        List<Item> itemList = dao.readItems();
        return itemList;
    }
}
