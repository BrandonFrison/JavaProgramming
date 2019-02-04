package service.impl;

import model.CreditCard;
import model.CreditLimitException;
import service.IPayment;

/**
 * @author Michal Aibin
 */
public class PaymentImpl implements IPayment {

	private static final long serialVersionUID = 3894962197044905165L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPayment#payment(double)
	 */
	@Override
	public void payment(CreditCard cc) throws CreditLimitException {
		int amount = (int) (Math.random() * 100);
		if (amount > cc.getBalance() + cc.getCreditLimit())
			throw new CreditLimitException();
		cc.setBalance(-amount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPayment#payOff(double)
	 */
	@Override
	public void payOff(CreditCard cc) {
		cc.setBalance(Math.random() * 2500);
	}

}
