package com.example.onlinegradebook.controller.student;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AddGradeController {
    @FXML
    public Button saveButton;
    @FXML
    public TextField newGradeTextField;
    @FXML
    public VBox mainVBox;

    @FXML
    public void initialize() {
        // Add a key combination for the info alert (e.g., Ctrl + I)
        mainVBox.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.I) {
                handleInfoButtonClick(new ActionEvent());
            }
        });
    }

    public void goHome(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlinegradebook/student/student-view.fxml"));
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
        String gradeValue = newGradeTextField.getText();
        try {
            int grade = Integer.parseInt(gradeValue);
            if (grade >= 1 && grade <= 6) {
                Controller.addGrade(String.valueOf(grade));
                goHome(event);
            } else {
                showAlertError("Invalid Grade", "Grade must be in the range 1-6");
            }
        } catch (NumberFormatException | ElementDoesNotExistException e) {
            showAlertError("Invalid Input", "Please enter a valid numeric grade");
        }
    }
    private void showAlertError(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void handleInfoButtonClick(ActionEvent event) {
        showAlert("Information", "To add new grade, you need to enter the value of the new grade.");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
