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
                        + "loginTimeout=30;encrypt=false;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dbConnection = DriverManager.getConnection(connectionUrl);
        return dbConnection;
    }
//    public void searchQuery(String Name) throws SQLException, ClassNotFoundException {
//        String query = "SELECT * FROM Оборудование WHERE " + Equipment.NAME + " LIKE '%" + Name +
//                "%' AND " + Equipment.CATEGORY + " LIKE '%" + SearchCategoryController.category +
//                "%' AND " + Equipment.LINE + " LIKE'%" + SearchCategoryController.line +
//                "%' AND " + Equipment.SERIAL_NUMBER + " LIKE'%" + SearchCategoryController.serialNumber +
//                "%' AND " + Equipment.MARKET_PRICE + " > '" + SearchCategoryController.minMarket +
//                "' AND " + Equipment.MARKET_PRICE + " < '" + SearchCategoryController.maxMarket +
//                "' AND " + Equipment.PURCHASE_PRICE + " > '" + SearchCategoryController.minPurchase +
//                "' AND " + Equipment.PURCHASE_PRICE + " < '" + SearchCategoryController.maxPurchase +
//                "';";
//        PreparedStatement ps = getConnection().prepareStatement(query);
//        res = ps.executeQuery();
//        while (res.next()) {
//            System.out.println(res.getString(1));
//            System.out.println(res.getString(2));
//            System.out.println(res.getString(3));
//        }
//    }
}