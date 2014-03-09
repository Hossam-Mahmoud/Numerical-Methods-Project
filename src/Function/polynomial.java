package Function;

public class polynomial extends Function {

	private int exp;
	private double coff;

	public polynomial(double coff, int exp) {
		this.coff = coff;
		this.exp = exp;
	}

	@Override
	public double evaluate(double val) {
		return coff * Math.pow(val, exp);
	}

	@Override
	public Function differentiate() {
		if(exp-1 == 0)
			return new constant(coff*exp);
		
		return new polynomial(coff * exp, exp - 1);
	}

	@Override
	public String toString() {
		return coff + "x^" + exp;
	}

}
