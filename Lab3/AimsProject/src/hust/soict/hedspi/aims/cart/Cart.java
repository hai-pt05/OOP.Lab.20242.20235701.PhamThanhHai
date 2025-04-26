package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    // Danh sách các Media trong giỏ hàng
    private ArrayList<Media> itemsOrdered;

    // Constructor
    public Cart() {
        itemsOrdered = new ArrayList<Media>();
    }

    // Thêm Media vào giỏ
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Giỏ đã đầy, không thể thêm!");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("Media " + media.getTitle() + " đã tồn tại trong giỏ hàng!");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("Đã thêm vào giỏ hàng của bạn");
        
        // Kiểm tra xem giỏ có gần đầy không
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("Giỏ đã đầy");
        } else if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("Giỏ gần đầy");
        }
    }

    // Xóa Media khỏi giỏ
    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Giỏ trống, không thể xoá!");
            return;
        }
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xoá khỏi giỏ hàng của bạn");
        } else {
            System.out.println("Không tìm thấy sản phẩm này trong giỏ hàng của bạn!");
        }
    }

    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Đếm số lượng DVD trong giỏ
    public int countDVDs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    // Tìm Media theo title
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Lọc media theo id
    public void filterById(int id) {
        boolean found = false;
        System.out.println("Kết quả lọc theo ID " + id + ":");
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy media với ID " + id);
        }
    }

    // Lọc media theo title
    public void filterByTitle(String title) {
        boolean found = false;
        System.out.println("Kết quả lọc theo tiêu đề \"" + title + "\":");
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\"");
        }
    }

    // Thêm phương thức để hiển thị thông tin giỏ (tùy chọn để kiểm tra)
    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Giỏ hàng trống!");
            return;
        }
        System.out.println("Các sản phẩm trong giỏ hàng:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCost());
        }
        System.out.println("Số lượng sản phẩm: " + itemsOrdered.size());
    }
    
    // Thêm print cho Lab3
    public void print() {
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
    }

    // Sắp xếp theo title rồi cost (giảm dần) - Dùng Comparator
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo title (tăng dần), rồi cost (giảm dần).");
    }

    // Sắp xếp theo cost rồi title - Dùng Comparator
    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo cost (giảm dần), rồi title (tăng dần).");
    }

    // Làm trống giỏ hàng sau khi đặt hàng
    public void clearCart() {
        itemsOrdered.clear();
    }
}