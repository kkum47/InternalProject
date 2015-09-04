package item;

import order.OrderDetail;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class Item {
	private double price;
	private double shippingWeight;
	private String description;
	private OrderDetail orderDetail;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(double shippingWeight) {
		if (shippingWeight <= 0) {
			throw new IllegalArgumentException(
					"shipping weight should be positive");
		}
		this.shippingWeight = shippingWeight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Null description is entered");
		}

		this.description = description;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		if (orderDetail == null) {
			throw new IllegalArgumentException("Null orderdetail is entered");

		}

		this.orderDetail = orderDetail;
	}

	public double getPriceForQuantity() {
		return orderDetail.getQuantity() * price;
	}

	public double getWeight() {
		return shippingWeight;
	}
}
