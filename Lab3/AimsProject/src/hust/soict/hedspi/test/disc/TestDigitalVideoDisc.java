package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestDigitalVideoDisc {
    public static void main(String[] args) {
        // Tạo các DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Sci-fi", "Inception", 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Nolan", "Sci-fi", "Interstellar", 29.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-fi", "Cameron", 162, 39.99f);

        // In thông tin
        System.out.println("DVD 1: id = " + dvd1.getId() + ", title = " + dvd1.getTitle());
        System.out.println("DVD 2: id = " + dvd2.getId() + ", title = " + dvd2.getTitle());
        System.out.println("DVD 3: id = " + dvd3.getId() + ", title = " + dvd3.getTitle());
        System.out.println("DVD 4: id = " + dvd4.getId() + ", title = " + dvd4.getTitle());
        System.out.println("Tổng số DVD: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}