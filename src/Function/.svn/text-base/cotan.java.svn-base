package Function;

public class cotan extends Function{

	private Function func;
	public cotan(Function f) {
		func = f;
	}
	
	@Override
	public double evaluate(double val) {
		return 1/Math.tan(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new constant(-1), new mulOperator(new powOperator(new cosec(func), new constant(2)), func.differentiate()));
	}

	@Override
	public String toString() {
		return "cotan(" + func.toString() + ")";
	}

}
