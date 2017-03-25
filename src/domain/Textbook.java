package domain;

public class Textbook {

	private String ISBN;
	private String title;
	private String author;
	private double price;
	
	public Textbook(String ISBN, String title, String author, double price) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.price = price;
		
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
