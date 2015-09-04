package customer;

import order.Order;

/**
 * @author charul, kaushal, nimisha
 *
 */
public class NewCustomer {
	private String name;
	private String address;
	private Order order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException("Name can't be null");
		}
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new NullPointerException("Address can't be null");
		}
		this.address = address;
	}

	public Object getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
