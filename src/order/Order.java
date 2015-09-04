package order;

import java.sql.Date;
import java.text.*;
import java.util.*;

import payment.Payment;
import customer.NewCustomer;
/**
 * @author charul, kaushal, nimisha
 *
 */
enum Status {
	pending, dispatched, delivered
}

public class Order {
	private Date date;
	private Status status;
	private NewCustomer customer;
	private Payment payment;
	private OrderDetail orderdetail;
	List<OrderDetail> list = new ArrayList<OrderDetail>();

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date(0);
		return dateFormat.format(date); // 2014/08/06 15:59:48
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public NewCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(NewCustomer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public OrderDetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(OrderDetail orderdetail) {
		list.add(orderdetail);
	}

	public double calcTax() {
		Iterator<OrderDetail> it = list.iterator();
		double tax = 0.0;
		while (it.hasNext()) {
			OrderDetail orderRef = it.next();
			if (orderRef.getTaxStatus().equalsIgnoreCase("taxable")) {
				tax = tax + 0.14 * orderRef.calcSubTotal();
			}
		}
		return tax;
	}

	public double calcTotal() {
		Iterator<OrderDetail> it = list.iterator();
		double total = 0.0;
		while (it.hasNext()) {
			OrderDetail orderRef = it.next();
			total = total + orderRef.calcSubTotal();
		}
		total = total + calcTax();
		return total;
	}

	public double totalWeight() {
		Iterator<OrderDetail> it = list.iterator();
		double weight = 0.0;
		while (it.hasNext()) {
			OrderDetail orderRef = it.next();
			weight = weight + orderRef.calcWeight();
		}
		return weight;
	}
}