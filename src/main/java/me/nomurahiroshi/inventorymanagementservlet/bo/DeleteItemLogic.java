package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class DeleteItemLogic {
    public List<Item> execute(String itemCode) {
        List<Item> itemList = null;
        ItemDAO dao = new ItemDAO();
        boolean result = dao.deleteItem(itemCode);
        if (result == true) {
            itemList = dao.readItems();
        }
        return itemList;
    }
}
