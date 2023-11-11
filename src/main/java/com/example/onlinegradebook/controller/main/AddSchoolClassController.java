package com.example.onlinegradebook.controller.main;

import com.example.onlinegradebook.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AddSchoolClassController {
    @FXML
    public Button saveButton;
    @FXML
    public ChoiceBox numberChoiceBox;
    @FXML
    public ChoiceBox letterChoiceBox;
    @FXML
    public VBox mainVBox;

    @FXML
    public void initialize() {
        mainVBox.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.I) {
                handleInfoButtonClick(new ActionEvent());
            }
        });
    }

    public void goHome(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/main/main-view.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleDiscardButtonClick(ActionEvent event){
        goHome(event);
    }

    @FXML
    public void handleSaveButtonClick(ActionEvent event) {
        String firstChoiceValue = (String) numberChoiceBox.getValue();
        String secondChoiceValue = (String) letterChoiceBox.getValue();
        if(firstChoiceValue != null && secondChoiceValue != null){
            Controller.addClass(firstChoiceValue+secondChoiceValue);
            goHome(event);
        } else {
            showAlertError("Invalid input", "Text fields cannot be empty.");
        }
    }

    public void handleInfoButtonClick(ActionEvent event) {
        showAlertInfo("Information", "To add new school class, you need to enter the year and the name for the new school class.");
    }

    private void showAlertInfo(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showAlertError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}