package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createMenuBar(), BorderLayout.NORTH); // Thêm thanh menu
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createForm(), BorderLayout.CENTER);
        cp.add(createSouth(), BorderLayout.SOUTH);
        setVisible(true); // Đảm bảo màn hình hiển thị
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(e -> {
            dispose(); // Đóng màn hình hiện tại
            new StoreManagerScreen(store); // Mở lại StoreManagerScreen
        });
        menu.add(viewStoreItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        JLabel title = new JLabel("Add Item", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        north.add(title);
        return north;
    }

    JPanel createForm() {
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3, 2, 5, 5));

        form.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        form.add(tfTitle);

        form.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        form.add(tfCategory);

        form.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        form.add(tfCost);

        return form;
    }

    JPanel createSouth() {
        JPanel south = new JPanel();
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(e -> {
            addItemToStore();
            dispose(); // Đóng màn hình sau khi thêm
           
        });
        south.add(btnOK);
        return south;
    }

    protected abstract void addItemToStore();
}