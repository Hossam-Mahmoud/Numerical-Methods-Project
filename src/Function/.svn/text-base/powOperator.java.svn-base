package Function;

public class powOperator extends Function{

	private Function func1, func2;
	
	public powOperator(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}
	
	@Override
	public double evaluate(double val) {
		return Math.pow(func1.evaluate(val), func2.evaluate(1));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new mulOperator(func2, new powOperator(func1, new constant(func2.evaluate(1)-1))), func1.differentiate());
	}

	@Override
	public String toString() {
		return "(" + func1.toString() + ")^(" + func2.toString() + ")";
	}

}
