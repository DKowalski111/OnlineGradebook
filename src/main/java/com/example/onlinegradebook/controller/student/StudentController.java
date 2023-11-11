package com.example.onlinegradebook.controller.student;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import com.example.onlinegradebook.model.Grade;
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

public class StudentController {
    @FXML
    public VBox mainVBox;
    @FXML
    public Button addButton;
    @FXML
    public Label headerText;
    @FXML
    private ListView<Grade> gradesListView;

    public void initialize(){
        gradesListView.getItems().addAll(Controller.getGradesFromCurrentStudent());
        if (!gradesListView.getItems().isEmpty()) {
            gradesListView.getSelectionModel().selectFirst();
        }
        mainVBox.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.I) {
                handleInfoButtonClick(new ActionEvent());
            }
        });
    }

    @FXML
    private void handleDeleteButtonClick() throws ElementDoesNotExistException {
        Controller.removeGrade(gradesListView.getSelectionModel().getSelectedItem());
        gradesListView.getItems().remove(gradesListView.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void handleAddButtonClick(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/student/add-grade-view.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleGoBackButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/schoolClass/schoolClass-view.fxml"));
            Parent root = loader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleInfoButtonClick(ActionEvent event) {
        showAlert("Information", "If you want to delete specific grade from the list view, you have to click on that specific grade in the list view.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
