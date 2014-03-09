package Function;

public class divOperator extends Function{

	private Function func1, func2;
	public divOperator(Function f1, Function f2) {
		func1 = f1;
		func2 = f2;
	}

	@Override
	public double evaluate(double val) {
		return func1.evaluate(val)/func2.evaluate(val);
	}

	@Override
	public Function differentiate() {
		return 	new divOperator(new minusOperator(new mulOperator(func1.differentiate(), func2) , new mulOperator(func2.differentiate(), func1)), new powOperator(func2, new constant(2)));
	}

	@Override
	public String toString() {
		return "(" + func1.toString() + "/" + func2.toString() + ")";
	}

}
