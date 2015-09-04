package order.test;

import java.util.*;

import static org.junit.Assert.*;
import item.*;
import order.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import payment.Credit;
import payment.Payment;
import customer.NewCustomer;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class OrderTest {
	Order testOrder = new Order();
	Payment testPayment = null;
	NewCustomer testCustomer = null;
	List<OrderDetail> testOrderDetail = new ArrayList<OrderDetail>();
	Item testItem = null;
	Iterator<OrderDetail> it = null;

	@Before
	public void setUp() throws Exception {
		testItem = new Item();
		testCustomer = new NewCustomer();
		testPayment = new Payment();
		it = testOrderDetail.iterator();
	}

	@Test
	public final void testCustomer() {
		testOrder.setCustomer(testCustomer);
		NewCustomer actualCustomer = testOrder.getCustomer();
		assertEquals(testCustomer, actualCustomer);
	}

	@Test
	public final void testPayment() {
		testOrder.setPayment(testPayment);
		Payment actualPayment = testOrder.getPayment();
		assertEquals(testPayment, actualPayment);
	}

	@Test
	public final void testOrderDetail() {
		testOrder.setOrderDetail(testOrderDetail);
		List<OrderDetail> actualOrder = testOrder.getOrderDetail();
		assertEquals(testOrderDetail, actualOrder);
	}

	@Test
	public final void testCalcTax() {
		double expectedcalcTax = 14.0;
		OrderDetail orderRef = new OrderDetail();
		testItem.setPrice(20.0);
		orderRef.setItem(testItem);
		orderRef.setQuantity(5);
		orderRef.setTaxStatus("taxable");
		testOrderDetail.add(orderRef);
		testOrder.setOrderDetail(testOrderDetail);
		double actualcalcTax = testOrder.calcTax();

		assertEquals(expectedcalcTax, actualcalcTax, 0.1);

	}

	@Test
	public final void testCalcTotal() {
		double expectedcalcTotal = 150.0;
		OrderDetail orderRef = new OrderDetail();
		testItem.setPrice(30.0);
		orderRef.setItem(testItem);
		orderRef.setQuantity(5);

		testOrderDetail.add(orderRef);
		testOrder.setOrderDetail(testOrderDetail);
		double actualcalcTotal = testOrder.calcTotal();

		assertEquals(expectedcalcTotal, actualcalcTotal, 0.1);

	}

	@Test
	public final void testCalcTotalWeight() {
		double expectedcalcTotalWeight = 100.0;
		OrderDetail orderRef = new OrderDetail();
		testItem.setShippingWeight(20.0);
		orderRef.setItem(testItem);
		orderRef.setQuantity(5);

		testOrderDetail.add(orderRef);
		testOrder.setOrderDetail(testOrderDetail);
		double actualcalcTotalWeight = testOrder.calcTotalWeight();

		double delta = 0.0;
		assertEquals(expectedcalcTotalWeight, actualcalcTotalWeight, delta);

	}

	@Test
	public final void testStatus() {
		testOrder.setStatus("dispatched");
		String status = testOrder.getStatus();
		assertTrue(status.equals("dispatched"));
	}

	@After
	public void tearDown() throws Exception {
		testItem = null;
		testCustomer = null;
		testPayment = null;
	}

}
