package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media {
    private int length;
    private String director;

    // Constructor
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}