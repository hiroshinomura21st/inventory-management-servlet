package me.nomurahiroshi.inventorymanagementservlet.dao;

import me.nomurahiroshi.inventorymanagementservlet.model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/inventoryManagement";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public List<Item> readItems() {
        List<Item> itemList = new ArrayList<>();

        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            String sql = "SELECT * FROM ITEMS";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                String itemCode = rs.getString("ITEM_CODE");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                int stockNum = rs.getInt("STOCK_NUM");
                String supplierCode = rs.getString("SUPPLIER_CODE");
                Item item = new Item(itemCode, name, price, stockNum, supplierCode);
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return itemList;
    }

    public boolean createItem(Item item) {
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO ITEMS VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // INSERT文中の「？」に使用する値を設定してSQL文を完成
            pStmt.setString(1, item.getItemCode());
            pStmt.setString(2, item.getName());
            pStmt.setInt(3, item.getPrice());
            pStmt.setInt(4, item.getStockNum());
            pStmt.setString(5, item.getSupplierCode());

            // SELECT文を実行し、結果表を取得
            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Item select(String itemCode) {
        Item item = null;
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
            String sql = "SELECT * FROM ITEMS WHERE ITEM_CODE = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, itemCode);

            // SELECT文を実行し、結果表を取得
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                itemCode = rs.getString("ITEM_CODE");
                String name = rs.getString("NAME");
                int price = rs.getInt("PRICE");
                int stockNum = rs.getInt("STOCK_NUM");
                String supplierCode = rs.getString("SUPPLIER_CODE");
                item = new Item(itemCode, name, price, stockNum, supplierCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return item;
    }

    public boolean updateItem(Item item) {
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "UPDATE ITEMS SET ITEM_CODE = ?, NAME = ?, PRICE = ?, STOCK_NUM = ?, SUPPLIER_CODE = ? WHERE ITEM_CODE = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // INSERT文中の「？」に使用する値を設定してSQL文を完成
            pStmt.setString(1, item.getItemCode());
            pStmt.setString(2, item.getName());
            pStmt.setInt(3, item.getPrice());
            pStmt.setInt(4, item.getStockNum());
            pStmt.setString(5, item.getSupplierCode());
            pStmt.setString(6, item.getItemCode());

            // SELECT文を実行し、結果表を取得
            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteItem(String itemCode) {
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "DELETE FROM ITEMS WHERE ITEM_CODE = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // INSERT文中の「？」に使用する値を設定してSQL文を完成
            pStmt.setString(1, itemCode);

            // SELECT文を実行し、結果表を取得
            int result = pStmt.executeUpdate();
            if (result != 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

