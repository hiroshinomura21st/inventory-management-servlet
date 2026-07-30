package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class UpdateItemLogic {
    public List<Item> execute(Item item) {
        List<Item> itemList = null;
        ItemDAO dao = new ItemDAO();
        boolean result = dao.updateItem(item);
        if (result == true) {
            itemList = dao.readItems();
        }
        return  itemList;
    }
}
