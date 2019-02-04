package model;
/**
 * @author Michal Aibin
 */
public class CreditCard {
	
	private final static int CREDIT_LIMIT = 1000;
	
	private double balance;
	
	public CreditCard(){
		this.balance = (int) (Math.random()*2000);
	}

	/**
	 * @return the creditLimit
	 */
	public int getCreditLimit() {
		return CREDIT_LIMIT;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance += balance;
	}
	
}
