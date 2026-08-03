package me.nomurahiroshi.inventorymanagementservlet.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.nomurahiroshi.inventorymanagementservlet.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try (Connection conn = DatabaseConnection.getConnection()) {

            createTables(conn);
            initializeSuppliers(conn);

            sce.getServletContext().log(
                    "データベースの初期化が完了しました。"
            );

        } catch (SQLException e) {
            sce.getServletContext().log(
                    "データベースの初期化に失敗しました。",
                    e
            );
        }
    }

    private void createTables(Connection conn) throws SQLException {
        String createSuppliers = """
                CREATE TABLE IF NOT EXISTS SUPPLIERS (
                    SUPPLIER_CODE VARCHAR(4) PRIMARY KEY,
                    NAME VARCHAR(100) NOT NULL,
                    TEL VARCHAR(20),
                    ADDRESS VARCHAR(200)
                )
                """;

        String createItems = """
                CREATE TABLE IF NOT EXISTS ITEMS (
                    ITEM_CODE VARCHAR(20) PRIMARY KEY,
                    NAME VARCHAR(100) NOT NULL,
                    PRICE INTEGER NOT NULL,
                    STOCK_NUM INTEGER NOT NULL,
                    SUPPLIER_CODE VARCHAR(4),
                    FOREIGN KEY (SUPPLIER_CODE)
                        REFERENCES SUPPLIERS(SUPPLIER_CODE)
                )
                """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createSuppliers);
            stmt.execute(createItems);
        }
    }

    private void initializeSuppliers(Connection conn) throws SQLException {
        String sql = """
                MERGE INTO SUPPLIERS (
                    SUPPLIER_CODE,
                    NAME,
                    TEL,
                    ADDRESS
                )
                KEY (SUPPLIER_CODE)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            mergeSupplier(
                    pstmt,
                    "1111",
                    "野村商店",
                    "03-1234-5678",
                    "東京都新宿区"
            );

            mergeSupplier(
                    pstmt,
                    "2222",
                    "高橋商事",
                    "0187-43-1234",
                    "秋田県仙北市"
            );

            mergeSupplier(
                    pstmt,
                    "3333",
                    "加藤農場",
                    "0187-43-0000",
                    "秋田県仙北市"
            );

            mergeSupplier(
                    pstmt,
                    "4444",
                    "大曲青果",
                    "0187-63-0000",
                    "秋田県大仙市"
            );
        }
    }

    private void mergeSupplier(
            PreparedStatement pstmt,
            String supplierCode,
            String name,
            String tel,
            String address
    ) throws SQLException {

        pstmt.setString(1, supplierCode);
        pstmt.setString(2, name);
        pstmt.setString(3, tel);
        pstmt.setString(4, address);
        pstmt.executeUpdate();
    }
}
