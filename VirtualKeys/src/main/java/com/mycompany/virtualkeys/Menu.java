/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class Menu {

    private int mainChoice;
    private int subChoice;
    final static ArrayList<String> mainMenu = new ArrayList<String>(Arrays.asList("Main Menu:\n","1. Show contents of directory",
        "2. Add, Delete, or Search Files",
        "3. Close Application"));
    final static ArrayList<String> subMenu = new ArrayList<String>(Arrays.asList("File Service Menu:\n","1. Add file to current directory",
        "2. Delete file from current directory",
        "3. Search for file in current directory",
        "4. Return to main menu"));
    Scanner in = new Scanner(System.in);

    public void showMainMenu() {
        mainMenu.forEach(n -> System.out.println(n));
    }

    public void showSubMenu() {
        subMenu.forEach(n -> System.out.println(n));
    }

    public void mainMenuLoop() throws IOException, InputMismatchException {
        showMainMenu();
        do {                                                            //Loop until valid input is given
            try {
                System.out.println("\nEnter your choice: ");
                mainChoice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again.");
                mainChoice = 0;
            }
            in.nextLine();
        } while (mainChoice <= 0);
        switch (mainChoice) {                                           //Loop to go through main menu until user chooses to close application
            case 1:
                FileService.listContents();                             //Method for listing directory contents alphabetically
                System.out.println();
                mainMenuLoop();
                break;
            case 2:
                System.out.println();
                subMenuLoop();                                          //Method to display file service menu
                break;
            case 3:                                                     //Closes application
                System.out.println("Closing application...\nThank you!");
                break;
            default:                                                    //Invalid input given
                System.out.println("\nInvalid input, try again\n");
                mainMenuLoop();
        }

    }

    public void subMenuLoop() throws IOException, InputMismatchException {
        showSubMenu();
        do {                                                            //Loop until valid input is given
            try {
                System.out.println("\nEnter your choice: ");
                subChoice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again.");
                subChoice = 0;
            }
            in.nextLine();
        } while (subChoice <= 0);
        switch (subChoice) {                                            //Loop to go through sub menu until user chooses to return to main menu
            case 1:
                System.out.println("\nTo create a file, enter the name of the file followed by the file extension (ex. abcd.txt):");
                String nameAdd = in.nextLine();
                FileService.createFile(nameAdd);                        //Method to create a file
                System.out.println();
                subMenuLoop();
                break;
            case 2:
                System.out.println("\nTo delete a file, enter the name of the file followed by the file extension (ex. abcd.txt):");
                String nameDel = in.nextLine();
                FileService.deleteFile(nameDel);                        //Method to delete a file
                System.out.println();
                subMenuLoop();
                break;
            case 3:
                System.out.println("\nTo search for a file, enter the name of the file followed by the file extension (ex. abcd.txt):");
                String nameSer = in.nextLine();
                FileService.searchFile(nameSer);                        //Method to search for a file
                System.out.println();
                subMenuLoop();
                break;
            case 4:
                System.out.println();
                mainMenuLoop();                                         //Return to main menu
                break;
            default:
                System.out.println("\nInvalid input, try again\n");     //Invalid input given
                subMenuLoop();
        }

    }
}
