package com.example.onlinegradebook.view;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.model.SchoolClass;
import com.example.onlinegradebook.model.Student;

import java.util.Scanner;


/**
 * The SchoolClassView class provides a text-based menu interface for interacting with a SchoolClass object.
 * It allows users to view information about the class, display students, add students, remove students,
 * pick a student for further actions, and exit the program.
 *
 * *   Author: Dawid Kowalski
 */
public class SchoolClassView {
    /**
     * Displays a menu for interacting with a SchoolClass.
     *
     * @param schoolClass The SchoolClass to interact with.
     */
    public static void viewMenu(SchoolClass schoolClass) {
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("\n\n\n\n\n==================================================");
            System.out.println("\n" + schoolClass + "\n\n");
            System.out.println("Wybierz jedna z dostepnych opcji: ");
            System.out.println("S - zobacz uczniow w klasie");
            System.out.println("I - dopisz ucznia do klasy");
            System.out.println("R - wypisz ucznia z klasy");
            System.out.println("C - wybierz ucznia, by przeprowadzic na nim akcje");
            System.out.println("B - cofnij do strony wczesniej");
            System.out.println("Q - opusc program");
            Scanner scanner = new Scanner(System.in);
            String usersChoice = scanner.nextLine().toUpperCase();
            switch (usersChoice) {
                case "S":
                    displayStudents(schoolClass);
                    break;
                case "I":
                    addStudent(schoolClass, scanner);
                    break;
                case "R":
                    removeStudent(schoolClass, scanner);
                    break;
                case "C":
                    pickStudent(schoolClass, scanner);
                    break;
                case "B":
                    continueMenu = false;
                    break;
                case "Q":
                    System.exit(0);
            }
        }
    }

    /**
     * Prompt the user to pick a student by entering the student's index.
     *
     * @param schoolClass The SchoolClass to pick a student from.
     * @param scanner The scanner for user input.
     */
    private static void pickStudent(SchoolClass schoolClass, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz indeks studenta, ktorego chcesz wybrac: ");
        String id = scanner.nextLine();
        Controller.pickStudent(schoolClass, id);
    }

    /**
     * Prompt the user to remove a student by entering the student's index.
     *
     * @param schoolClass The SchoolClass to remove a student from.
     * @param scanner The scanner for user input.
     */
    private static void removeStudent(SchoolClass schoolClass, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz indeks studenta, ktorego chcesz usunac: ");
        String id = scanner.nextLine();
        Controller.removeStudent(schoolClass, id);
    }

    /**
     * Prompt the user to add a new student by entering their first name, last name, and index.
     *
     * @param schoolClass The SchoolClass to add a student to.
     * @param scanner The scanner for user input.
     */
    private static void addStudent(SchoolClass schoolClass, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz imie studenta, ktorego chcesz dodac: ");
        String firstName = scanner.nextLine();
        System.out.println("\nWprowadz nazwisko studenta, ktorego chcesz dodac: ");
        String lastName = scanner.nextLine();
        System.out.println("\nWprowadz indeks studenta, ktorego chcesz dodac: ");
        String id = scanner.nextLine();
        Controller.addStudent(schoolClass, new Student(firstName, lastName, id));
    }

    /**
     * Display a list of students in the SchoolClass.
     *
     * @param schoolClass The SchoolClass to display students from.
     */
    private static void displayStudents(SchoolClass schoolClass) {
        System.out.println("\n\n\n\n\n==================================================");
        schoolClass.getStudents().forEach(student -> System.out.println(student));
    }
}
