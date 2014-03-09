package Function;

public class constant extends Function{

	private double num;
	public constant(double n) {
		num = n;
	}
	
	@Override
	public double evaluate(double val) {
		return num;
	}

	@Override
	public Function differentiate() {
		return new constant(0);
	}

	@Override
	public String toString() {
		return num+"";
	}

}