package networkTest;

import static org.junit.Assert.*;
import network.ShannonsModel;

import org.junit.Test;

public class ShannonsModelTest {

	public ShannonsModel testShannonsModel = new ShannonsModel();
	
	@Test
	public void testShannonsModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSetBandWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSetSignalToNoise() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetMaximumDataRate() {
		testShannonsModel.setBandWidth(5);
		testShannonsModel.setSignalToNoise(20);
		System.out.print(testShannonsModel.getMaximumDataRate());
		assertTrue(testShannonsModel.getMaximumDataRate() == 33.29105741375898);
	}

	@Test
	public void testToString() {
		testShannonsModel.setBandWidth(5);
		testShannonsModel.setSignalToNoise(20);
		String testToString = testShannonsModel.toString();
		System.out.println(testToString);
		assertTrue(testToString.equals("B = 5.0 S/N = 20.0 Max D/R = 33.29105741375898"));
	}

}
