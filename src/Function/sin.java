package Function;

public class sin extends Function {

	private Function func;

	public sin(Function f) {
		func = f;
	}

	@Override
	public double evaluate(double val) {
		return Math.sin(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new cos(func), func.differentiate());
	}

	@Override
	public String toString() {
		return "sin(" + func.toString() + ")";
	}

}
