package com.example.onlinegradebook.controller.schoolClass;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import com.example.onlinegradebook.model.Student;
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

public class SchoolClassController {
    @FXML
    public VBox mainVBox;
    @FXML
    public Button addButton;
    @FXML
    public Button pickButton;
    @FXML
    public Label headerText;
    @FXML
    private ListView<Student> studentsListView;

    public void initialize(){
        studentsListView.getItems().addAll(Controller.getStudentsFromCurrentSchoolClass());
        if (!studentsListView.getItems().isEmpty()) {
            studentsListView.getSelectionModel().selectFirst();
        }
        mainVBox.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.I) {
                handleInfoButtonClick(new ActionEvent());
            }
        });
    }

    @FXML
    private void handleDeleteButtonClick() throws ElementDoesNotExistException {
        Controller.removeStudent(studentsListView.getSelectionModel().getSelectedItem());
        studentsListView.getItems().remove(studentsListView.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void handleAddButtonClick(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/schoolClass/add-student-view.fxml"));
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
        if (!studentsListView.getItems().isEmpty() &&  !studentsListView.getSelectionModel().getSelectedItems().isEmpty()) {
            try {
                Controller.setCurrentStudent(studentsListView.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/student/student-view.fxml"));
                Parent root = loader.load();
                Scene newScene = new Scene(root);
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(newScene);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleGoBackButtonClick(ActionEvent event) {
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

    public void handleInfoButtonClick(ActionEvent event) {
        showAlert("Information", "If you want to pick or delete specific student from the list view, you have to click on that specific student in the list view.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
