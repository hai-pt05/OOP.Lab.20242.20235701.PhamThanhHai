package Aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0; 
    private int id; 

    // Constructor 1: Chỉ dùng title
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs; 
    }

    // Constructor 2: Dùng category, title và cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++; 
        this.id = nbDigitalVideoDiscs; 
    }

    // Constructor 3: Dùng director, category, title và cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; 
    }

    // Constructor 4: Dùng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getter cho các thuộc tính
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Getter cho nbDigitalVideoDiscs (Sec16_để kiểm tra tổng số DVD)
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Setter cho title (Sec 15_TestPassingParameter)
    public void setTitle(String title) {
        this.title = title;
    }
}