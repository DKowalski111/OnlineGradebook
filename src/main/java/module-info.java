module com.example.onlinegradebook {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlinegradebook to javafx.fxml;
    exports com.example.onlinegradebook;
    exports com.example.onlinegradebook.controller;
    opens com.example.onlinegradebook.controller to javafx.fxml;
    exports com.example.onlinegradebook.controller.main;
    opens com.example.onlinegradebook.controller.main to javafx.fxml;
    exports com.example.onlinegradebook.controller.schoolClass;
    opens com.example.onlinegradebook.controller.schoolClass to javafx.fxml;
    exports com.example.onlinegradebook.controller.student;
    opens com.example.onlinegradebook.controller.student to javafx.fxml;
}