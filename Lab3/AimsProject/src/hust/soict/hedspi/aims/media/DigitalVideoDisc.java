package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    // Constructor 1: Chỉ dùng title
    public DigitalVideoDisc(String title) {
        super(title, null, 0.0f);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 2: Dùng category, title và cost
    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 3: Dùng director, category, title và cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, director, 0, cost);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 4: Dùng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getter cho nbDigitalVideoDiscs
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // toString
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    // equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof DigitalVideoDisc)) return false;
        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        return this.getTitle().equals(other.getTitle());
    }

    // play_Lab3_Sec11
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}