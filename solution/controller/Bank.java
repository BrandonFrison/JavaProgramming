package controller;
import service.impl.PaymentImpl;
import model.CreditCard;
import model.CreditLimitException;

/**
 * @author Michal Aibin
 */
public class Bank {
	
	/**
	 * @param args
	 * @throws CreditLimitException 
	 */
	public static void main(String[] args){
		PaymentImpl payments = new PaymentImpl();
		CreditCard cc = new CreditCard();
		for (int i = 1; i <= 90; i++){
			try {
				payments.payment(cc);
			} catch (CreditLimitException e) {
				System.out.println("You need to wait for your payment day!");
			}
			if (i%30 == 0){
				System.out.println("Payment day!");
				payments.payOff(cc);
			}
			System.out.println("Balance at day #" + i + " equals: " + cc.getBalance());
		}
	}

}
