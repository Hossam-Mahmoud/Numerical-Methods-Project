package Function;

public class ln extends Function{

	private Function func;
	public ln(Function f1) {
		func = f1;
	}
	
	@Override
	public double evaluate(double val) {
		return Math.log(func.evaluate(val));
	}

	@Override
	public Function differentiate() {
		return new divOperator(func.differentiate(), func);
	}

	@Override
	public String toString() {
		return "ln(" + func.toString() + ")";
	}

}
