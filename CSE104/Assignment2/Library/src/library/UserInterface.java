/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Minhao.Jin17
 */
public class UserInterface {

    private static Scanner kb;
    private static int level = 0;
    private static String title;
    private static String author;

    public static void showMenu() {
        level = 0;
        FileUtils.saveLibraryToFile(Library.get_books());

        //Library.sortby_total_copies();
        kb = new Scanner(System.in);

        System.out.print("Enter your command here(Enter ‘Quit’ at any time to exit from current level):");

        String command = kb.nextLine();
        command = command.toLowerCase().trim();

        switch (command) {
            case "add":
                level = 1;
                add();
                break;

            case "update":
                level = 1;
                update();
                break;

            case "search":
                level = 1;
                search();
                break;

            case "delete":
                level = 1;
                delete();
                break;

            case "display":
                display();
                break;

            case "quit":
                System.exit(0);

            default:
                System.out.println("Please input a valid command");
        }
    }

    private static void add() {
        while (true) {
            String ISBN = enter_newISBN();
            if (check_quit(ISBN)) {
                break;
            }
            title = enter_title();
            if (check_quit(title)) {
                break;
            }
            author = enter_author();
            if (check_quit(author)) {
                break;
            }
            String category = enter_category();
            if (check_quit(category)) {
                break;
            }
            int copies_number = enter_total_copies();
            if (copies_number == -1) {
                break;
            }

            book newbook = new book(ISBN, title, author, category, copies_number, copies_number);

            System.out.println("Ready to add book: " + ISBN + "; " + title + "; " + author + "; "
                    + category + "; " + copies_number + "; " + copies_number);
            System.out.print("Enter ‘Y’ to add new book. Anything else to quit:");

            String confirm = kb.nextLine();
            check_quit(confirm);
            if (confirm.toUpperCase().equals("Y")) {
                Library.add_book(newbook);
                System.out.println("\tNew book added successfully.");
            }
            break;
        }
    }

    private static String enter_newISBN() {
        while (true) {
            System.out.print("Enter a new book ISBN:");
            String ISBN = kb.nextLine();
            if (check_quit(ISBN)) {
                return "quit";
            }
            if (!isvalid_ISBN(ISBN)) {
                System.out.println("Invalid ISBN.");
            } else if (!isunique_ISBN(ISBN)) {
                System.out.println("Duplicate ISBN.");
            } else {
                System.out.println("\tIBSN: " + ISBN + " Entered.");
                return ISBN;
            }
        }
    }

    private static String enter_ISBN() {
        while (true) {
            System.out.print("Enter ISBN:");
            String ISBN = kb.nextLine();
            if (check_quit(ISBN)) {
                return "quit";
            }
            if (!isvalid_ISBN(ISBN)) {
                System.out.println("Invalid ISBN.");
            } else {
                System.out.println("\tIBSN: " + ISBN + " Entered.");
                return ISBN;
            }
        }
    }

    private static boolean isvalid_ISBN(String ISBN) {
        while (true) {
            if (check_quit(ISBN)) {
                break;
            }
            if (ISBN.length() != 10 && ISBN.length() != 13) {
                return false;
            }
            for (char c : ISBN.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private static boolean isunique_ISBN(String ISBN) {
        for (book b : Library.get_books()) {
            if (b.get_ISBN().equals(ISBN)) {
                return false;
            }
        }
        return true;
    }

    private static String enter_title() {
        while (true) {
            System.out.print("Enter the title:");
            String _title = kb.nextLine();
            if (check_quit(_title)) {
                return "quit";
            }
            System.out.println("\tTitle: " + _title + " Entered.");
            return _title;
        }
    }

    private static String enter_author() {
        while (true) {
            System.out.print("Enter the author:");
            author = kb.nextLine();
            if (check_quit(author)) {
                return "quit";
            }

            if (check_author_title()) {
                System.out.println("\tAuthor: " + author + " Entered.");
            } else {
                System.out.print("Please re-enter Author or enter ‘T’ to re-enter title:");
                String confirm = kb.nextLine();
                if (check_quit(confirm)) {
                    return "quit";
                }

                if (confirm.toUpperCase().equals("T")) {
                    title = enter_title();
                } else {
                    author = confirm;
                }
            }

            if (check_author_title()) {
                return author;
            }
        }
    }

    private static boolean check_author_title() {
        for (book b : Library.get_books()) {
            if (b.get_author().equals(author) && b.get_title().equals(title)) {
                System.out.println("\tBook " + title + " by " + author + " exists in system.");
                return false;
            }
        }
        return true;
    }

    private static String enter_category() {
        while (true) {
            System.out.print("Enter category:");
            String category = kb.nextLine();
            if (check_quit(category)) {
                return "quit";
            }
            System.out.println("\tCategory: " + category + " Entered.");
            return category;
        }
    }

    private static int enter_total_copies() {
        while (true) {
            int copies_number;
            System.out.print("Enter total copy number:");
            String total_copies = kb.nextLine();
            if (check_quit(total_copies)) {
                return -1;
            }

            copies_number = getIntInput(total_copies);
            if (copies_number <= 20) {
                return copies_number;
            } else {
                System.out.println("total copies should no more than 20");
            }

        }
    }

    private static void delete() {
        while (true) {
            book to_delete = null;
            System.out.print("Enter the book’s ISBN or title + author:");
            String key = kb.nextLine();

            if (check_quit(key)) {
                break;
            }

            if (!key.contains("+")) {
                if (!isvalid_ISBN(key)) {
                    System.out.println("Invalid ISBN.");
                    break;
                } else {
                    for (book b : Library.get_books()) {
                        if (b.get_ISBN().equals(key)) {
                            to_delete = b;
                            break;
                        }
                    }
                }
            } else {
                System.out.println(key);
                String[] title_author = key.split("\\+");
                String title_forSearch = title_author[0].trim();
                String author_forSearch = title_author[1].trim();

                for (book b : Library.get_books()) {
                    if (b.get_title().equals(title_forSearch)
                            && b.get_author().equals(author_forSearch)) {
                        to_delete = b;
                        break;
                    }
                }
            }

            if (to_delete == null) {
                System.out.println("Not Found!");
                break;
            }

            ConsoleTable t = new ConsoleTable(6, true);
            add_header(t);
            add_bookinfo(t, to_delete);
            System.out.println("Found book:");
            System.out.println(t.createTable());

            if (!to_delete.able_to_delete()) {
                System.out.println("Sorry this book cannot be deleted. There are "
                        + (to_delete.get_total_copies() - to_delete.get_available_copies())
                        + " copies have been lent out.");
                break;
            }

            System.out.println("Enter ‘Y’to delete thebook. Anything else to quit: ");
            String confirm = kb.nextLine();

            if (check_quit(confirm)) {
                break;
            }

            if (confirm.toUpperCase().equals("Y")) {
                System.out.println("\tBook with ISBN " + to_delete.get_ISBN() + " has been deleted successfully.");
                Library.get_books().remove(to_delete);
            }
            break;
        }

    }

    private static void add_header(ConsoleTable t) {
        t.appendRow();
        t.appendColum("ISBN").appendColum("TITLE").appendColum("AUTHOR").
                appendColum("CATEGORY").appendColum("TOTAL_COPIES").appendColum("AVAILABLE_COPIES");
    }

    private static void add_bookinfo(ConsoleTable t, book b) {
        t.appendRow();
        t.appendColum(b.get_ISBN()).appendColum(b.get_title()).appendColum(b.get_author()).
                appendColum(b.get_category()).appendColum(b.get_total_copies()).appendColum(b.get_available_copies());
    }

    private static boolean check_quit(String s) {
        s = s.toLowerCase();
        if (s.equals("quit") && level == 1) {
            return true;
        }
        if (s.equals("quit") && level == 0) {
            System.exit(0);
        }
        return false;
    }

    private static int getIntInput(String s) {
        int input = 0;
        while (true) {
            if (check_quit(s)) {
                break;
            }
            try {
                input = Integer.parseInt(s);
                if (input < 0) {
                    System.out.println("That is not a positive number please try again.");
                    input = getIntInput(kb.nextLine());
                }

            } catch (NumberFormatException e) {
                System.out.println("That is not a number please try again.");
                input = getIntInput(kb.nextLine());
            } finally {
                return input;
            }
        }
        return input;
    }

    private static void update() {
        while (true) {
            String ISBN = enter_ISBN();
            book to_update = null;
            for (book b : Library.get_books()) {
                if (b.get_ISBN().equals(ISBN)) {
                    to_update = b;
                    break;
                }
            }

            if (to_update == null) {
                System.out.println("Not Found!");
                break;
            }

            ConsoleTable t = new ConsoleTable(6, true);
            add_header(t);
            add_bookinfo(t, to_update);
            System.out.println("\tFound book:");
            System.out.println(t.createTable());
            System.out.print("Enter type of information you want to update, ‘T’ for title, ‘A’ for author, "
                    + "‘C’ for category, ‘TC’ for total copy number, ‘AC’ for available number:");

            String type = kb.nextLine();
            if (check_quit(type)) {
                break;
            }
            type = type.toUpperCase();

            switch (type) {
                case "T":
                    update_title(ISBN, to_update);
                    break;
                case "A":
                    update_author(ISBN, to_update);
                    break;
                case "C":
                    update_category(ISBN, to_update);
                    break;
                case "TC":
                    update_total_copies(ISBN, to_update);
                    break;
                case "AC":
                    update_available_copies(ISBN, to_update);
                    break;
                default:
                    System.out.println("Please input a valid type");
            }
            break;
        }
    }

    private static void update_title(String ISBN, book b) {
        while (true) {
            boolean flag = true;
            System.out.print("Enter your new title:");
            String new_title = kb.nextLine();
            if (check_quit(new_title)) {
                break;
            }

            for (book book : Library.get_books()) {
                if (book.get_author().equals(b.get_author()) && book.get_title().equals(new_title)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.out.println("\tBook " + new_title + " by " + b.get_author() + " exists in system.");
            } else {
                String old_title = b.get_title();
                b.set_title(new_title);
                System.out.println("Book " + ISBN + "‘s title has been updated from "
                        + old_title + " to " + new_title + " successfully.");
                break;
            }
        }
    }

    private static void update_author(String ISBN, book b) {
        while (true) {
            boolean flag = true;
            System.out.print("Enter your new author:");
            String new_author = kb.nextLine();
            if (check_quit(new_author)) {
                break;
            }

            for (book book : Library.get_books()) {
                if (book.get_author().equals(new_author) && book.get_title().equals(b.get_title())) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                System.out.println("\tBook " + b.get_title() + " by " + new_author + " exists in system.");
            } else {
                String old_author = b.get_author();
                b.set_author(new_author);
                System.out.println("Book " + ISBN + "‘s author has been updated from "
                        + old_author + " to " + new_author + " successfully.");
                break;
            }
        }
    }

    private static void update_category(String ISBN, book b) {
        while (true) {
            System.out.print("Enter your new category:");
            String new_category = kb.nextLine();
            if (check_quit(new_category)) {
                break;
            }
            String old_category = b.get_category();
            b.set_category(new_category);
            System.out.println("Book " + ISBN + "‘s catagory has been updated from "
                    + old_category + " to " + new_category + " successfully.");
            break;
        }
    }

    private static void update_total_copies(String ISBN, book b) {
        while (true) {
            System.out.print("Enter your new total copies:");
            String _total_copies = kb.nextLine();
            if (check_quit(_total_copies)) {
                break;
            }
            int new_total_copies = getIntInput(_total_copies);

            if (new_total_copies <= 20) {
                int old_total_copies = b.get_total_copies();
                b.set_total_copies(new_total_copies);
                System.out.println("Book " + ISBN + "‘s total copies has been updated from "
                        + old_total_copies + " to " + new_total_copies + " successfully.");

                if (b.get_available_copies() > b.get_total_copies()) {
                    b.set_available_copies(b.get_total_copies());
                }
                break;
            } else {
                System.out.println("total copies should no more than 20");
            }

        }
    }

    private static void update_available_copies(String ISBN, book b) {
        while (true) {
            System.out.print("Enter your new total copies:");
            String _available_copies = kb.nextLine();
            if (check_quit(_available_copies)) {
                break;
            }
            int new_available_copies = getIntInput(_available_copies);

            if (new_available_copies > b.get_total_copies()) {
                System.out.println("This book's available copies is greater than its total copies");
            } else {
                int old_available_copies = b.get_available_copies();
                b.set_available_copies(new_available_copies);
                System.out.println("Book " + ISBN + "‘s available copies has been updated from "
                        + old_available_copies + " to " + new_available_copies + " successfully.");
            }
            break;
        }
    }

    private static void display() {
        while (true) {
            System.out.print("Enter ‘C’ for displaying group by category, or ‘A’ for displaying group by author:");
            String groupby = kb.nextLine();
            if (check_quit(groupby)) {
                break;
            }
            groupby = groupby.toUpperCase();

            if (groupby.equals("C")) {
                Library.sortby_category();
            } else if (groupby.equals("A")) {
                Library.sortby_author();
            }

            List<book> to_display = Library.get_books();

            ConsoleTable t = new ConsoleTable(6, true);
            add_header(t);
            for (book b : to_display) {
                add_bookinfo(t, b);
            }
            System.out.println(t.createTable());
            break;
        }
    }

    private static void search() {
        while (true) {
            ArrayList<book> books_for_search = new ArrayList();
            System.out.print("Enter your keyword: ");
            String keywords = kb.nextLine();

            if (check_quit(keywords)) {
                break;
            }

            for (book b : Library.get_books()) {
                if (b.toString().toLowerCase().contains(keywords.toLowerCase())) {
                    books_for_search.add(b);
                }
            }

            if (books_for_search.isEmpty()) {
                System.out.println("\tNot found.");
            } else {
                System.out.println("\tFound book(s):");
                ConsoleTable t = new ConsoleTable(6, true);
                add_header(t);
                Library.sortby_total_copies(books_for_search);
                for (book b : books_for_search) {
                    add_bookinfo(t, b);
                }
                System.out.println(t.createTable());
            }

            System.out.print("Enter ‘Y’ to search other books, anything else to quit: ");
            String confirm = kb.nextLine();

            if (check_quit(confirm)) {
                break;
            }

            if (!confirm.toUpperCase().equals("Y")) {
                break;
            }
        }
    }
}
