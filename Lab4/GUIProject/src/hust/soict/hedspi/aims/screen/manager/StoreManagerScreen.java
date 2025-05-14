package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel centerPanel; // Lưu trữ panel trung tâm để cập nhật

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        
        //thêm ActionListener cho View store 
        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> updateCenterPanel());
        menu.add(viewStoreItem);

        
        //thêm ActionListener cho add bôk, add cd, add dvd
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> new AddBookToStoreScreen(store));
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> new AddCompactDiscToStoreScreen(store));
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> new AddDigitalVideoDiscToStoreScreen(store));
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }
    
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (mediaInStore == null || mediaInStore.isEmpty()) {
            JLabel noItems = new JLabel("No items in store");
            center.add(noItems);
        } else {
            for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
                Media media = mediaInStore.get(i);
                if (media != null) {
                    MediaStore cell = new MediaStore(media);
                    center.add(cell);
                }
            }
        }

        return center;
    }

    private void updateCenterPanel() {
        getContentPane().remove(centerPanel);
        centerPanel = createCenter();
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("Movie 1", "Harry Potter and the Philosopher’s Stone (2001)", 3.0f));
        store.addMedia(new DigitalVideoDisc("Movie 2", "Harry Potter and th  Chamber of Secrets (2002)", 3.5f));
        store.addMedia(new DigitalVideoDisc("Movie 3", "Harry Potter and the Prisoner of Azkaban (2004)", 5.0f));
        store.addMedia(new DigitalVideoDisc("Movie 4", "Harry Potter and the Goblet of Fire (2005)", 4.5f));
        store.addMedia(new DigitalVideoDisc("Movie 5", "Harry Potter and the Order of the Phoenix (2007)", 5.67f));
        store.addMedia(new DigitalVideoDisc("Movie 6", "Harry Potter and the Half Blood Prince (2009)", 6.99f));
        store.addMedia(new DigitalVideoDisc("Movie 7", "Harry Potter and the Deathly Hallows – Part 1 (2010)", 7.0f));
        store.addMedia(new DigitalVideoDisc("Movie 8", "Harry Potter and the Deathly Hallows – Part 2 (2011)", 7.2f));
        store.addMedia(new Book("Harry Potter and the Cursed Child (2016)", "Fiction", 2.3f));
        
        new StoreManagerScreen(store);
    }
}