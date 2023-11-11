package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import com.example.onlinegradebook.model.Grade;
import com.example.onlinegradebook.model.School;
import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.model.Student;

import java.util.Comparator;
import java.util.List;

/**
 * The Controller class is an intermediary between classes responsible for viewing user content
 * and managing interaction with underlying models.
 *
 * The class should be called in a main method
 *
 * Responsibilities:
 * - Handling user's action in application by calling models' methods ( removing students from class, removing grades from list of student's grades,
 *      removing classes from school, adding new students to class, adding new grades to user's grades list, adding new
 *      classes to school, picking specific class or specific student to perform on it actions )
 * - Ensuring data consistency and integrity during user interactions.
 *
 * Example:
 * Controller.startProgram();
 *
 * *   Author: Dawid Kowalski
 */

public class Controller {
    private static School school;
    private static SchoolClass currentSchoolClass;
    private static Student currentStudent;


    /**
     * Start of a program method.
     *
     * Currently, there is already some test data.
     * Method creates School class objects and Student class objects.
     * Method calls SchoolView static method to display menu for user.
     */
    public static void setCurrentSchoolClass(SchoolClass schoolClassPicked){
        Controller.currentSchoolClass = schoolClassPicked;
    }

    public static void setCurrentStudent(Student studentPicked){
        Controller.currentStudent = studentPicked;
    }

    public static List<Student> getStudentsFromCurrentSchoolClass(){
        return Controller.currentSchoolClass.getStudents();
    }

    public static List<Grade> getGradesFromCurrentStudent(){
        return Controller.currentStudent.getGrades();
    }
    public static void removeSchoolClass(SchoolClass schoolClass) throws ElementDoesNotExistException {
        school.removeSchoolClass(schoolClass.getName());
    }
    public static void removeStudent(Student student) throws ElementDoesNotExistException {
        currentSchoolClass.removeStudent(student.getId());
    }
    public static void setSchool(School schoolInput){
        school = schoolInput;
    }
    public static void addClass(String schoolClassName) {
        SchoolClass newSchoolClass = new SchoolClass(schoolClassName);
        Controller.school.addSchoolClass(newSchoolClass);
    }
    public static void addStudent(String firstName, String secondName) {
        Student newStudent = new Student(firstName, secondName);
        Controller.currentSchoolClass.addStudent(newStudent);
    }
    public static List<SchoolClass> startProgram(){
        Controller.school.getSchoolClasses().sort(Comparator.comparing(SchoolClass::getName));
        return Controller.school.getSchoolClasses();
    }

    public static void removeGrade(Grade selectedItem) throws ElementDoesNotExistException {
        Controller.currentStudent.removeGrade(selectedItem.getId());
    }

    public static void addGrade(String gradeValue) throws ElementDoesNotExistException {
        Controller.currentStudent.addGrade(new Grade(Integer.parseInt(gradeValue)));
    }
}
