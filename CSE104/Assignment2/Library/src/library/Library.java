/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Minhao.Jin17
 */
public class Library {

    private static ArrayList<book> books = new ArrayList<>();

    public static void main(String[] args) {
        FileUtils.readBookFromFile();

        System.out.println("Library");
        System.out.println("Welcome to the library management system, functions provided include the following:");
        System.out.println("\tAdd – to add a new book");
        System.out.println("\tUpdate – to update book info");
        System.out.println("\tSearch – to enquire about book info");
        System.out.println("\tDelete – to delete a book");
        System.out.println("\tDisplay - to display book(s) info");
        System.out.println("\tQuit - to exit from the current level of interactions");
        while (true) {
            UserInterface.showMenu();
        }
    }

    public static void add_book(book newbook) {
        books.add(newbook);
    }

    public static ArrayList<book> get_books() {
        return books;
    }

    public static void sortby_total_copies(ArrayList<book> b) {
        Collections.sort(b, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return o2.get_total_copies() - o1.get_total_copies();
            }
        });
    }

    public static void sortby_category() {
        Collections.sort(books, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return o2.get_category().compareTo(o1.get_category());
            }
        });
    }

    public static void sortby_author() {
        Collections.sort(books, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                return o2.get_author().compareTo(o1.get_author());
            }
        });
    }

}
