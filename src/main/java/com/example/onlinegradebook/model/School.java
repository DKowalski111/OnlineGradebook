package com.example.onlinegradebook.model;

import com.example.onlinegradebook.exception.ElementDoesNotExistException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * The School class is a model of a school.
 *
 * This class holds information about school's name and a list of school classes.
 * It provides methods for adding, removing, and retrieving school classes, as well as accessing the school's name.
 *
 * Examples:
 * School school = new School();
 * school.setName("XYZ");
 * school.addSchoolClass(schoolClassXYZ);
 * try{
 *     school.removeSchoolClass(schoolClassName);
 * } catch (NoSuchElementException e){
 *     System.out.println(e.getMessage());
 * }
 *
 * *   Author: Dawid Kowalski
 */

public class School {
    /**
     * School name
     */
    private String name;
    /**
     * List of school classes
     */
    private List<SchoolClass> schoolClasses;

    public School() {
        this.schoolClasses = new ArrayList<>();
    }

    public School(String name, List<SchoolClass> schoolClasses) {
        this.name = name;
        this.schoolClasses = schoolClasses;
    }

    /**
     * Adds a new SchoolClass class object to the schoolClasses list
     * @param schoolClass representation of a SchoolClass class object to be added
     */

    public void addSchoolClass(SchoolClass schoolClass){
        this.schoolClasses.add(schoolClass);
    }

    /**
     * Removes a school class from the schoolClasses list
     * @param schoolClassName
     * @throws ElementDoesNotExistException when provided school class name does not exist
     */
    public void removeSchoolClass(String schoolClassName) throws ElementDoesNotExistException {
        Iterator<SchoolClass> iterator = schoolClasses.iterator();
        while (iterator.hasNext()) {
            SchoolClass schoolClass = iterator.next();
            if (Objects.equals(schoolClass.getName(), schoolClassName)) {
                iterator.remove();
                return;
            }
        }
        throw new ElementDoesNotExistException("Nie znaleziono takiego obiektu: " + schoolClassName);
    }

    /**
     * Picks school class user wants to interact with
     * @param schoolClassName name of a school class
     * @return SchoolClass class object
     * @throws ElementDoesNotExistException when the provided name of the school class does not exist
     */

    public SchoolClass pickSchoolClass(String schoolClassName) throws ElementDoesNotExistException {
        for(SchoolClass schoolClass : schoolClasses){
            if(Objects.equals(schoolClass.getName(), schoolClassName)){
                return schoolClass;
            }
        }
        throw new ElementDoesNotExistException("Nie znaleziono takiego obiektu: " + schoolClassName);
    }

    /**
     * Gets the name of the school.
     *
     * @return The name of the school.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the school.
     *
     * @param name The new name of the school.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of school classes associated with this school.
     *
     * @return The list of school classes.
     */
    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    /**
     * Sets the list of school classes associated with this school.
     *
     * @param schoolClasses The new list of school classes.
     */
    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    /**
     * Returns a string representation of the school, which is the school's name.
     *
     * @return The name of the school as a string.
     */
    @Override
    public String toString() {
        return this.name;
    }
}
