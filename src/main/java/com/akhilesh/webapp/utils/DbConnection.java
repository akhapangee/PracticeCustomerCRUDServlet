package com.akhilesh.webapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Akhilesh
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmt = null;

    public void connect() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "customer";
        String dbUserName = "root";
        String dbPassword = "";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(url + dbName, dbUserName, dbPassword);
    }

    public PreparedStatement initStatment(String sql) throws SQLException {
        return stmt = conn.prepareCall(sql);
    }

    public ResultSet executeQuery() throws SQLException {
        return stmt.executeQuery();
    }

    public int executeUpdate() throws SQLException {
        return stmt.executeUpdate();
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

}
