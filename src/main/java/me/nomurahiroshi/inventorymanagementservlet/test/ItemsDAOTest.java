package me.nomurahiroshi.inventorymanagementservlet.test;

import me.nomurahiroshi.inventorymanagementservlet.dao.ItemsDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.util.List;

public class ItemsDAOTest {
    public static void main(String[] args) {
        testReadItemsOK();
    }
    public static void testReadItemsOK() {
        ItemsDAO dao = new ItemsDAO();
        List<Item> itemList = dao.readItems();
        if (itemList != null) {
            System.out.println("成功しました");
        } else {
            System.out.println("リストはnullです");
        }
    }
}
