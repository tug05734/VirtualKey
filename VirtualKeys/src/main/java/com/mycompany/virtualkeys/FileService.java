/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.virtualkeys;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Rajat
 */
public class FileService {

    private final static String directory = "src/main/java/com/mycompany/virtualkeys/testdirectory";

    public FileService(String directory) {
    }

    public static void listContents() throws IOException {
        try {
            for (Path path : Files.newDirectoryStream(Paths.get(directory))) {
                path = path.normalize();
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            //error
        }
    }

    public static void createFile(String fileName) throws IOException {
        try {
            File file = new File(directory + "/" + fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File successfully added!");
            } else {
                System.out.println("Unsuccessful. File already exists.");
            }
        } catch (IOException e) {
            //error
        }
    }

    public static void deleteFile(String fileName) {
        Path path = Paths.get(directory + "/" + fileName + ".txt");
        try {
            Files.deleteIfExists(path);
        } catch (NoSuchFileException e) {
            System.out.println("Unsuccessful. File not found.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Unsuccessful. Directory is not empty.");
        } catch (IOException e) {
            //error
        }
        System.out.println("File successfully deleted!");
    }

    public static void searchFile(String fileName) throws IOException {
        try (Stream<Path> walk = Files.walk(Paths.get(directory))) {
            walk.filter(Files::isRegularFile) 
                .filter(p -> p.getFileName().toString().equals(fileName))
                .forEach(p -> System.out.println(p.getFileName() + " found in " + p.toAbsolutePath()));
        }
    }
}
