package com.example.onlinegradebook;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.model.Grade;
import com.example.onlinegradebook.model.School;
import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.model.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Online Gradebook");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        //Controller.startProgram();
        School school = new School();
        List<Student> studenci1D = new ArrayList<>();
        studenci1D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci1D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci1D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci1D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci1D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci1D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci1D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci1D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));


        List<Student> studenci2D = new ArrayList<>();
        studenci2D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci2D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci2D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci2D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci2D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci2D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci2D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci2D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));



        List<Student> studenci3D = new ArrayList<>();
        studenci3D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci3D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci3D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci3D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci3D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci3D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci3D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci3D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));

        List<Student> studenci4D = new ArrayList<>();
        studenci4D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci4D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci4D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci4D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci4D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci4D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci4D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci4D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));

        List<Student> studenci5D = new ArrayList<>();
        studenci5D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci5D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci5D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci5D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci5D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci5D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci5D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci5D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));

        List<Student> studenci6D = new ArrayList<>();
        studenci6D.add(new Student("Dawid", "Kowalski", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci6D.add(new Student("Michał", "Jordan", getGradeList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci6D.add(new Student("Janusz", "Biedalski", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci6D.add(new Student("Wojciech", "Malina", getGradeList(1, 2, 4, 2, 4, 5, 3)));
        studenci6D.add(new Student("Karol", "Szary", getGradeList(6, 6, 6, 6, 6, 6, 6)));
        studenci6D.add(new Student("Amadeusz", "Da Vinci", getGradeList(1, 1, 1, 1, 1, 1, 1)));
        studenci6D.add(new Student("Lobert", "Rewandowski", getGradeList(2, 2, 2, 2, 2, 2, 2, 2)));
        studenci6D.add(new Student("Jonasz", "Koran", getGradeList(3, 3, 3, 3, 3, 3, 3, 3)));

        SchoolClass Id = new SchoolClass("1D", studenci1D);
        SchoolClass IId = new SchoolClass("2D", studenci2D);
        SchoolClass IIId = new SchoolClass("3D", studenci3D);
        SchoolClass IVd = new SchoolClass("4D", studenci4D);
        SchoolClass Vd = new SchoolClass("5D", studenci5D);
        SchoolClass VId = new SchoolClass("6D", studenci6D);

        school.addSchoolClass(Id);
        school.addSchoolClass(IId);
        school.addSchoolClass(IIId);
        school.addSchoolClass(IVd);
        school.addSchoolClass(Vd);
        school.addSchoolClass(VId);
        Controller.setSchool(school);
        launch();
    }

    private static List<Grade> getGradeList(Integer... grades) {
        List<Grade> gradeList = new ArrayList<>();
        for (Integer grade : grades) {
            gradeList.add(new Grade(grade));
        }
        return gradeList;
    }
}