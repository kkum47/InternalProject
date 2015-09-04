package payment;

import order.Order;
/**
 * @author charul, kaushal, nimisha
 *
 */
enum CardType{maestro, visa, mastercard}

public class Credit extends Payment implements Authorization {

	private String number;
	private String expDate;
	private String type;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if (number.length()!=16)
		{
			throw new IllegalArgumentException("number length should be equal to 16");
		}
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type == null) {
			throw new NullPointerException("Card type can't be null");
		}
		else if (type.equals("maestro")||type.equals("visa")||type.equals("mastercard")) {
			this.type = type;
		}
		else
			throw new IllegalArgumentException("Card type not valid");
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public boolean authorized() {
		// TODO Auto-generated method stub
		Order ref = getOrder();
		if (expDate.equals(ref.getDate())) {
			return true;
		}
		return false;
	}

}
