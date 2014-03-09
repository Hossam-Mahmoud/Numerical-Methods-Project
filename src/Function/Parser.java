package Function;

import java.util.Stack;

public class Parser {
	private String priorty = "^/*-+";
	private char plus = '+', minus = '-', mul = '*', pow = '^', div = '/';
	private char sin = 's', cos = 'c', exp = 'e', tan = 't', cotan = 'T', sec = 'S', cosec = 'C', ln = 'L';
	private char open = '(', close = ')';

	public Function parse(String s){
		/**
		 * Assumbtions sin = s cos = c
		 * 
		 * available operations is + - * / ^
		 * 
		 * priorty (descending)
		 * 
		 * ^ / * + -
		 * 
		 */

		// to make it easier replace each function with its corresponding letter

		s = s.replace("cosec", cosec+"");
		s = s.replace("sec", sec + "");
		
		s = s.replace("cotan", cotan+"");
		s = s.replace("tan", tan+"");
		
		s = s.replace("cos", cos + "");
		s = s.replace("sin", sin + "");
		
		s = s.replace("ln", ln+"");
		
		s = s.replace(" ", ""); // remove spaces
		
		Function f = convert(s);
		
		return f;
	}
	
	private Function convert(String s) {
		String func;
		Stack<Function> fun = new Stack<Function>();
		Stack<Character> oper = new Stack<Character>();
		char c;
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (isOperator(c)) {
				while (!oper.isEmpty() && compare(oper.peek(), c)) {
					if(fun.size() == 1 && oper.peek() == minus){
						fun.push(new mulOperator(fun.pop(), new constant(-1)));
						oper.pop();
					}
					else
						fun.push(getOperationFunction(oper.pop(), fun.pop(), fun.pop()));
				}
				oper.push(c);
				
			} else if (isFunction(c)) {
				i = getFunction(s, fun, i);
				
			} else if (c == open) {
				func = getFunString(s, i);
				Function f = convert(func);
				fun.push(f);
				i += func.length()+1;
				
			} else { // not function >> number
				func = getNumber(s, i);
				fun.push(new constant(Double.parseDouble(func)));
				i += func.length() - 1;
				
			}
		}

		while (!oper.isEmpty()) {
			if (fun.size() == 1) {
				fun.push(new mulOperator(new constant(-1), fun.pop()));
				oper.pop();
			} else {
				Function f1 = fun.pop(), f2 = fun.pop();
				fun.push(getOperationFunction(oper.pop(), f1, f2));
			}
		}
		return fun.pop();
	}

	
	private int getFunction(String s, Stack<Function> fun, int i){
		String function;
		char c = s.charAt(i);
		
		if(c == sin || c == cos || c == tan || c == cotan || c == sec || c == cosec || c == ln){
			function = getFunString(s, i + 1);
			Function f;
			
			if(c == sin)
				f = new sin(convert(function));
			else if(c == cos)
				f = new cos(convert(function));
			else if(c == tan)
				f = new tan(convert(function));
			else if(c == sec)
				f = new sec(convert(function));
			else if(c == cosec)
				f = new cosec(convert(function));
			else if(c == cotan)
				f = new cotan(convert(function));
			else //if(c == ln)
				f = new ln(convert(function));
			
			fun.push(f);
			i += function.length() + 2; // update index

		}else if (c == exp) { // exp
			Function e;
			if (i + 1 < s.length() && s.charAt(i + 1) == pow) {
				if (s.charAt(i + 2) == open) {
					function = getFunString(s, i + 2);
					e = new exp(convert(function));
					i += function.length() + 3;// update index
				} else {
					int start = i = i + 2;
					while (i < s.length() && !isOperator(s.charAt(i)))
						i++;
					e = new exp(convert(s.substring(start, i)));
					i--;
				}

			} else { // e without ^ , which means e^1 = e
				e = new exp(new constant(1));
			}
			fun.push(e);

		} else { // x
			Function x = null;
			if (i + 1 < s.length() && s.charAt(i + 1) == pow) {
				if (s.charAt(i + 2) == open) {
					function = getFunString(s, i + 2);
					 x = new powOperator(new polynomial(1, 1),parse(function));
					i += function.length() + 3;// update index
				} else {
					function = getNumber(s, i + 2);
					x = new polynomial(1, Integer.parseInt(function));
					i += function.length() + 1;// update index
				}
			} else { // x without ^ , which means x^1 = x
				x = new polynomial(1, 1);
			}
			fun.push(x);
		}
		
		return i;
	}
	
	private String getNumber(String s, int i) {
		String ret = "";
		while (i < s.length() && isNumber(s.charAt(i)))
			ret += s.charAt(i++);
		return ret;
	}

	private String getFunString(String s, int i) {
		int b = i;
		int cnt = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) == open)
				cnt++;
			else if (s.charAt(i) == close)
				cnt--;
			if (cnt == 0)
				return s.substring(b + 1, i);
		}
		return "Invalid Expression";
	}

	/**
	 * 
	 * @param op1
	 *            first operator
	 * @param op2
	 *            second operator
	 * @return true if op1 > op2 i.e op1 has higher precedence than op2
	 */
	private boolean compare(char op1, char op2) {
		return priorty.indexOf(op1) <= priorty.indexOf(op2); // yes it's < .
	}

	private boolean isOperator(char c) {
		return priorty.contains(c + "");
	}

	private boolean isFunction(char c) {
		return c == sin || c == cos || c == exp || c == 'x' || c == ln
				|| c == tan || c == cotan || c == sec || c == cosec;
	}

	private boolean isNumber(char c) {
		return (c >= '0' && c <= '9') || c == '.';
	}

	private Function getOperationFunction(char c, Function f1, Function f2) {

		if (c == plus) 
			return new plusOperator(f2, f1);
		else if (c == minus)
			return new minusOperator(f2, f1);
		else if (c == mul)
			return new mulOperator(f2, f1);
		 else if(c == div)
			return new divOperator(f2, f1);
		else // c == pow
			return new powOperator(f2, f1);
	}

}
