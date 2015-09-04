package customer.test;

import static org.junit.Assert.*;
import order.Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import customer.NewCustomer;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class NewCustomerTest {
	NewCustomer newcustomerRef = new NewCustomer();
	Order orderRef = new Order();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetNameValid() {
		String expectedName = "Raja";
		newcustomerRef.setName(expectedName);
		assertEquals(expectedName, newcustomerRef.getName());
	}

	@Test(expected = NullPointerException.class)
	public final void testGetNameNull() {
		String expectedName = null;
		newcustomerRef.setName(expectedName);
		assertEquals(expectedName, newcustomerRef.getName());
	}

	@Test
	public final void testGetAddressValid() {
		String expectedAddress = "Gurgaon";
		newcustomerRef.setAddress(expectedAddress);
		assertEquals(expectedAddress, newcustomerRef.getAddress());
	}

	@Test(expected = NullPointerException.class)
	public final void testGetAddressNull() {
		String expectedAddress = null;
		newcustomerRef.setAddress(expectedAddress);
		assertEquals(expectedAddress, newcustomerRef.getAddress());
	}

	@Test
	public final void testGetOrder() {
		assertTrue(orderRef instanceof Order);
	}

}
