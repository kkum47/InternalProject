package payment;

import order.Order;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class Payment {

	private double amount;
	private Order order;

	public double getAmount() {
		return amount;
	}

	public void setAmount() {
		amount = order.calcTotal();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
