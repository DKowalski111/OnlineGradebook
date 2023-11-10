package com.example.onlinegradebook.view;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.model.School;

import java.util.Scanner;

/**
 * The SchoolView class provides a text-based menu interface for interacting with a School object.
 * It allows users to view information about the school, display available school classes, remove school classes,
 * pick a school class for further actions, and exit the program.
 *
 * *   Author: Dawid Kowalski
 */
public class SchoolView {
    /**
     * Displays a menu for interacting with a School.
     *
     * @param school The School to interact with.
     */
    public static void viewMenu(School school) {
        while (true) {
            System.out.println("\n\n\n\n\n==================================================");
            System.out.println("\n" + school + "\n\n");
            System.out.println("Wybierz jedna z dostepnych opcji: ");
            System.out.println("S - zobacz dostepne w szkole klasy");
            System.out.println("I - dodaj nowa klase");
            System.out.println("R - usun klase ze szkoly");
            System.out.println("C - wybierz klase");
            System.out.println("Q - opusc program");
            Scanner scanner = new Scanner(System.in);
            String usersChoice = scanner.nextLine().toUpperCase();
            switch (usersChoice) {
                case "S":
                    displayClasses(school);
                    break;
                case "I":
                    addClass(school, scanner);
                    break;
                case "R":
                    removeClass(school, scanner);
                    break;
                case "C":
                    pickClass(school, scanner);
                    break;
                case "Q":
                    System.exit(0);
            }
        }
    }

    /**
     * Prompt the user to add a new school class by entering their name.
     *
     * @param school The School to pick a school class from.
     * @param scanner The scanner for user input.
     */
    private static void addClass(School school, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("Wprowadz nazwe klasy, ktora chcesz dodac: ");
        String schoolClassName = scanner.nextLine();
        Controller.addClass(school, schoolClassName);
    }

    /**
     * Prompt the user to pick a school class by entering the class name.
     *
     * @param school The School to pick a school class from.
     * @param scanner The scanner for user input.
     */
    private static void pickClass(School school, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz nazwe klasy, ktora chcesz wybrac: ");
        String schoolClassName = scanner.nextLine();
        Controller.pickSchoolClass(school, schoolClassName);
    }

    /**
     * Prompt the user to remove a school class by entering the class name.
     *
     * @param school The School to remove a school class from.
     * @param scanner The scanner for user input.
     */
    private static void removeClass(School school, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz nazwe klasy, ktora chcesz usunac: ");
        String schoolClassName = scanner.nextLine();
        Controller.removeSchoolClass(school, schoolClassName);
    }

    /**
     * Display a list of school classes in the School.
     *
     * @param school The School to display school classes from.
     */
    private static void displayClasses(School school) {
        school.getSchoolClasses().stream()
                .forEach(schoolClass -> System.out.println(schoolClass));
    }
}
