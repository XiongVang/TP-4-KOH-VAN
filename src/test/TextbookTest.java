package domain;

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
		assertSame("ISBN should be " + testISBN,this.tb.getISBN(),this.testISBN);
	}

	@Test
	public void testGetTitle() {
		assertSame("Title should be " + testTitle,this.tb.getTitle(),this.testTitle);
	}

	@Test
	public void testGetAuthor() {
		assertSame("Author should be " + testAuthor,this.tb.getAuthor(),this.testAuthor);
	}

	@Test
	public void testGetPrice() {
		// Why is this failing?
		assertSame("price should match",this.tb.getPrice(),1.01);
	}

	@Test
	public void testSetPrice() {
		double oldPrice = this.tb.getPrice();
		double newPrice = 1.20;
		this.tb.setPrice(newPrice);
		// Why is this failing?
		assertNotSame("New price should not match old price",Double.valueOf(this.tb.getPrice()),Double.valueOf(oldPrice));
		assertSame("Price should be updated",Double.valueOf(this.tb.getPrice()),Double.valueOf(newPrice));
	}

}
