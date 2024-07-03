package com.example.demo;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddController {
    DatabaseHandler dbHandler = new DatabaseHandler();

    public int nextId() throws SQLException, ClassNotFoundException {
        ResultSet res;
        String query = "SELECT TOP 1 * FROM Оборудование ORDER BY ID DESC";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        if (res.next()) {
            int id = res.getInt("ID");
            return id + 1;
        } else {
            return 1;
        }
    }

    public void addQuery() throws SQLException, ClassNotFoundException {
        ResultSet res;
        String query = "INSERT INTO Оборудование (" + Equipment.CATEGORY +
                "," + Equipment.LINE +
                "," + Equipment.NAME +
                "," + Equipment.DESCRIPTION +
                "," + Equipment.SERIAL_NUMBER +
                "," + Equipment.MARKET_PRICE +
                "," + Equipment.PURCHASE_PRICE +
                "," + Equipment.ID +
                ") VALUES ('" + addCategoryField.getText() +
                "','" + addLineField.getText() +
                "','" + addNameField.getText() +
                "','" + addDescriptionField.getText() +
                "','" + addSerialNumberField.getText() +
                "','" + addMarketField.getText() +
                "','" + addPurchaseField.getText() +
                "','" + nextId() +"')";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField addCategoryField;

    @FXML
    private TextField addDescriptionField;

    @FXML
    private TextField addLineField;

    @FXML
    private TextField addNameField;

    @FXML
    private TextField addMarketField;

    @FXML
    private TextField addPurchaseField;

    @FXML
    private TextField addSerialNumberField;

    @FXML
    void initialize() {
        addButton.setOnAction(event -> {
            try {
                addQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
