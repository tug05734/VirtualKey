/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.io.IOException;

/**
 *
 * @author Rajat
 */
public class Main {
    static Menu mMenu = new Menu();

    public static void main(String[] args) throws IOException {
        System.out.println("***************************************\n"
                         + "***************************************\n"
                         + "        WELCOME TO LOCKEDME.COM        \n"
                         + "***************************************\n"
                         + "***************************************\n");
        mMenu.mainMenuLoop();
    }
}
