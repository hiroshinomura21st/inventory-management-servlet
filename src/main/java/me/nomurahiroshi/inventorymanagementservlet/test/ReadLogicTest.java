package me.nomurahiroshi.inventorymanagementservlet.test;

import me.nomurahiroshi.inventorymanagementservlet.model.Item;
import me.nomurahiroshi.inventorymanagementservlet.bo.ReadItemLogic;

import java.util.List;

public class ReadLogicTest {
    public static void main(String[] args) {
        textExecuteOK();
    }
    public static void textExecuteOK() {
        ReadItemLogic bo = new ReadItemLogic();
        List<Item> itemList = bo.execute();
        if (itemList != null) {
            System.out.println("成功しました");
        } else {
            System.out.println("リストはnullです");
        }
    }
}
