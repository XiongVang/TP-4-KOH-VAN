package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import domain.Copy;
import domain.Patron;
import domain.Textbook;

public class CopyTest {

	private Copy copy;
	private Textbook tb;
	private String testISBN, testTitle, testAuthor, copyId;
	private double testPrice;
	
	@Before
	public void setUp() throws Exception {
		this.testISBN = "0123456789";
		this.testTitle = "test title";
		this.testAuthor = "test author";
		this.testPrice = 1.01;
		this.copyId = "C1";
		this.tb = new Textbook(testISBN, testTitle, testAuthor, testPrice);
		this.copy = new Copy(this.copyId,this.tb);
	}

	@Test
	public void testCopy() {
		assertNotNull("Copy should not be null", new Copy(this.copyId,this.tb));
	}

	@Test
	public void testGetCopyID() {
		assertSame("values should match",this.copy.getCopyID(),this.copyId);
	}

	@Test
	public void testGetCopyDescription() {
		assertSame("values should match",this.copy.getCopyDescription(),this.tb);
	}

	@Test
	public void testSetOutTo() {
		Patron patron = new Patron("P1", "test name", null);
		assertNull("copy should not be checked out",this.copy.getOutTo());		
		this.copy.setOutTo(patron);
		assertSame("copy should be checked out",this.copy.getOutTo(),patron);
	}

	@Test
	public void testGetOutTo() {
		assertNull("copy should not be checked out",this.copy.getOutTo());
	}

	@Test
	public void testToString() {
		assertNotNull("copy toString should not be null",this.copy.toString());
	}

}
