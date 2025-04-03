package Aims;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	//1. Chỉ dùng title
    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    
    //2. Dùng category, title và cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    //3. Dùng director, category, title và cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }
    
    //4. Dùng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;  
        this.cost = cost;
    }
	
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
	

}
