/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.util.Scanner;




/**
 *
 * @author Rajat
 */
public class Menu {
    
    private int choice;
    private boolean stillRunning = true;
    final static String[] mainMenu = {"1. Show contents of directory", 
        "2. Add, Delete, or Search Files", 
        "3. Close Application"};
    final static String[] subMenu = {"1. Add file to current directory",
        "2. Delete file from current directory",
        "3. Search for file in current directory",
        "4. Return to main menu"};
    Scanner in = new Scanner(System.in);
    
    
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

   
    public void mainMenuLoop() {
        showMainMenu();
        choice = in.nextInt();
        switch (choice) {
            case 1:
                //method for listing directory contents
                mainMenuLoop();
                break;
            case 2:
                subMenuLoop();
                mainMenuLoop();
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

  
    public void subMenuLoop() {
        showSubMenu();
        choice = in.nextInt();
        switch (choice) {
            case 1:
                //method to add file
                subMenuLoop();
                break;
            case 2:
                //method to delete file
                subMenuLoop();
                break;
            case 3:
                //method to search file
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

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
    
    public boolean getStillRunning(){
        return stillRunning;
    }
    
    public void setStillRunning(boolean stillRunning){
        this.stillRunning = stillRunning;
    }
}
