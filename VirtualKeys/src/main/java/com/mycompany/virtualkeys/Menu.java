/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rajat
 */
public class Menu {

    private final static String directory = "src/main/java/com/mycompany/virtualkeys/testdirectory";
    private int mainChoice;
    private int subChoice;
    private boolean stillRunning = true;
    final static String[] mainMenu = {"1. Show contents of directory",
        "2. Add, Delete, or Search Files",
        "3. Close Application"};
    final static String[] subMenu = {"1. Add file to current directory",
        "2. Delete file from current directory",
        "3. Search for file in current directory",
        "4. Return to main menu"};
    Scanner in = new Scanner(System.in);

    // public Menu(String directory) {
    //     super(directory);
    // }
    public void showMainMenu() {
        for (String mainMenu1 : mainMenu) {
            System.out.println(mainMenu1);
        }
    }

    public void showSubMenu() {
        for (String subMenu1 : subMenu) {
            System.out.println(subMenu1);
        }
    }

    public void mainMenuLoop() throws IOException, InputMismatchException {
        showMainMenu();
        do {
            try {
                mainChoice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again.");
                //subMenuLoop();
            }
            in.nextLine();
        } while (mainChoice <= 0);
        switch (mainChoice) {
            case 1:
                //method for listing directory contents
                FileService.listContents();
                mainMenuLoop();
                break;
            case 2:
                subMenuLoop();
                break;
            case 3:
                System.out.println("Closing application...\nThank you!");
                stillRunning = false;
                break;
            default:
                System.out.println("Invalid input, try again");
                mainMenuLoop();
            //loop again
        }

    }

    public void subMenuLoop() throws IOException, InputMismatchException {
        showSubMenu();
        do {
            try {
                subChoice = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again.");
                //subMenuLoop();
            }
            in.nextLine();
        } while (subChoice <= 0);
        switch (subChoice) {
            case 1:
                //method to add file
                System.out.println("Enter the name of the file you want to add:");
                String nameAdd = in.next();
                FileService.createFile(nameAdd);
                subMenuLoop();
                break;
            case 2:
                //method to delete file
                System.out.println("Enter the name of the file you want to delete:");
                String nameDel = in.next();
                FileService.deleteFile(nameDel);
                subMenuLoop();
                break;
            case 3:
                //method to search file
                System.out.println("Enter the name of the file you want to search:");
                String nameSer = in.next();
                subMenuLoop();
                break;
            case 4:
                //return to main menu
                mainMenuLoop();
                break;
            default:
                System.out.println("Invalid input, try again");
                subMenuLoop();
            //loop again
        }

    }

    public boolean getStillRunning() {
        return stillRunning;
    }

    public void setStillRunning(boolean stillRunning) {
        this.stillRunning = stillRunning;
    }
}
