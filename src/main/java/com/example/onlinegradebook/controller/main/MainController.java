package com.example.onlinegradebook.controller.main;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import com.example.onlinegradebook.model.SchoolClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    public VBox mainVBox;
    @FXML
    public Button addButton;
    @FXML
    public Button pickButton;
    @FXML
    public Label headerText;
    @FXML
    private ListView<SchoolClass> classesListView;
    public void initialize(){
        classesListView.getItems().addAll(Controller.startProgram());
        if (!classesListView.getItems().isEmpty()) {
            classesListView.getSelectionModel().selectFirst();
        }
        mainVBox.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.I) {
                handleInfoButtonClick(new ActionEvent());
            }
        });
    }

    @FXML
    private void handleDeleteButtonClick() throws ElementDoesNotExistException {
        Controller.removeSchoolClass(classesListView.getSelectionModel().getSelectedItem());
        classesListView.getItems().remove(classesListView.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void handleAddButtonClick(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/main/add-schoolclass-view.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePickButtonClick(ActionEvent event){
        if (!classesListView.getItems().isEmpty() &&  !classesListView.getSelectionModel().getSelectedItems().isEmpty()) {
            try {
                Controller.setCurrentSchoolClass(classesListView.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/schoolClass/schoolClass-view.fxml"));
                Parent root = loader.load();
                Scene newScene = new Scene(root);
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void handleInfoButtonClick(ActionEvent event) {
        showAlert("Information", "If you want to pick or delete specific school class from the list view, you have to click on that specific school class in the list view.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}