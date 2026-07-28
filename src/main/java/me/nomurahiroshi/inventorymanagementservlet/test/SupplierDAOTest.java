package me.nomurahiroshi.inventorymanagementservlet.test;

import me.nomurahiroshi.inventorymanagementservlet.dao.SupplierDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.util.List;

public class SupplierDAOTest {
    public static void main(String[] args) {
        testReadSpplierOK();
    }
    public static void testReadSpplierOK() {
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> result = dao.readSupplier();
        if (result != null) {
            System.out.println("成功しました");
        }
    }
}
