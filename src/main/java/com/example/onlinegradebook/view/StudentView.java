package com.example.onlinegradebook.view;

import com.example.onlinegradebook.controller.Controller;
import com.example.onlinegradebook.model.Student;

import java.util.Scanner;

/**
 * The StudentView class provides a text-based menu interface for interacting with a Student object.
 * It allows users to view information about the student, display the student's grades, add grades, remove grades,
 * return to the previous page, and exit the program.
 *
 * *   Author: Dawid Kowalski
 */

public class StudentView {
    /**
     * Displays a menu for interacting with a Student.
     *
     * @param student The Student to interact with.
     */
    public static void viewMenu(Student student){
        boolean continueMenu = true;
        while (continueMenu) {
            System.out.println("\n\n\n\n\n==================================================");
            System.out.println("\n" + student + "\n\n");
            System.out.println("Wybierz jedna z dostepnych opcji: ");
            System.out.println("S - zobacz oceny wybranego ucznia");
            System.out.println("I - dopisz uczniowi ocene");
            System.out.println("R - usun uczniowi ocene");
            System.out.println("B - cofnij do strony wczesniej");
            System.out.println("Q - opusc program");
            Scanner scanner = new Scanner(System.in);
            String usersChoice = scanner.nextLine().toUpperCase();
            switch (usersChoice) {
                case "S":
                    displayGrades(student);
                    break;
                case "I":
                    addGrade(student, scanner);
                    break;
                case "R":
                    removeGrade(student, scanner);
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
     * Prompt the user to remove a grade from the student by entering the index of the grade.
     *
     * @param student The Student to remove a grade from.
     * @param scanner The scanner for user input.
     */
    private static void removeGrade(Student student, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz indeks oceny ( kolejnosc w liscie od lewej, indeksowanie od zera ), ktora chcesz usunac: ");
        String index = scanner.nextLine();
        Controller.removeGrade(student, index);
    }

    /**
     * Prompt the user to add a grade to the student by entering the grade value.
     *
     * @param student The Student to add a grade to.
     * @param scanner The scanner for user input.
     */
    private static void addGrade(Student student, Scanner scanner) {
        System.out.println("\n\n\n\n\n==================================================");
        System.out.println("\nWprowadz ocene, ktora chcesz dodac: ");
        String grade = scanner.nextLine();
        Controller.addGrade(student, grade);
    }

    /**
     * Display a list of grades for the student.
     *
     * @param student The Student to display grades for.
     */
    private static void displayGrades(Student student) {
        System.out.println("\n\n\n\n\n==================================================");
        for(int grade : student.getGrades()){
            System.out.print("  |  " + grade + "  |  ");
        }
    }
}
