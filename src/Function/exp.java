package Function;

public class exp extends Function {

	private Function func;

	public exp(Function f) {
		func = f;
	}

	@Override
	public double evaluate(double val) {
		return Math.pow(Math.E, func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(this, func.differentiate());
	}

	@Override
	public String toString() {
		return "e^(" + func.toString() + ")";
	}

}
