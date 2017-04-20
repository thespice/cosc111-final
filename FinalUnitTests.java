import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Random;

public class FinalUnitTests 
{
	/*
	 * Test the converter from kilometers to miles.
	 */
	@Test
	public void Test1ConverterTest() 
	{
		// Convert from kilometers to miles
		assertEquals(0.62, Helper.Converter(1.0, 1), 0.01);
		assertEquals(3.11, Helper.Converter(5.0, 1), 0.01);
		// Convert from miles to kilometers
		assertEquals(1.609, Helper.Converter(1.0, 2), 0.01);
		assertEquals(8.046, Helper.Converter(5.0, 2), 0.01);
	}

	/*
	 * Generate a certain number of random numbers between 
	 * a certain range.
	 */
	@Test
	public void Test2GenerateRandoms()
	{
		int[] rn1 = Helper.generateRandom(10, 0, 10);
		assertEquals(10, rn1.length);
		for (int i=0; i<rn1.length; i++)
		{
			assertTrue((rn1[i] >= 0) && (rn1[i] <= 10));
		}
		int[] rn2 = Helper.generateRandom(15, -10, 25);
		assertEquals(15, rn2.length);
		for (int i=0; i<rn2.length; i++)
		{
			assertTrue((rn2[i] >= -10) && (rn2[i] <= 25));
		}
	}
	
	/*
	 * Find the smallest number that divides both integers n1 and n2
	 */
	@Test
	public void Test3FinndSmallestFactor()
	{
		assertEquals(2, Helper.findSmallestNumberThatDivides(4, 6));
		assertEquals(5, Helper.findSmallestNumberThatDivides(10, 15));
		assertEquals(11, Helper.findSmallestNumberThatDivides(11, 121));
		assertEquals(7, Helper.findSmallestNumberThatDivides(14, 49));
	}
	
	/*
	 * Find the mean of numbers
	 */
	@Test
	public void Test4FindMean()
	{
		double[] vals1 = {1,2,3};
		assertEquals(2, Helper.findMean(vals1), 0.01);
		double[] vals2 = {10,11,14,16,8,7};
		assertEquals(11, Helper.findMean(vals2), 0.01);
		double[] vals3 = {9,2,1,5,20,10,21};
		assertEquals(9.71429, Helper.findMean(vals3), 0.01);
	}
	
	/*
	 * Check if the SSN was issued in MI. 
	 * The first three digits of a MI SSN is between 362–386.
	 */
	@Test
	public void Test5IsMISSN()
	{
		assertEquals(false, Helper.isMichiganSSN(Long.parseLong("222667703")));
		assertEquals(false, Helper.isMichiganSSN(Long.parseLong("049161215")));
		assertEquals(true, Helper.isMichiganSSN(Long.parseLong("372373950")));
		assertEquals(true, Helper.isMichiganSSN(Long.parseLong("364913650")));
	}
	
	/*
	 * Calculate the time for a loan to double.
	 */
	@Test
	public void Test6CalculateDoublingTime()
	{
		assertEquals(14.21, Helper.calculateDoublingTime(5.0), 0.1);
		assertEquals(2.64, Helper.calculateDoublingTime(29.99), 0.1);
		assertEquals(11.90, Helper.calculateDoublingTime(6.0), 0.1);
		assertEquals(1, Helper.calculateDoublingTime(100.0), 0.1);
	}
	
	/* 
	 * Test the equals to string of the MAC address.
	 */
	@Test
	public void Test7NetworkMACAddress()
	{
		NetworkInterface nic = new NetworkInterface("D1:77:42:A6:3B:63");
		assertTrue(nic.equals("D1:77:42:A6:3B:63"));
		assertFalse(nic.equals("60:34:46:2E:91:C2"));
		nic = new NetworkInterface("2E:68:D9:78:68:E9");
		assertFalse(nic.equals("CB:8D:F2:E9:69:33"));
		assertTrue(nic.equals("2E:68:D9:78:68:E9"));
	}
	
	/*
	 * Test that the address is formatted correctly
	 */
	@Test
	public void Test8AddressFormat()
	{
		Address a1 = new Address("123 6th St.", "Melbourne", "FL", 32904);
		assertEquals("123 6th St. Melbourne, FL 32904", a1.toString());
		Address a2 = new Address("70 Bowman St.", "South Windsor", "CT", 06074);
		assertEquals("70 Bowman St. South Windsor, CT 06074", a2.toString());
		Address a3 = new Address("4 Oak Meadow Rd.", "Dyersburg", "TN", 38024);
		assertEquals("4 Oak Meadow Rd. Dyersburg, TN 38024", a3.toString());
	}
	
	/*
	 * Test that the product class and product ID are generated correctly
	 */
	@Test
	public void Test9ProductID()
	{
		Product p1 = Helper.makeProduct(111, 2, 3);
		assertEquals("222111B3", p1.getId());
		Product p2 = Helper.makeProduct(212, 1, 0);
		assertEquals("222212R0", p2.getId());
		Product p3 = Helper.makeProduct(1011, 1, 11);
		assertEquals("223011R11", p3.getId());
	}
	
	/*
	 * Testing finding the Wireless Adapter from NIC
	 */
	@Test
	public void Test10FindMACAddress()
	{
		// Create a list of network interfaces with the given MAC addresses
		WirelessAdapter[] nics1 = new WirelessAdapter[10];
		for (int i=0; i<nics1.length; i++)
		{
			nics1[i] = new WirelessAdapter();
			nics1[i].MAC_address = Helper.randomMACAddress(i);
		}
		WirelessAdapter w1 = Helper.findbyMACAddress(nics1, "99:02:93:9D:1D:0B"); 
		assertNull(w1);
		WirelessAdapter w2 = Helper.findbyMACAddress(nics1, "4C:93:26:BB:98:05");
		assertNotNull(w2);
		assertEquals(w2.MAC_address, "4C:93:26:BB:98:05");
		assertEquals(w2, nics1[3]);
		WirelessAdapter w3 = Helper.findbyMACAddress(nics1, "4A:38:B0:2D:92:0F");
		assertNull(w3);
		WirelessAdapter w4 = Helper.findbyMACAddress(nics1, "F8:BC:F1:BA:38:AE");
		assertNotNull(w4);
		assertEquals(w4.MAC_address, "F8:BC:F1:BA:38:AE");
		assertEquals(w4, nics1[8]);
	}
}

