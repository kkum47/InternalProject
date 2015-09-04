package order.test;

import static org.junit.Assert.*;
import item.Item;
import order.Order;
import order.OrderDetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class OrderDetailTest {
	OrderDetail orderDetail;
	Order order;
	Item item;

	@Before
	public void setUp() throws Exception {
		orderDetail = new OrderDetail();
		item = new Item();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetQuantity() {
		int expectResult = 6;
		orderDetail.setQuantity(expectResult);
		int actualResult = orderDetail.getQuantity();
		assertEquals(expectResult, actualResult);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetQuantity() {
		int expectResult = -6;
		orderDetail.setQuantity(expectResult);
	}

	@Test
	public void testTaxStatus() {
		String expect = "taxable";
		orderDetail.setTaxStatus(expect);
		String actual = orderDetail.getTaxStatus();
		assertEquals(expect, actual);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testTaxStatusRandom() {
		String expect = "random";
		orderDetail.setTaxStatus(expect);

	}

	@Test
	public void testOrder() {
		order = new Order();
		orderDetail.setOrder(order);
		Order actualOrder = orderDetail.getOrder();
		assertTrue(actualOrder instanceof Order);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrderNull() {
		order = null;
		orderDetail.setOrder(order);

	}

	@Test
	public void testItem() {

		orderDetail.setItem(item);
		Item actual = orderDetail.getItem();
		assertTrue(actual instanceof Item);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testItemNull() {
		Item item2 = null;
		orderDetail.setItem(item2);
	}

	@Test
	public void testCalcSubTotal() {
		double expectResult = 12000.0;
		orderDetail.setQuantity(5);
		item.setPrice(2400.0);
		item.setOrderDetail(orderDetail);
		orderDetail.setItem(item);
		double actualResult = orderDetail.calcSubTotal();
		assertEquals(expectResult, actualResult, 0);

	}

	@Test
	public void testCalcWeight() {
		orderDetail.setQuantity(5);
		item.setShippingWeight(50.0);
		orderDetail.setItem(item);
		double expectResult = 250.0;
		double actualResult = orderDetail.calcWeight();
		assertEquals(expectResult, actualResult, 0);

	}

}
