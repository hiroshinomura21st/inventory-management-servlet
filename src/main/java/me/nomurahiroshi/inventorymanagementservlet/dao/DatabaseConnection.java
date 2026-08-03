package me.nomurahiroshi.inventorymanagementservlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static final String LOCAL_JDBC_URL =
            "jdbc:h2:tcp://localhost/~/inventoryManagement";

    private static final String HEROKU_JDBC_URL =
            "jdbc:h2:file:/tmp/inventoryManagement";

    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        String dyno = System.getenv("DYNO");

        if (dyno != null) {
            return DriverManager.getConnection(
                    HEROKU_JDBC_URL,
                    DB_USER,
                    DB_PASS
            );
        }

        return DriverManager.getConnection(
                LOCAL_JDBC_URL,
                DB_USER,
                DB_PASS
        );
    }
}
