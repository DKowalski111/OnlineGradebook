package com.example.onlinegradebook.controller.main;

import com.example.onlinegradebook.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private VBox mainVBox;

    @FXML
    private Label headerText;

    @FXML
    private Button addButton;

    @FXML
    private Button discardButton;
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
        }

    }
}