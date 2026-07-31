package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.model.Search;

import java.util.List;

public class SearchItemLogic {
    public List<Item> execute(String order, String keyword) {
        ItemDAO dao = new ItemDAO();
        List<Item> itemList = dao.searchItems(order, keyword);
        return itemList;
    }
}
