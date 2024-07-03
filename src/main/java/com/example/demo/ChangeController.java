package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeController {

    String sID = HelloController.selectedID;

    DatabaseHandler dbHandler = new DatabaseHandler();

    private String update(String id, String column, String value) {
        String query = "UPDATE Оборудование SET " + column + " = '" + value + "' WHERE id = '" + id + "'";
        return query;
    }

    public void changeQuery() throws SQLException, ClassNotFoundException {
        String query = update(sID, Equipment.CATEGORY, changeCategoryField.getText())
                + update(sID, Equipment.LINE, changeLineField.getText())
                + update(sID, Equipment.DESCRIPTION, changeDescriptionField.getText())
                + update(sID, Equipment.MARKET_PRICE, changeMarketField.getText())
                + update(sID, Equipment.PURCHASE_PRICE, changePurchaseField.getText())
                + update(sID, Equipment.NAME, changeNameField.getText())
                + update(sID, Equipment.SERIAL_NUMBER, changeSerialNumberField.getText());
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    private void NotificationLoad() {
        FXMLLoader funcFxmlLoader = new FXMLLoader(getClass().getResource("delete-notification.fxml"));
        Scene funcScene = null;
        try {
            funcScene = new Scene(funcFxmlLoader.load(), 320,45);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage funcStage = new Stage();
        funcStage.setTitle("Удаление");
        funcStage.setResizable(false);
        funcStage.setScene(funcScene);
        funcStage.show();
    };

    public void deleteQuery() throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM Оборудование WHERE id = '" + sID + "'";
        PreparedStatement ps = dbHandler.getConnection().prepareStatement(query);
        ps.executeUpdate();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button changeButton;

    @FXML
    private TextField changeCategoryField;

    @FXML
    private TextField changeDescriptionField;

    @FXML
    private TextField changeLineField;

    @FXML
    private TextField changeMarketField;

    @FXML
    private TextField changeNameField;

    @FXML
    private TextField changePurchaseField;

    @FXML
    private TextField changeSerialNumberField;

    @FXML
    private Button deleteButton;

    @FXML
    private Label idLabel;

    @FXML
    void initialize() {
        idLabel.setText("ID:" + sID);
        changeButton.setOnAction(event -> {
            try {
                changeQuery();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        deleteButton.setOnAction(event -> {
            try {
                deleteQuery();
                DeleteNotification.notificationID = sID;
                NotificationLoad();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
