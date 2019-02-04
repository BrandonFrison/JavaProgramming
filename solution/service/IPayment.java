package service;

import java.io.Serializable;

import model.CreditCard;
import model.CreditLimitException;

/**
 * @author Michal Aibin
 */
public interface IPayment extends Serializable{

	void payment(CreditCard cc) throws CreditLimitException;
	
	void payOff(CreditCard cc);
}
