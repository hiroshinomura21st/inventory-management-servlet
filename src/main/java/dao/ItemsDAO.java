package dao;

import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDAO {
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
}

