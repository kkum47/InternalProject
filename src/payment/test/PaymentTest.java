package payment.test;

import static org.junit.Assert.*;
import order.Order;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import payment.Payment;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class PaymentTest {
	Payment paymentRef = new Payment();
	Order orderRef = new Order();

	@Before
	public void setUp() throws Exception {
		paymentRef.setAmount();
		paymentRef.setOrder(orderRef);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGetAmount() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetOrder() {
		fail("Not yet implemented");
	}

}
