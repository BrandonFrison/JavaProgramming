import java.util.*;

public class evaluatingLispExpressions {
	
	private LinkedStack<Object> inputBracketsStack;
	private LinkedStack<Double> operationEvaluationStack;
	
	private String currentOperation; //for test cases
	
	public evaluatingLispExpressions(){
		currentOperation = "";
		inputBracketsStack = new LinkedStack<>();
		operationEvaluationStack = new LinkedStack<>();
		
	}
	
	public evaluatingLispExpressions(String input){
		currentOperation = input;
		inputBracketsStack = new LinkedStack<>();
		operationEvaluationStack = new LinkedStack<>();
	}
	
	public void clean(String input){
		currentOperation = input;
		inputBracketsStack.clear();
		operationEvaluationStack.clear();
	}
	
	
	
	public double algorithm(){
		Scanner scanner = new Scanner(currentOperation); //breaks expression into tokens
		scanner = scanner.useDelimiter("\\s*");//whitespace as delimiter
		while(scanner.hasNext()){
			if(scanner.hasNextInt()){
				String data = scanner.findInLine("\\d+"); //grabs all digits in sequence
				inputBracketsStack.push(data);
			}else{
				String tempToken = scanner.next();
				
				char item = tempToken.charAt(0);
				
				switch(item){
				case '(':
					break;
				case '+': case '-': case '*': case '/':
					inputBracketsStack.push(String.valueOf(item));
					break;
				case ')':
					
					if(inputBracketsStack.isEmpty()){
			    		throwException("Empty Expression!");
			    	}
					String operatorPlaceholder = (String) inputBracketsStack.pop();
					
					while (!isOperator(operatorPlaceholder) && !inputBracketsStack.isEmpty()){
						operationEvaluationStack.push(Double.parseDouble(operatorPlaceholder));
						operatorPlaceholder = (String) inputBracketsStack.pop(); //gets next item
					}
					
					if(!operationEvaluationStack.isEmpty()){
						double tempResult = calculateStack(operatorPlaceholder);
						inputBracketsStack.push(String.valueOf(tempResult));
					}else{
			        	throwException("Missing part of the equation");	
			        }
					break;
				
				
			}
		}
		}
	return getFinalResult();
	}
	
	private double calculateStack(String operator){
		double result = 0.0;
		
		if(operator.equals("+")){
            result = add(); //simplified add in seperate method
        }
        else if(operator.equals("-")){
            result = (isStackOneItem()) ? evaluateSingle(operator) : subtract(); //simplified subtract in seperate method
        }
        else if(operator.equals("*")){
        	result = multiply(); //simplified multiply in seperate method
        }
        else if(operator.equals("/")){
            result = (isStackOneItem()) ? evaluateSingle(operator) : divide(); //simplified divide in seperate method
        }

        return result;
		
	}
	
	private double add(){
		 double result = operationEvaluationStack.pop();
		 		
		 while(!operationEvaluationStack.isEmpty()){
	         double value = operationEvaluationStack.pop();
	         result += value;
	     }

	     return result;
	    
	}
	
	private double subtract(){
	    double result = operationEvaluationStack.pop();
	    
        while(!operationEvaluationStack.isEmpty()){
            double value = operationEvaluationStack.pop();
            result -= value;
        }

        return result;
    }
	
	private double multiply(){
    	double result = operationEvaluationStack.pop();
        while(!operationEvaluationStack.isEmpty()){
            double value = operationEvaluationStack.pop();
            result *= value;
        }

        return result;
    }
	
	 private double divide(){
	    double result = operationEvaluationStack.pop();
	    while(!operationEvaluationStack.isEmpty()){
	        double value = operationEvaluationStack.pop();
	        result /= value;
	    }

	    return result;
	}
	 private double evaluateSingle(String operator){
	    double result = 0.0;
	    double value = operationEvaluationStack.pop();

	    switch(operator){
	    	case "-":	
	    		result -= value;
	    		break;
	    	case "/":	
	    		result = 1.0;
	    		result /= value;
	    		break;
	    	
	    
	    }

	   	return result;
	 }
	 
	 private double getFinalResult(){
	        return Double.parseDouble(String.valueOf(inputBracketsStack.pop()));
	 }
	 //method to check if char is operator
	 private boolean isOperator(String input){
	        return input.equals("+") || input.equals("-") ||
	               input.equals("*") || input.equals("/");
	 } 
	  private boolean isStackOneItem(){
	    	return operationEvaluationStack.length() == 1;
	 }
	  
	 
	  
	  private void throwException(String info){
	    	throw new LispExpressionException(info);
	    }
	  
	 private static void evaluateTestExpressions(String s, evaluatingLispExpressions lisp)
	 {
	        Double result;
	        System.out.println("Expression " + s);
		    lisp.clean(s);
	        try{
	           result = lisp.algorithm();
	           System.out.printf("Evaluated result : %.2f\n", result);
	        }
	        catch (LispExpressionException e) {
	            System.out.println("calculated to infinity");
	        }
	        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	 }
	  
	 public static void main(String args[]){
		 evaluatingLispExpressions lisp = new evaluatingLispExpressions();
		 String exp1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)))";
		 String exp2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (* 1) (- 21 3 1)))";
		 String exp3 = "(+ (/ 2) (* 2) (/ (+ 1) (+) (- 2 1 )))";
		 evaluateTestExpressions(exp1, lisp);
		 evaluateTestExpressions(exp2, lisp);
		 evaluateTestExpressions(exp3, lisp);
	 }
	 
	 
}
