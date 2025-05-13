package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
    }

    @Override
    JPanel createForm() {
        JPanel form = super.createForm();
        form.setLayout(new GridLayout(4, 2, 5, 5)); // Thêm 1 hàng cho authors

        form.add(new JLabel("Authors (comma-separated):"));
        tfAuthors = new JTextField(20);
        form.add(tfAuthors);

        return form;
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());

            Book book = new Book(title, category, cost);
            String[] authors = tfAuthors.getText().split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }

            store.addMedia(book);
            JOptionPane.showMessageDialog(null, "Book added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid cost format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}