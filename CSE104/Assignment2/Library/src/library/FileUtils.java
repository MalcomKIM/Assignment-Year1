/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 *
 * @author Minhao.Jin17
 */
public class FileUtils {

    public static boolean saveLibraryToFile(ArrayList<book> toWrite) {
        try (FileWriter fw = new FileWriter("Library.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            for (book b : toWrite) {
                out.println(b.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Library saved to file");
        return true;
    }

    public static void readBookFromFile() {
        Path filePath = Paths.get("Library.txt");
        if (!Files.exists(filePath)) {
            System.out.println("There is no file to read from.");
        }
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("book")) {
                    bookFromString(line);
                } else {
                    System.out.println("Bad line in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file:" + filePath);
            e.printStackTrace();
        }
    }

    private static void bookFromString(String line) {
        String data[] = line.split(",");

        String ISBN = data[1].substring(5);
        String title = data[2].substring(6);
        String author = data[3].substring(7);
        String category = data[4].substring(9);
        int total_copies = Integer.parseInt(data[5].substring(13));
        int available_copies = Integer.parseInt(data[6].substring(17));
        book b = new book(ISBN, title, author, category, total_copies, available_copies);

        Library.get_books().add(b);
    }

}
