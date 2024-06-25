package com.example.demo;

import java.sql.*;

public class DatabaseHandler extends Configs {
    public void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";"
                        + "database=" + dbName + ";"
                        + "user=" + dbUser + ";"
                        + "password=" + dbPass + ";"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchQuery(String Name) throws SQLException {
        String query = "SELECT * FROM " + Equipment.NAME + ";";
        PreparedStatement ps = (PreparedStatement) DriverManager.getConnection(query);
        ps.setString(1, Name);
        ps.executeUpdate();
    }
}