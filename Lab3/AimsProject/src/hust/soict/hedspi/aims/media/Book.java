package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    // Constructor
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = new ArrayList<>(authors);
    }

    // Thêm tác giả
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả " + authorName + " đã tồn tại!");
        }
    }

    // Xóa tác giả
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả: " + authorName);
        }
    }

    // toString
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + ": " + getCost() + " $";
    }
}