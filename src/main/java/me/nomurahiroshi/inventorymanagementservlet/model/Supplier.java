package me.nomurahiroshi.inventorymanagementservlet.model;

public class Supplier {
    private String supplierCode;
    private String name;
    private String tel;
    private String address;

    public Supplier(String supplierCode, String name, String tel, String address) {
        this.supplierCode = supplierCode;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public String getSupplierCode() {
        return supplierCode;
    }
    public String getName() {
        return name;
    }
    public String getTel() {
        return tel;
    }
    public String getAddress() {
        return address;
    }
}
