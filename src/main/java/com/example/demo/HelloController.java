package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloController {
    public static String selectedID;
    DatabaseHandler dbHandler = new DatabaseHandler();
    ObservableList<Equipment> list = FXCollections.observableArrayList();
    public void searchQuery(String Name) throws SQLException, ClassNotFoundException {
        ResultSet res = null;
        String query = "SELECT * FROM Оборудование WHERE " + Equipment.NAME + " LIKE '%" + Name +
                "%' AND " + Equipment.CATEGORY + " LIKE '%" + SearchCategoryController.category +
                "%' AND " + Equipment.LINE + " LIKE'%" + SearchCategoryController.line +
                "%' AND " + Equipment.SERIAL_NUMBER + " LIKE'%" + SearchCategoryController.serialNumber +
                "%' AND " + Equipment.MARKET_PRICE + " > '" + SearchCategoryController.minMarket +
                "' AND " + Equipment.MARKET_PRICE + " < '" + SearchCategoryController.maxMarket +
                "' AND " + Equipment.PURCHASE_PRICE + " > '" + SearchCategoryController.minPurchase +
                "' AND " + Equipment.PURCHASE_PRICE + " < '" + SearchCategoryController.maxPurchase +
                "';";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        res = ps.executeQuery();
        list.removeAll(list);
        table.getItems().clear();
        while (res.next()){
            System.out.println(res.getString(1));
            System.out.println(res.getString(2));
            System.out.println(res.getString(3));
            list.addAll(new Equipment(
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)));
        };
        table.getItems().addAll(list);
    }
    private void InitColumns() {
        tableCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableComments.setCellValueFactory(new PropertyValueFactory<>("comments"));
        tableDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tableID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableLine.setCellValueFactory(new PropertyValueFactory<>("line"));
        tableMarketPrice.setCellValueFactory(new PropertyValueFactory<>("marketPrice"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablePurchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        tableSerialNumber.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
    }

    private void PageLoad(String fxmlString, int v, int v1, String title) {
        FXMLLoader funcFxmlLoader = new FXMLLoader(getClass().getResource(fxmlString));
        Scene funcScene = null;
        try {
            funcScene = new Scene(funcFxmlLoader.load(), v,v1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage funcStage = new Stage();
        funcStage.setTitle(title);
        funcStage.setResizable(false);
        funcStage.setScene(funcScene);
        funcStage.show();
    };

    public void defineSelectedID() {
        Equipment selected = table.getSelectionModel().getSelectedItem();
        selectedID = selected.getId();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonCategories;

    @FXML
    private Button buttonChange;

    @FXML
    private Button buttonReports;

    @FXML
    private Button buttonSearch;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Equipment> table;

    @FXML
    private TableColumn<Equipment, String> tableCategory;

    @FXML
    private TableColumn<Equipment, String> tableComments;

    @FXML
    private TableColumn<Equipment, String> tableDescription;

    @FXML
    private TableColumn<Equipment, String> tableID;

    @FXML
    private TableColumn<Equipment, String> tableLine;

    @FXML
    private TableColumn<Equipment, String> tableMarketPrice;

    @FXML
    private TableColumn<Equipment, String> tableName;

    @FXML
    private TableColumn<Equipment, String> tablePurchasePrice;

    @FXML
    private TableColumn<Equipment, String> tableSerialNumber;

    @FXML
    void initialize() {
        InitColumns();
        buttonCategories.setOnAction(event -> {
            PageLoad("search-category.fxml", 488, 263, "Категории");
        });
        buttonAdd.setOnAction(event -> {
            PageLoad("add.fxml", 700, 425, "Добавление");
        });
        buttonChange.setOnAction(event -> {
            defineSelectedID();
            PageLoad("change.fxml", 700, 425, "Изменение");
        });
        buttonSearch.setOnAction(event -> {
            try {
                searchQuery(searchField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
