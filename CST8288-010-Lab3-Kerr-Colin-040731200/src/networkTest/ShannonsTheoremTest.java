package networkTest;

import static org.junit.Assert.*;
import network.ShannonsTheorem;

import org.junit.Test;

public class ShannonsTheoremTest {
	public ShannonsTheorem testShannonsTheorem = new ShannonsTheorem();
	
		// TODO Auto-generated constructor
	@Test
	public void testShannonsTheorem() {
		assertTrue("Object is null after calling constructor", testShannonsTheorem != null);
		}

	@Test
	public void testGetSetBandWidth() {
		testShannonsTheorem.setBandWidth(5);
		assertTrue("Bandwith setter or getter is not working correctly", testShannonsTheorem.getBandWidth() == 5);
	}

	@Test
	public void testGetSetSignalToNoise() { //copy above use a different value than 5
		fail("Not yet implemented");
	}

}
