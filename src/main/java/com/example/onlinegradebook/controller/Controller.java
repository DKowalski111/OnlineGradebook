package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.exception.ElementDoesNotExistException;
import com.example.onlinegradebook.model.School;
import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.model.Student;
import com.example.onlinegradebook.view.SchoolClassView;
import com.example.onlinegradebook.view.StudentView;

import java.util.ArrayList;
import java.util.Arrays;
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

    /**
     * Start of a program method.
     *
     * Currently, there is already some test data.
     * Method creates School class objects and Student class objects.
     * Method calls SchoolView static method to display menu for user.
     */
    public static List<SchoolClass> startProgram(){
        School school = new School();
        school.setName("Szkola Podstawowa nr 9 im. Orlat Lwowskich w Tarnowie");

        List<Student> studenci1D = new ArrayList<>();
        studenci1D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci1D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci1D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci1D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci1D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci1D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci1D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci1D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));

        List<Student> studenci2D = new ArrayList<>();
        studenci2D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci2D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci2D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci2D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci2D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci2D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci2D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci2D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));

        List<Student> studenci3D = new ArrayList<>();
        studenci3D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci3D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci3D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci3D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci3D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci3D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci3D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci3D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));

        List<Student> studenci4D = new ArrayList<>();
        studenci4D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci4D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci4D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci4D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci4D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci4D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci4D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci4D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));

        List<Student> studenci5D = new ArrayList<>();
        studenci5D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci5D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci5D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci5D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci5D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci5D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci5D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci5D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));

        List<Student> studenci6D = new ArrayList<>();
        studenci6D.add(new Student("Dawid", "Kowalski", "300699", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci6D.add(new Student("Michal", "Jordan", "891023", Arrays.asList(6, 6, 4, 1, 4, 5, 6, 3, 3, 3)));
        studenci6D.add(new Student("Janusz", "Biedalski", "102394", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci6D.add(new Student("Wojciech", "Malina", "123456", Arrays.asList(1, 2, 4, 2, 4, 5, 3)));
        studenci6D.add(new Student("Karol", "Szary", "901238", Arrays.asList(6, 6, 6, 6, 6, 6, 6)));
        studenci6D.add(new Student("Amadeusz", "Da Vinci", "901345", Arrays.asList(1, 1, 1, 1, 1, 1, 1)));
        studenci6D.add(new Student("Lobert", "Rewandowski", "420024", Arrays.asList(2, 2, 2, 2, 2, 2, 2,2)));
        studenci6D.add(new Student("Jonasz", "Koran", "502370", Arrays.asList(3,3,3,3,3,3,3,3,3)));


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




        //SchoolView.viewMenu(school);
        return school.getSchoolClasses();
    }

    /**
     * Removes student from SchoolClass object's student list.
     *
     * Method calls specific method of SchoolClass object (removeStudent()) to remove student from SchoolClass object's students list.
     * Handle thrown exceptions.
     *
     * @param schoolClass representation of a SchoolClass object
     * @param id representation of a Student object's id, which user wants to delete
     */
    public static void removeStudent(SchoolClass schoolClass, String id){
        try {
            schoolClass.removeStudent(id);
        } catch (ElementDoesNotExistException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds student to SchoolClass class object's student list.
     * Method calls specific method of SchoolClass class object (addStudent())
     * to add student to SchoolClass object's students list.
     *
     * @param schoolClass representation of a SchoolClass object
     * @param student representation of a Student class object which is to be added
     */
    public static void addStudent(SchoolClass schoolClass, Student student){
        schoolClass.addStudent(student);
    }

    /**
     * Picks a student from a list of available students in a SchoolClass class object's students list.
     * Method calls specific method of SchoolClass class object (pickStudent()) to return a Student class object.
     * Method calls viewMenu() method with a parameter of returned from pickStudent() Student class object.
     * Handle thrown exceptions.
     *
     * @param schoolClass representation of a SchoolClass object
     * @param id representation of a Student object's id, which user wants to pick
     */
    public static void pickStudent(SchoolClass schoolClass, String id){
        try {
            Student tempStudent = schoolClass.pickStudent(id);
            StudentView.viewMenu(tempStudent);
        } catch (ElementDoesNotExistException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes the grade from the Student class object's grades list.
     *
     * Method calls specific method of the Student class object (removeGrade()) to remove the grade from the Student object's grades list.
     * Handles thrown exceptions.
     * @param student representation of the Student object
     * @param index representation of the grade's index in the Student class object's grades list
     */
    public static void removeGrade(Student student, String index) {
        try {
            student.removeGrade(Integer.parseInt(index));
        } catch ( ElementDoesNotExistException e ){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds the grade to the Student class object's grades list.
     * Method calls a specific method of the Student class object (addStudent())
     * to add the grade to the Student class object's students list.
     * Handles thrown exceptions by the called method
     *
     * @param student representation of the Student class object
     * @param grade representation of the grade which is to be added
     */
    public static void addGrade(Student student, String grade) {
        try {
            student.addGrade(Integer.parseInt(grade));
        } catch ( ElementDoesNotExistException e ){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes the SchoolClass class object from the School class object's schoolClasses list.
     *
     * Method calls specific method of the School class object (removeSchoolClass()) to remove the SchoolClass class object
     * from the School class object's schoolClasses list.
     * Handles thrown exceptions.
     *
     * @param school representation of the School class object
     * @param schoolClassName representation of the SchoolClass class object which is to be removed
     */
    public static void removeSchoolClass(School school, String schoolClassName) {
        try{
            school.removeSchoolClass(schoolClassName);
        } catch (ElementDoesNotExistException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Picks a SchoolClass class object from a list of available SchoolClass class objects in a School class object's schoolClasses list.
     * Method calls a specific method of the School class object (pickSchoolClass()) to return a SchoolClass class object.
     * Method calls a viewMenu() static method of a SchoolClassView class with a parameter of the returned from pickSchoolClass() SchoolClass class object method.
     * Handle thrown exceptions.
     *
     * @param school representation of a School class object
     * @param schoolClassName representation of a SchoolClass class object's name which user wants to pick
     */
    public static void pickSchoolClass(School school, String schoolClassName) {
        try{
            SchoolClass tempSchoolClass = school.pickSchoolClass(schoolClassName);
            SchoolClassView.viewMenu(tempSchoolClass);
        } catch (ElementDoesNotExistException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adds the school class to the Student class object's school classes list.
     * Method calls a specific method of the School class object (addSchoolClass())
     * to add the school class to the School class object's schoolClasses list.
     * Handles thrown exceptions by the called method
     *
     * @param school representation of the School class object
     * @param schoolClassName representation of the name of the school class which is to be added
     */
    public static void addClass(School school, String schoolClassName) {
        SchoolClass newSchoolClass = new SchoolClass(schoolClassName);
        school.addSchoolClass(newSchoolClass);
    }
}
