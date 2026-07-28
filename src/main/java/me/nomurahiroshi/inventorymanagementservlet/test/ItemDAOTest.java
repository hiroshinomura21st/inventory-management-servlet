package me.nomurahiroshi.inventorymanagementservlet.test;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class ItemDAOTest {
    public static void main(String[] args) {
        testReadItemsOK();
    }
    public static void testReadItemsOK() {
        ItemDAO dao = new ItemDAO();
        List<Item> itemList = dao.readItems();
        if (itemList != null) {
            System.out.println("成功しました");
        } else {
            System.out.println("リストはnullです");
        }
    }
}
