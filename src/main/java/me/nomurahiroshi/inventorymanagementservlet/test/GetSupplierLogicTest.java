package me.nomurahiroshi.inventorymanagementservlet.test;

import me.nomurahiroshi.inventorymanagementservlet.bo.GetSupplierLogic;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.util.List;

public class GetSupplierLogicTest {
    public static void main(String[] args) {
        testExecuteOK();
    }
    public static void testExecuteOK() {
        GetSupplierLogic bo = new GetSupplierLogic();
        List<Supplier> resutl = bo.execute();
        if (resutl != null) {
            System.out.println("成功しました");
        }
    }
}
