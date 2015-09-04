package payment.test;

import static org.junit.Assert.*;
import order.Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import payment.Cheque;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class ChequeTest {
	Cheque chequeRef = new Cheque();
	Order orderRef = new Order();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCheque() {
		assertTrue(chequeRef instanceof Cheque);
	}

	@Test(expected = NullPointerException.class)
	public final void testGetNameNull() {
		String expectedName = null;
		chequeRef.setName(expectedName);
		assertEquals(expectedName, chequeRef.getName());
	}

	@Test
	public final void testGetNameValid() {
		String expectedName = "ICICI";
		chequeRef.setName(expectedName);
		assertEquals(expectedName, chequeRef.getName());
	}

	@Test(expected = NullPointerException.class)
	public final void testGetBankIDNull() {
		String expectedBankID = null;
		chequeRef.setBankID(expectedBankID);
		assertEquals(expectedBankID, chequeRef.getBankID());
	}

	@Test
	public final void testAuthorized() {
		chequeRef.setName("ICICI");
		chequeRef.setBankID("ICIC0123456");
		assertTrue(chequeRef.authorized());
	}

}
