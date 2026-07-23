package test;

import model.Item;
import model.ReadLogic;

import java.util.List;

public class ReadLogicTest {
    public static void main(String[] args) {
        textExecuteOK();
    }
    public static void textExecuteOK() {
        ReadLogic bo = new ReadLogic();
        List<Item> itemList = bo.execute();
        if (itemList != null) {
            System.out.println("成功しました");
        } else {
            System.out.println("リストはnullです");
        }
    }
}
