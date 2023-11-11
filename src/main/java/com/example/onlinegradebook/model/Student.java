package com.example.onlinegradebook.model;
import com.example.onlinegradebook.exception.ElementDoesNotExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The Student class is a model of a student.
 *
 * This class holds information about student's name and a list of students' grades.
 * It provides methods for adding and removing grades.
 *
 * Examples:
 * Student student = new Student("ABC", "XYZ", Arrays.asList(1, 2, 4, 2, 4, 5, 3));
 * try{
 *     student.removeGrade(1);
 * } catch (NoSuchElementException e){
 *     System.out.println(e.getMessage());
 * }
 *
 * *   Author: Dawid Kowalski
 */

public class Student {
    private static Long lastStudentsId = 100000L;
    /**
     * First name of the student.
     */
    private String firstName;

    /**
     * Last name of the student.
     */
    private String lastName;

    /**
     * Index of the student.
     */
    private Long id;

    /**
     * List of student's grades.
     */
    private List<Grade> grades;

    public Student() {
        this.id = lastStudentsId++;
        this.grades = new ArrayList<>();
    }

    public Student(String firstName, String lastName, List<Grade> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = lastStudentsId++;
        this.grades = new ArrayList<>();
        this.grades.addAll(grades);
    }
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = lastStudentsId++;
        this.grades = new ArrayList<>();
    }

    /**
     * Method responsible for adding new grade to the Student class object's grades list.
     * @param grade grade to be added
     * @throws ElementDoesNotExistException when provided grade is not valid ( has to be between 1 and 6 )
     */
    public void addGrade(Grade grade) throws ElementDoesNotExistException {
        if(grade.getValue() <= 6 && grade.getValue() >= 1){
            this.grades.add(grade);
        }
        else {
            throw new ElementDoesNotExistException("Ocena musi byc pomiedzy 1 i 6");
        }
    }

    /**
     * Method responsible for removing a grade from the Student class object's grades list.
     * @param indexOfGrade index of the grade in the grades list to be removed
     * @throws ElementDoesNotExistException when the grade user wants to delete of id provided in the param is not found
     */
    public void removeGrade(Long indexOfGrade) throws ElementDoesNotExistException{
        for(Grade grade : grades){
            if(Objects.equals(grade.getId(), indexOfGrade)){
                grades.remove(grade);
                break;
            }
        }
    }

    /**
     * Gets the first name of the student.
     *
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName The new first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName The new last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student ID.
     *
     * @return The student ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the student ID.
     *
     * @param id The new student ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the list of grades for the student.
     *
     * @return The list of grades.
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     * Sets the list of grades for the student.
     *
     * @param grades The new list of grades.
     */
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    /**
     * Returns a string representation of the student, including their ID, first name, last name, and the number of grades.
     *
     * @return A string representing the student, including their ID, first name, last name, and the number of grades.
     */
    @Override
    public String toString() {
        return "Indeks: " + this.getId() + "\tImie: " + this.firstName + "\tNazwisko: " + this.lastName + "\tLiczba ocen: "
                + this.grades.size();
    }
}
