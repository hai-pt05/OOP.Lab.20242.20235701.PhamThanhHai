package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

import java.util.Arrays;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo cửa hàng
        Store store = new Store();

        // Tạo các đối tượng Media
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Java Programming", "Education", 29.99f);
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", 19.99f, "The Beatles",
                Arrays.asList(new Track("Come Together", 4), new Track("Something", 3)));

        // Kiểm tra thêm Media
        System.out.println("Kiểm tra thêm Media:");
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        // Hiển thị cửa hàng
        System.out.println("\nHiển thị cửa hàng:");
        store.displayStore();

        // Kiểm tra Media có sẵn
        System.out.println("\nKiểm tra Media có sẵn:");
        System.out.println("DVD có sẵn: " + store.isMediaAvailable(dvd));
        System.out.println("Book có sẵn: " + store.isMediaAvailable(book));

        // Kiểm tra xóa Media
        System.out.println("\nKiểm tra xóa Media:");
        store.removeMedia(book);

        // Hiển thị lại cửa hàng
        System.out.println("\nHiển thị cửa hàng sau khi xóa:");
        store.displayStore();

        // Kiểm tra lại Media có sẵn
        System.out.println("\nKiểm tra Media có sẵn sau khi xóa:");
        System.out.println("Book có sẵn: " + store.isMediaAvailable(book));
    }
}