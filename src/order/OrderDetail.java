package order;

import item.Item;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class OrderDetail {
	private int quantity;
	private String taxStatus;
	private Order order;
	private Item item;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int d) {
		if(d<=0)
		{
			throw new IllegalArgumentException("quantity should be greater than zero");
		}
		this.quantity = d;
	}

	public String getTaxStatus() {
		return taxStatus;
	}

	public void setTaxStatus(String taxStatus) {
       if(taxStatus.equals("taxable")||taxStatus.equals("non-taxable") )
       {
    	   this.taxStatus=taxStatus;
       }
       else
       {
    	   throw new IllegalArgumentException("not valid tax status");
       }
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if(order==null)
		{
			throw new IllegalArgumentException("order entered is null");	
		}
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		if(item==null)
		{
			throw new IllegalArgumentException("item entered is null");	
		}
		
		this.item = item;
	}

	public double calcSubTotal() {
		return item.getPriceForQuantity();
	}

	public double calcWeight() {
		return item.getShippingWeight() * quantity;
	}
}
