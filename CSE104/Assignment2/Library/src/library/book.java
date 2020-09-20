/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Minhao.Jin17
 */
public class book {

    private String ISBN;
    private String title;
    private String author;
    private String category;
    private int total_copies;
    private int available_copies;

    public book(String ISBN,
            String title,
            String author,
            String category,
            int total_copies,
            int available_copies) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.category = category;
        this.total_copies = total_copies;
        this.available_copies = available_copies;
    }

    public String get_ISBN() {
        return ISBN;
    }

    public String get_title() {
        return title;
    }

    public String get_author() {
        return author;
    }

    public String get_category() {
        return category;
    }

    public int get_total_copies() {
        return total_copies;
    }

    public int get_available_copies() {
        return available_copies;
    }

    public void set_ISBN(String s) {
        ISBN = s;
    }

    public void set_title(String s) {
        title = s;
    }

    public void set_author(String s) {
        author = s;
    }

    public void set_category(String s) {
        category = s;
    }

    public void set_total_copies(int n) {
        total_copies = n;
    }

    public void set_available_copies(int n) {
        available_copies = n;
    }

    public boolean able_to_delete() {
        if (total_copies == available_copies) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "book,"
                + "ISBN=" + ISBN
                + ",title=" + title
                + ",author=" + author
                + ",category=" + category
                + ",total copies=" + total_copies
                + ",available copies=" + available_copies;
    }

}
