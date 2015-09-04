package payment;

import java.util.ArrayList;
import java.util.List;
/**
 * @author charul, kaushal, nimisha
 *
 */
public class Cheque extends Payment implements Authorization {
	List<String> BankList = new ArrayList<String>();
	private String name;
	private String bankID;

	public Cheque() {
		BankList.add("SBI");
		BankList.add("ICICI");
		BankList.add("HDFC");
		BankList.add("IDBI");
		BankList.add("YES");
		BankList.add("CITI");
		BankList.add("UNION");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullPointerException("Bank name can't be null");
		}
		if (BankList.contains(name)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Bank name is not valid");
		}
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		if (bankID == null) {
			throw new NullPointerException("Bank name can't be null");
		}
		this.bankID = bankID;
	}

	public boolean authorized() {
		// TODO Auto-generated method stub
		int len = name.length();
		if (len >= 4) {
			if (name.substring(0, 3).equalsIgnoreCase(bankID.substring(0, 3))) {
				return true;
			}
		}
		if (name.equalsIgnoreCase(bankID.substring(0, len))) {
			return true;
		}
		return false;

	}

}
