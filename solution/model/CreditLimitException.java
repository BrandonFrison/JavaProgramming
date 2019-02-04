package model;
/**
 * @author Michal Aibin
 */
public class CreditLimitException extends Exception{

	private static final long serialVersionUID = 5501204284087007281L;
	
	public CreditLimitException(){
		super("You exceeded you account limit!");
	}

}
