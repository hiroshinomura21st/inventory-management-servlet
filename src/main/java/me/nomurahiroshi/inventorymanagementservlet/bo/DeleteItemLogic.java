package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;

import java.util.List;

public class DeleteItemLogic {
    public List<Item> execute(String itemCode, Search search) {
        List<Item> itemList = null;
        ItemDAO dao = new ItemDAO();
        boolean result = dao.deleteItem(itemCode);
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
