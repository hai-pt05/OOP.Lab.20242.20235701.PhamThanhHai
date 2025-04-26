package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(int id, String title, String category, float cost, String artist) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>(tracks);
    }

    // Getter
    public String getArtist() {
        return artist;
    }

    // Thêm bài hát
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm bài hát: " + track.getTitle());
        } else {
            System.out.println("Bài hát " + track.getTitle() + " đã tồn tại!");
        }
    }

    // Xóa bài hát
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa bài hát: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy bài hát: " + track.getTitle());
        }
    }

    // Tính tổng thời lượng
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory())
          .append(" - Artist: ").append(artist).append(": ").append(getCost()).append(" $\n");
        sb.append("Tracks:\n");
        for (Track track : tracks) {
            sb.append("  ").append(track.toString()).append("\n");
        }
        return sb.toString();
    }

    // play_Lab3_Sec11
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD Artist: " + getArtist());
        System.out.println("Total length: " + getLength() + " min");
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
}