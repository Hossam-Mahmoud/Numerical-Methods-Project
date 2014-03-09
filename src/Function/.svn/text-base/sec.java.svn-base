package Function;

public class sec extends Function{

	private Function func;
	public sec(Function f) {
		func = f;
	}
	
	@Override
	public double evaluate(double val) {
		return 1/Math.cos(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new mulOperator(new sec(func), new tan(func)), func.differentiate());
	}

	@Override
	public String toString() {
		return "sec(" + func.toString() + ")";
	}

}
