package Function;

public class cos extends Function{

	private Function func;
	
	public cos(Function f) {
		func = f;
	}

	@Override
	public double evaluate(double val) {
		return Math.cos(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new mulOperator(new mulOperator(new constant(-1), new sin(func)), func.differentiate()) ;
	}

	@Override
	public String toString() {
		return "cos("+func.toString()+")";
	}

}
