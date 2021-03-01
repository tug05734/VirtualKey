/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rajat
 */
public class FileService {

    private final static String directory = "src/main/java/com/mycompany/virtualkeys/testdirectory";
    private static ArrayList<String> dirContents = new ArrayList<String>();

    public FileService(String directory) {
    }

    public static void listContents() throws IOException {                  //Will print out the main directory alphabetically
        try {
            dirContents.removeAll(dirContents);
            System.out.println("\nPrinting contents of directory alphabetically: ");
            for (Path path : Files.newDirectoryStream(Paths.get(directory))) {
                path = path.normalize();
                dirContents.add(path.getFileName().toString());
            }
        } catch (IOException e) {
            System.out.println("Error I/O Exception. Returning to menu");
        }
        Collections.sort(dirContents, String.CASE_INSENSITIVE_ORDER);
        dirContents.forEach(n -> System.out.println(n));
    }

    public static void createFile(String fileName) throws IOException {     //Creates a file in the directory if it doesn't exist
        try {
            File file = new File(directory + "/" + fileName);
            if (file.createNewFile()) {
                System.out.println("File successfully added!");
            } else {
                System.out.println("Unsuccessful. File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error I/O Exception. Returning to menu");
        }
    }

    public static void deleteFile(String fileName) {                        //Deletes a file in the directory if it exists
        Path path = Paths.get(directory + "/" + fileName);
        boolean deleted = false;
        try {
            deleted = Files.deleteIfExists(path);
        } catch (NoSuchFileException e) {
            System.out.println("Unsuccessful. File not found. Returning to menu.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Unsuccessful. Directory is not empty. Returning to menu.");
        } catch (IOException e) {
            System.out.println("Error I/O Exception. Returning to menu");
        }
        if(deleted){
            System.out.println("File successfully deleted!");
        }else{
            System.out.println("Unsuccessful. File not found. Returning to menu");
        }
    }

    public static void searchFile(String fileName) throws IOException {     //Searches for file 
        List<Path> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(directory))) {
            result =walk.filter(Files::isRegularFile) 
                .filter(p -> p.getFileName().toString().equals(fileName))
                .collect(Collectors.toList());
            if(result.isEmpty()){
                System.out.println("File not found. Returning to menu.");
            }else{
                result.forEach(n -> System.out.println("File found at " + n));
            }
        } catch (IOException e){
            System.out.println("Error I/O Exception. Returning to menu.");
        }
    }
}
