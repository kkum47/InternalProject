package item.test;

import static org.junit.Assert.*;
import item.Item;

import order.OrderDetail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class ItemTest {
	OrderDetail orderDetail;
	Item item;

	/*
	 * Map<String, List<String>> itemList = new HashMap<String, List<String>>();
	 * List<String> listOne = new ArrayList<String>(); List<String> listTwo =
	 * new ArrayList<String>(); List<String> listThree = new
	 * ArrayList<String>();
	 */

	@Before
	public void setUp() throws Exception {
		/*
		 * listOne.add("10"); listOne.add("100");
		 * listOne.add(" logitech mouse"); listTwo.add("65");
		 * listTwo.add("5000"); listTwo.add(" hp printer"); listThree.add("50");
		 * listThree.add("20000"); listThree.add("lenovo desktop");
		 * itemList.put("mouse",listOne); itemList.put("printer",listTwo);
		 * itemList.put("desktop",listThree);
		 */

		item = new Item();
		orderDetail = new OrderDetail();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testShippingWeight() {
		double expectWeight = 45.5;
		item.setShippingWeight(expectWeight);
		double actualWeight = item.getShippingWeight();
		assertEquals(expectWeight, actualWeight, 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testShippingWeightNull() {
		double expectWeight = -4;
		item.setShippingWeight(expectWeight);

	}

	@Test
	public void testDescription() {

		String expectResult = "hp printer";
		item.setDescription(expectResult);
		String actualResult = item.getDescription();
		assertEquals(expectResult, actualResult);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testDescriptionNull() {
		item = new Item();
		String expectResult = null;
		item.setDescription(expectResult);

	}

	@Test
	public void testGetOrderdetail() {
		orderDetail = new OrderDetail();
		item.setOrderDetail(orderDetail);
		OrderDetail orderRef = item.getOrderDetail();
		assertTrue(orderRef instanceof OrderDetail);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrderdetail() {
		orderDetail = null;
		item.setOrderDetail(orderDetail);

	}

	@Test
	public void testGetPriceForQuantity() {
		double expectResult = 12000.0;
		orderDetail.setQuantity(5);
		item.setPrice(2400.0);
		item.setOrderDetail(orderDetail);
		double actualResult = item.getPriceForQuantity();
		assertEquals(expectResult, actualResult, 0);

	}

	@Test
	public void testGetWeight() {
		item.setShippingWeight(45.5);
		assertEquals(45.5, item.getWeight(), 0);
	}

}
