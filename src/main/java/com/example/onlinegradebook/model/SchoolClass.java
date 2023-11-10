package com.example.onlinegradebook.model;


import com.example.onlinegradebook.exception.ElementDoesNotExistException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * The SchoolClass class is a model of a school class.
 *
 * This class holds information about school class' name and a list of students.
 * It provides methods for adding, removing, and retrieving students, as well as accessing the school class' name.
 *
 * Examples:
 * SchoolClass schoolClass = new SchoolClass();
 * schoolClass.setName("6A");
 * schoolClass.addStudent(theStudent);
 * try{
 *     schoolClass.removeStudent(studentsId);
 * } catch (NoSuchElementException e){
 *     System.out.println(e.getMessage());
 * }
 *
 * *   Author: Dawid Kowalski
 */
public class SchoolClass {
    /**
     * Name of the school class
     */
    private String name;

    /**
     * List of students in the class
     */
    private List<Student> students;

    public SchoolClass() {
        this.students = new ArrayList<>();
    }

    public SchoolClass(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public SchoolClass(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    /**
     * Method responsible for adding a new Student class object to the list of students
     * @param student Student class object to be added
     */
    public void addStudent(Student student){
        this.students.add(student);
    }

    /**
     * Method responsible for removing Student class object from the students' list
     * @param id index of the Student class object a user wants to remove
     * @throws ElementDoesNotExistException when the provided id as the parameter is not found
     */
    public void removeStudent(String id) throws ElementDoesNotExistException{
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (Objects.equals(student.getId(), id)) {
                iterator.remove();
                return;
            }
        }
        throw new ElementDoesNotExistException("Nie znaleziono takiego obiektu: " + id);
    }

    /**
     * Method responsible for picking a Student class object from the list of student when
     * a user wants to perform some actions on the student.
     *
     * @param id index of the Student class object user wants to pick
     * @return Student class object picked by user
     * @throws ElementDoesNotExistException when provided index of the Student class object does not exist
     */
    public Student pickStudent(String id) throws ElementDoesNotExistException{
        for(Student student : students){
            if(Objects.equals(student.getId(), id)){
                return student;
            }
        }
        throw new ElementDoesNotExistException("Nie znaleziono takiego obiektu: " + id);
    }

    /**
     * Gets the name of the school class.
     *
     * @return The name of the school class.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the school class.
     *
     * @param name The new name of the school class.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of students in the school class.
     *
     * @return The list of students.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students in the school class.
     *
     * @param students The new list of students.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Returns a string representation of the school class, including its name and the number of students.
     *
     * @return A string representing the school class, including its name and the number of students.
     */
    @Override
    public String toString() {
        return "Klasa: " + this.name;
    }
}
