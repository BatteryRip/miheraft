package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchCategoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField lineField;

    @FXML
    private TextField maxMarketField;

    @FXML
    private TextField maxPurchaseField;

    @FXML
    private TextField minMarketField;

    @FXML
    private TextField minPurchaseField;

    @FXML
    private Button save;

    @FXML
    private TextField serialNumberField;

    @FXML
    void initialize() {
        save.setOnAction(event -> {
            DatabaseHandler.category = categoryField.getText();
            System.out.println("Категория изменена на "+ DatabaseHandler.category);
            DatabaseHandler.line = lineField.getText();
            System.out.println("Линейка изменена на "+ DatabaseHandler.line);
            DatabaseHandler.maxMarket = maxMarketField.getText();
            System.out.println("Максимальная рыночная цена изменена на "+ DatabaseHandler.maxMarket);
            DatabaseHandler.maxPurchase = maxPurchaseField.getText();
            System.out.println("Максимальная закупочная цена изменена на "+ DatabaseHandler.maxPurchase);
            DatabaseHandler.minMarket = minMarketField.getText();
            System.out.println("Минимальная рыночная цена изменена на "+ DatabaseHandler.minMarket);
            DatabaseHandler.minPurchase = minPurchaseField.getText();
            System.out.println("Минимальная закупочная цена изменена на "+ DatabaseHandler.minPurchase);
            DatabaseHandler.serialNumber = serialNumberField.getText();
            System.out.println("Серийный номер изменен на "+ DatabaseHandler.serialNumber);
        });
    }
}
