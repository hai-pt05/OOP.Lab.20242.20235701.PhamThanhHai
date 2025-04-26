package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // toString
    public String toString() {
        return "Track - " + title + " - " + length + " min";
    }

    // equals - So sánh dựa trên title và length
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return this.title.equals(other.title) && this.length == other.length;
    }

    // play_Lab3_sec11
    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength());
    }
}