package me.nomurahiroshi.inventorymanagementservlet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import me.nomurahiroshi.inventorymanagementservlet.model.Supplier;

public class SupplierDAO {
    private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/inventoryManagement";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    public List<Supplier> readSupplier() {
        Supplier supplier = null;
        List<Supplier> supplierList = new ArrayList<>();
        // JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        // データベースへ接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

            // SELECT文を準備
            String sql = "SELECT * FROM SUPPLIERS";
            PreparedStatement pStmt = conn.prepareStatement(sql);

            // SELECT文を実行し、結果を取得
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                // 仕入業者が存在したらデータを取得
                // その仕入業者を表すSupplierインスタンスを生成
                // リストに追加
                String supplierCode = rs.getString("SUPPLIER_CODE");
                String name = rs.getString("NAME");
                String tel = rs.getString("TEL");
                String address = rs.getString("ADDRESS");
                supplier = new Supplier(supplierCode, name, tel, address);
                supplierList.add(supplier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return supplierList;
    }
}
