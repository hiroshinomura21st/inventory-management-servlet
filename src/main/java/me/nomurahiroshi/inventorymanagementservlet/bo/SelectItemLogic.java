package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

public class SelectItemLogic {
    public Item execute(String itemCode) {
        ItemDAO dao = new ItemDAO();
        Item item = dao.select(itemCode);
        return item;
    }
}
