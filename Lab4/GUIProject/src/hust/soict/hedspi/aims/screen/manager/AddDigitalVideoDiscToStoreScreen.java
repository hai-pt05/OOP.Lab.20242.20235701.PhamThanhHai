package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }

    @Override
    JPanel createForm() {
        JPanel form = super.createForm();
        form.setLayout(new GridLayout(5, 2, 5, 5)); // Thêm 2 hàng cho director và length

        form.add(new JLabel("Director:"));
        tfDirector = new JTextField(20);
        form.add(tfDirector);

        form.add(new JLabel("Length:"));
        tfLength = new JTextField(20);
        form.add(tfLength);

        return form;
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "DVD added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid cost or length format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}