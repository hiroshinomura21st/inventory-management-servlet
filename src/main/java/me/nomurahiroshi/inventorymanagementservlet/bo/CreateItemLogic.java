package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class CreateItemLogic {
    public List<Item> execute(Item item) {
        ItemDAO dao = new ItemDAO();
        List<Item> itemList = null;
        boolean result = dao.createItem(item);
        if (result == true) {
            itemList = dao.readItems();
        }
    return itemList;
    }
}
