package Function;

public class mulOperator extends Function {

	private Function func1, func2;

	public mulOperator(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}

	@Override
	public double evaluate(double val) {
		return func1.evaluate(val) * func2.evaluate(val);
	}

	@Override
	public Function differentiate() {
		Function f1 = func1.differentiate();
		Function f2 = func2.differentiate();

		boolean b1 = check(0, f1), b2 = check(0, f2);
		
		if (b1 && b2) {
			return new constant(0);
		} else if (b1) {
			return new mulOperator(f2, func1);
		} else if (b2) {
			return new mulOperator(f1, func2);
		}
		
		b1 = check(1, f1); b2 = check(1, f2);
		Function term1, term2;
		
		if (b1 && b2) {
			term1 = func1;
			term2 = func2;
		} else if (b1) {
			term1 = new mulOperator(f2, func1);
			term2 = func2;
		} else if (b2) {
			term1 = new mulOperator(f1, func2);
			term2 = func1;
		} else {
			term1 = new mulOperator(f2, func1);
			term2 = new mulOperator(f1, func2);
		}
		
		return new plusOperator(term1, term2);
	}

	@Override
	public String toString() {
		return "(" + func1.toString() + ") * (" + func2.toString() + ")";
	}

	public boolean check(int k, Function f) {
		double e;
		for (int i = -100; i < 100; i++) {
			e = f.evaluate(i);
			if (Math.abs(k - e) > 1e-7)
				return false;
		}
		return true;
	}
}
