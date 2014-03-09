package Function;

public class cosec extends Function{

	private Function func;
	public cosec(Function f) {
		func = f;
	}
	
	@Override
	public double evaluate(double val) {
		return 1/Math.sin(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new constant(-1), new mulOperator(new mulOperator(new cosec(func), new cotan(func)), func.differentiate()));
	}

	@Override
	public String toString() {
		return "cosec(" + func.toString() + ")";
	}

}
