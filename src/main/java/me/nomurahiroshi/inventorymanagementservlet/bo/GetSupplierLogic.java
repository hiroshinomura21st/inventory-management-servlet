package me.nomurahiroshi.inventorymanagementservlet.bo;

import me.nomurahiroshi.inventorymanagementservlet.dao.SupplierDAO;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

import java.util.List;

public class GetSupplierLogic {
    public List<Supplier> execute() {
        SupplierDAO dao = new SupplierDAO();
        List<Supplier> supplierList = dao.readSupplier();
        return supplierList;
    }
}
