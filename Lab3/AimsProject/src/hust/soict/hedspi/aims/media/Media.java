package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    protected int id;
    private String title;
    private String category;
    private float cost;

    // Các Comparator để sắp xếp
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getter và Setter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // toString
    public String toString() {
        return "Media - " + title + " - " + category + ": " + cost + " $";
    }

    // equals - So sánh dựa trên title
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title.equals(other.title);
    }
}