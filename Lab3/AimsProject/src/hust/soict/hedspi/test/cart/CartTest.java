package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;

import java.util.Arrays;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart cart = new Cart();

        // Tạo các đối tượng Media
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Java Programming", "Education", 29.99f);
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", 19.99f, "The Beatles",
                Arrays.asList(new Track("Come Together", 4), new Track("Something", 3)));

        // Kiểm tra thêm Media
        System.out.println("Kiểm tra thêm Media:");
        cart.addMedia(dvd);
        cart.addMedia(book);
        cart.addMedia(cd);

        // Hiển thị giỏ hàng
        System.out.println("\nHiển thị giỏ hàng:");
        cart.displayCart();

        // In giỏ hàng
        System.out.println("\nIn giỏ hàng:");
        cart.print();

        // Kiểm tra xóa Media
        System.out.println("\nKiểm tra xóa Media:");
        cart.removeMedia(book);

        // Hiển thị lại giỏ hàng
        System.out.println("\nHiển thị giỏ hàng sau khi xóa:");
        cart.displayCart();

        // In lại giỏ hàng
        System.out.println("\nIn giỏ hàng sau khi xóa:");
        cart.print();
    }
}