package Function;

public class tan extends Function {

	private Function func;
	public tan(Function f) {
		func = f;
	}
	
	@Override
	public double evaluate(double val) {
		return Math.tan(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new powOperator(new sec(func), new constant(2)), func.differentiate());
	}

	@Override
	public String toString() {
		return "tan(" + func.toString() + ")";
	}

}
