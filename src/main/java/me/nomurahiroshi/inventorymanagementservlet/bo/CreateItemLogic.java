package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;

import java.util.List;

public class CreateItemLogic {
    public List<Item> execute(Item item, Search search) {
        ItemDAO dao = new ItemDAO();
        List<Item> itemList = null;
        boolean result = dao.createItem(item);
        if (result && search == null) {
            itemList = dao.readItems();
        } else {
            String order = search.getOrder();
            String keyword = search.getKeyword();
            itemList = dao.searchItems(order, keyword);
         }
    return itemList;
    }
}
