package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Station;

public class StationTest {

	@Test
	public void testStation() {
		try {
			new Station();
		} catch (Exception e) {
			fail("failed Station: " + e.toString());
		}
	}

}
