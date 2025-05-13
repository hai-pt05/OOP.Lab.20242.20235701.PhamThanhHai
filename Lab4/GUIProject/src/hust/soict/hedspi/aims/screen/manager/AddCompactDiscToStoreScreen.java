package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfTracks; // Nhập tracks dưới dạng "title:length, title:length"

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
    }

    @Override
    JPanel createForm() {
        JPanel form = super.createForm();
        form.setLayout(new GridLayout(5, 2, 5, 5)); // Thêm 2 hàng cho artist và tracks

        form.add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        form.add(tfArtist);

        form.add(new JLabel("Tracks (title:length, ...):"));
        tfTracks = new JTextField(20);
        form.add(tfTracks);

        return form;
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText());
            String artist = tfArtist.getText();

            CompactDisc cd = new CompactDisc(title, category, cost, artist);
            String[] trackInputs = tfTracks.getText().split(",");
            for (String trackInput : trackInputs) {
                String[] parts = trackInput.trim().split(":");
                if (parts.length == 2) {
                    String trackTitle = parts[0].trim();
                    int trackLength = Integer.parseInt(parts[1].trim());
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
            }

            store.addMedia(cd);
            JOptionPane.showMessageDialog(null, "CD added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid cost or track length format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}