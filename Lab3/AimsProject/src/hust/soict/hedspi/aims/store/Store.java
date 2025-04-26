package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;
    private static final int MAX_CAPACITY = 100;

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<Media>();
    }

    // Thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_CAPACITY) {
            System.out.println("Cửa hàng đã đầy, không thể thêm Media!");
            return;
        }
        if (itemsInStore.contains(media)) {
            System.out.println("Media " + media.getTitle() + " đã tồn tại trong cửa hàng!");
            return;
        }
        itemsInStore.add(media);
        System.out.println("Media " + media.getTitle() + " đã được thêm vào cửa hàng.");
    }

    // Xóa Media khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng trống, không thể xóa Media!");
            return;
        }

        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media " + media.getTitle() + " đã được xóa khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy Media " + media.getTitle() + " trong cửa hàng!");
        }
    }

    // Hiển thị danh sách Media
    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng trống!");
            return;
        }
        System.out.println("Danh sách Media trong cửa hàng:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
    }

    // Phương thức mới: Kiểm tra Media có sẵn trong cửa hàng
    public boolean isMediaAvailable(Media media) {
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).equals(media)) {
                return true;
            }
        }
        return false;
    }
    
    // Tìm Media theo title
    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

}