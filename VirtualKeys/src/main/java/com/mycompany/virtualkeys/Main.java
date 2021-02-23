/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class Main {

    static Menu mMenu = new Menu();

    public static void main(String[] args) throws IOException {
        //mainLoop();
        FileService.listContents();
        FileService.createFile("time");
        //FileService.deleteFile("time");
        FileService.listContents();
        FileService.searchFile("Inter.txt");
    }

    public static void mainLoop() {
       // while (mMenu.getStillRunning()) {
            try {
                mMenu.mainMenuLoop();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input mis, try again");
            }
        //}
    }
}
