package com.example.demo;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String connectionUrl =
                "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";"
                        + "database=" + dbName + ";"
                        + "user=" + dbUser + ";"
                        + "password=" + dbPass + ";"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dbConnection = DriverManager.getConnection(connectionUrl);
        return dbConnection;
    }
    public void searchQuery(String Name) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM " + Equipment.NAME + ";";
        PreparedStatement ps = getConnection().prepareStatement(query);
        ps.executeUpdate();
    }
}