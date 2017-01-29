package networkTest;
import static org.junit.Assert.*;
import java.text.DecimalFormat;
import network.ShannonsTheorem;
import org.junit.Test;

public class ShannonsTheoremJUnit {
	
ShannonsTheorem st1 = new ShannonsTheorem();
ShannonsTheorem st2 = new ShannonsTheorem();
		
	@Test
	
//	Tests whether the no argument constructor and constructor with arguments are set correctly.
	
	public void testConstructorsAndGetters() {
		
		assertTrue("Ensure that bandwith is set using no argument constructor ", st1.getBandWidth() == 0);
		assertTrue("Ensure that signal to noise is set using no argument constructor ", st1.getSignalToNoise() == 0);
		assertTrue("Ensure that bandwith is set using initial constructor ", st2.getBandWidth() == 5);
		assertTrue("Ensure that signal is set using initial constructor ", st2.getSignalToNoise() == 5);



	}
	
	@Test
	public void testSetters(){
		assertFalse("Does the value not equal 5 ", st1.getBandWidth() == 5);
		st1.setBandWidth(5);
		st1.setSignalToNoise(5);
		assertTrue("Does the value equal 5 ", st1.getBandWidth() == 5); 
}
	
	@Test
	public void testgetMaximumDataRates(){
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
//		assertTrue("Does a bandwidth of 5 and S/N of 5 = 10.29", decimalFormat.format(st2.getMaximumDataRate()).equals("10.29"));
		
	}
	
	
}
