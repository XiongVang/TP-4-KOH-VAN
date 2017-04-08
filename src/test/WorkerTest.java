package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WorkerTest {
	
	private Worker w;
	
	@Before
	public void setUp() throws Exception {
		this.w = new Worker("W1","test name");
	}

	@Test
	public void testWorker() {
		assertNotNull("Worker should be created", new Worker("W2","test name"));
	}

	@Test
	public void testGetName() {
		assertNotNull("Worker should be created", this.w.getName());
	}

	@Test
	public void testSetName() {
		String name = "new name";
		this.w.setName(name);
		assertSame("Worker name should match new name",this.w.getName(),name);
	}

	@Test
	public void testGetEmployeeID() {
		assertNotNull("Worker ID name should match new name",this.w.getEmployeeID());
	}

}
