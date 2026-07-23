package me.nomurahiroshi.inventorymanagementservlet.model;

public class Item {
    private String itemCode;
    private String name;
    private int price;
    private int stockNum;
    private String supplierCode;

    public Item(String itemCode, String name, int price, int stockNum, String supplierCode) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.stockNum = stockNum;
        this.supplierCode = supplierCode;
    }
    public String getItemCode() {
        return itemCode;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getStockNum() {
        return stockNum;
    }
    public String getSupplierCode() {
        return supplierCode;
    }
}
