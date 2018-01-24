package fi.haagahelia.ohjtek.bookstore.domain;


public class Book {
	private String name;
	private String author;
	private int year;
	private String isbn;
	private double price;
	public Book(String name, String author, int year, String isbn, double price) {
		super();
		this.name = name;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", year=" + year + ", isbn=" + isbn + ", price=" + price
				+ "]";
	}

}
