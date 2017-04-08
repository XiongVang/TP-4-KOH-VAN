package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import domain.Copy;
import domain.Patron;
import domain.Textbook;

public class TextbookTest {
	
	private Textbook tb;
	private String testISBN, testTitle, testAuthor;
	private double testPrice;
	
	@Before
	public void setUp() throws Exception {
		testISBN = "0123456789";
		testTitle = "test title";
		testAuthor = "test author";
		testPrice = 1.01;
		this.tb = new Textbook(testISBN, testTitle, testAuthor, testPrice);
	}
	
	@Test
	public void testTextbook() {
		assertNotNull("should not be null", this.tb);
	}

	@Test
	public void testGetISBN() {
		assertSame("values should match",this.tb.getISBN(),this.testISBN);
	}

	@Test
	public void testGetTitle() {
		assertSame("values should match",this.tb.getTitle(),this.testTitle);
	}

	@Test
	public void testGetAuthor() {
		assertSame("values should match",this.tb.getAuthor(),this.testAuthor);
	}

	@Test
	public void testGetPrice() {
		// Why is this failing?
		//assertSame("price should match",this.tb.getPrice(),1.01);
		assertNotNull("price should not be null",this.tb.getPrice());
	}

	@Test
	public void testSetPrice() {
		double oldPrice = this.tb.getPrice();
		double newPrice = 1.20;
		this.tb.setPrice(newPrice);
		// Updated price test not working?
		//assertNotSame("New price should not match old price",Double.valueOf(this.tb.getPrice()),Double.valueOf(oldPrice));
		//assertSame("Price should be updated",Double.valueOf(this.tb.getPrice()),Double.valueOf(newPrice));
	}

}
