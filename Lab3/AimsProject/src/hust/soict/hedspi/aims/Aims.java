package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        // Tạo các đối tượng Media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 90, 20.0f); // Title giống dvd1
        Book book = new Book("Java Programming", "Education", 29.99f, Arrays.asList("Author1", "Author2"));
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", 19.99f, "The Beatles",
                Arrays.asList(new Track("Come Together", 4), new Track("Something", 3)));

        // Thêm vào cửa hàng
        System.out.println("Thêm Media vào cửa hàng:");
        store.addMedia(dvd1);
        store.addMedia(dvd2); // Nên bị chặn vì title giống
        store.addMedia(book);
        store.addMedia(cd);

        // Hiển thị menu chính
        int choice;
        do {
            showMenu();
            choice = getUserChoice(0, 3);
            switch (choice) {
                case 1: // Xem cửa hàng
                    handleStoreMenu();
                    break;
                case 2: // Cập nhật cửa hàng
                    handleUpdateStore();
                    break;
                case 3: // Xem giỏ hàng hiện tại
                    handleCartMenu();
                    break;
                case 0: // Thoát
                    System.out.println("Tạm biệt!");
                    break;
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Xem giỏ hàng hiện tại");
        System.out.println("0. Thoát");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Xem chi tiết một media");
        System.out.println("2. Thêm một media vào giỏ hàng");
        System.out.println("3. Phát một media");
        System.out.println("4. Xem giỏ hàng hiện tại");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(boolean showPlayOption) {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Thêm vào giỏ hàng");
        if (showPlayOption) {
            System.out.println("2. Phát");
            System.out.println("0. Quay lại");
            System.out.println("--------------------------------");
            System.out.println("Vui lòng chọn một số: 0-1-2");
        } else {
            System.out.println("0. Quay lại");
            System.out.println("--------------------------------");
            System.out.println("Vui lòng chọn một số: 0-1");
        }
    }

    public static void cartMenu() {
        System.out.println("Tùy chọn: ");
        System.out.println("--------------------------------");
        System.out.println("1. Lọc media trong giỏ hàng");
        System.out.println("2. Sắp xếp media trong giỏ hàng");
        System.out.println("3. Xóa media khỏi giỏ hàng");
        System.out.println("4. Phát một media");
        System.out.println("5. Đặt hàng");
        System.out.println("0. Quay lại");
        System.out.println("--------------------------------");
        System.out.println("Vui lòng chọn một số: 0-1-2-3-4-5");
    }

    // Lấy lựa chọn của người dùng với kiểm tra hợp lệ
    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Vui lòng chọn số trong khoảng " + min + " đến " + max + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ!");
            }
        }
        return choice;
    }

    // Xử lý menu cửa hàng
    private static void handleStoreMenu() {
        int choice;
        do {
            store.displayStore();
            storeMenu();
            choice = getUserChoice(0, 4);
            switch (choice) {
                case 1: // Xem chi tiết một media
                    System.out.println("Nhập tiêu đề của media:");
                    String title = scanner.nextLine();
                    Media media = store.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\"");
                    } else {
                        System.out.println(media.toString());
                        handleMediaDetailsMenu(media);
                    }
                    break;
                case 2: // Thêm một media vào giỏ hàng
                    System.out.println("Nhập tiêu đề của media để thêm vào giỏ:");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\"");
                    } else {
                        cart.addMedia(media);
                        if (media instanceof DigitalVideoDisc) {
                            System.out.println("Số lượng DVD trong giỏ: " + cart.countDVDs());
                        }
                    }
                    break;
                case 3: // Phát một media
                    System.out.println("Nhập tiêu đề của media để phát:");
                    title = scanner.nextLine();
                    media = store.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\"");
                    } else if (!(media instanceof Playable)) {
                        System.out.println("Media này không thể phát (chỉ CD và DVD có thể phát)!");
                    } else {
                        ((Playable) media).play();
                    }
                    break;
                case 4: // Xem giỏ hàng hiện tại
                    handleCartMenu();
                    break;
                case 0: // Quay lại
                    break;
            }
        } while (choice != 0);
    }

    // Xử lý menu chi tiết media
    private static void handleMediaDetailsMenu(Media media) {
        boolean showPlayOption = (media instanceof Playable);
        int maxChoice = showPlayOption ? 2 : 1;
        int choice;
        do {
            mediaDetailsMenu(showPlayOption);
            choice = getUserChoice(0, maxChoice);
            switch (choice) {
                case 1: // Thêm vào giỏ hàng
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Số lượng DVD trong giỏ: " + cart.countDVDs());
                    }
                    break;
                case 2: // Phát (nếu khả dụng)
                    if (showPlayOption) {
                        ((Playable) media).play();
                    }
                    break;
                case 0: // Quay lại
                    break;
            }
        } while (choice != 0);
    }

    // Xử lý cập nhật cửa hàng
    private static void handleUpdateStore() {
        System.out.println("1. Thêm media vào cửa hàng");
        System.out.println("2. Xóa media khỏi cửa hàng");
        System.out.println("0. Quay lại");
        System.out.println("Vui lòng chọn một số: 0-1-2");
        int choice = getUserChoice(0, 2);
        switch (choice) {
            case 1: // Thêm media
                System.out.println("Chọn loại media để thêm (1: DVD, 2: CD, 3: Book):");
                int type = getUserChoice(1, 3);
                System.out.println("Nhập tiêu đề:");
                String title = scanner.nextLine();
                System.out.println("Nhập danh mục:");
                String category = scanner.nextLine();
                System.out.println("Nhập chi phí:");
                float cost = Float.parseFloat(scanner.nextLine());

                Media media = null;
                if (type == 1) { // DVD
                    System.out.println("Nhập đạo diễn:");
                    String director = scanner.nextLine();
                    System.out.println("Nhập chiều dài (phút):");
                    int length = Integer.parseInt(scanner.nextLine());
                    media = new DigitalVideoDisc(title, category, director, length, cost);
                } else if (type == 2) { // CD
                    System.out.println("Nhập nghệ sĩ:");
                    String artist = scanner.nextLine();
                    media = new CompactDisc(title, category, cost, artist, new ArrayList<>());
                } else { // Book
                    System.out.println("Nhập tác giả (cách nhau bởi dấu phẩy):");
                    String authorsInput = scanner.nextLine();
                    media = new Book(title, category, cost, Arrays.asList(authorsInput.split(", ")));
                }
                store.addMedia(media);
                break;
            case 2: // Xóa media
                System.out.println("Nhập tiêu đề của media để xóa:");
                title = scanner.nextLine();
                media = store.findMediaByTitle(title);
                if (media == null) {
                    System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\"");
                } else {
                    store.removeMedia(media);
                }
                break;
            case 0: // Quay lại
                break;
        }
    }

    // Xử lý menu giỏ hàng
    private static void handleCartMenu() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = getUserChoice(0, 5);
            switch (choice) {
                case 1: // Lọc media trong giỏ hàng
                    System.out.println("1. Lọc theo ID");
                    System.out.println("2. Lọc theo tiêu đề");
                    System.out.println("Vui lòng chọn một số: 1-2");
                    int filterChoice = getUserChoice(1, 2);
                    if (filterChoice == 1) {
                        System.out.println("Nhập ID:");
                        int id = Integer.parseInt(scanner.nextLine());
                        cart.filterById(id);
                    } else {
                        System.out.println("Nhập tiêu đề:");
                        String title = scanner.nextLine();
                        cart.filterByTitle(title);
                    }
                    break;
                case 2: // Sắp xếp media trong giỏ hàng
                    System.out.println("1. Sắp xếp theo tiêu đề");
                    System.out.println("2. Sắp xếp theo chi phí");
                    System.out.println("Vui lòng chọn một số: 1-2");
                    int sortChoice = getUserChoice(1, 2);
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else {
                        cart.sortByCost();
                    }
                    break;
                case 3: // Xóa media khỏi giỏ hàng
                    System.out.println("Nhập tiêu đề của media để xóa:");
                    String title = scanner.nextLine();
                    Media media = cart.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\" trong giỏ hàng");
                    } else {
                        cart.removeMedia(media);
                    }
                    break;
                case 4: // Phát một media
                    System.out.println("Nhập tiêu đề của media để phát:");
                    title = scanner.nextLine();
                    media = cart.findMediaByTitle(title);
                    if (media == null) {
                        System.out.println("Không tìm thấy media với tiêu đề \"" + title + "\" trong giỏ hàng");
                    } else if (!(media instanceof Playable)) {
                        System.out.println("Media này không thể phát (chỉ CD và DVD có thể phát)!");
                    } else {
                        ((Playable) media).play();
                    }
                    break;
                case 5: // Đặt hàng
                    System.out.println("Đơn hàng đã được tạo!");
                    cart.clearCart();
                    break;
                case 0: // Quay lại
                    break;
            }
        } while (choice != 0);
    }
}