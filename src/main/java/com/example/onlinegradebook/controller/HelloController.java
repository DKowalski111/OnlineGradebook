package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.SchoolClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public VBox mainVBox;
    @FXML
    public Button addButon;
    @FXML
    public Button pickButton;
    @FXML
    public Label headerText;
    @FXML
    private Button deleteButton;
    @FXML
    private ListView<SchoolClass> classesListView;
    public void initialize(){
        classesListView.getItems().addAll(Controller.startProgram());

        headerText.getStyleClass().add("main-text");
        mainVBox.getStyleClass().add("body");
        deleteButton.getStyleClass().add("button-delete");
        addButon.getStyleClass().add("button-add");
        pickButton.getStyleClass().add("button-pick");

        if (!classesListView.getItems().isEmpty()) {
            classesListView.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void handleDeleteButtonClick(){
        classesListView.getItems().remove(classesListView.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void handleAddButtonClick(ActionEvent event){
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/view/YourFXMLFile.fxml"));
            Parent root = loader.load();

            // Create a new Scene
            Scene newScene = new Scene(root);

            // Get the Stage from the event source
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

            // Set the new Scene
            stage.setScene(newScene);

        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }


}