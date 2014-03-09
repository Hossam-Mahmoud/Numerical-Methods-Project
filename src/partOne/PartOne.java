package partOne;

import Function.Function;

public abstract class PartOne {

	protected Function function;
	private double precision;
	private int maxIterations;
	private boolean enoughIterations;
	private int iterations;
	protected double[][] answer;
	protected double time;
	protected String interval;
	private double errorBound;
	private double NegInf = -1 << 25;

	public PartOne(Function fn) {
		this.function = fn;
		precision = 0.00001;
		maxIterations = 50;
		enoughIterations = false;
		iterations = 0;
		errorBound = NegInf;
	}

	public PartOne(Function fn, double precision, int maxIterations) {
		this.function = fn;
		this.precision = precision;
		this.maxIterations = maxIterations;
		iterations = 0;
		errorBound = NegInf;
	}

	protected boolean haveDifferentSign(double a, double b) {
		return Math.abs(a + b) != Math.abs(a) + Math.abs(b);
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public double getPrecision() {
		return precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public void setMaxIterations(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	public boolean enoughIterations() {
		return enoughIterations;
	}

	public void setEnoughIterations(boolean enoughIterations) {
		this.enoughIterations = enoughIterations;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}

	public double[][] getAnswer() {
		return answer;
	}

	public void setExecutionTime(double newTime) {
		time = newTime;
	}

	public double getExecutionTime() {
		return time;
	}

	public double getErrorBound() {
		return errorBound;
	}

	public void setErrorBound(double input) {
		errorBound = input;
	}

	public String getMessage() {
		// number of iterations, execution time, all
		// iterations, approximate root, precision,
		// and the interval containing the root
		return " Number of Iterations : "
				+ getIterations()
				+ "\n Execution time : "
				+ getExecutionTime()
				+ "\n approximate root "
				+ ((getAnswer() != null) ? (((getAnswer()[0].length == 4) ? ("" + getAnswer()[getIterations() - 1][2])
						: ("" + getAnswer()[getIterations() - 1][1])))
						: ("No Answer"))
				+ "\n Precision "
				+ getPrecision()
				+ "\n Interval "
				+ (interval)
				+ "\n Error Bound "
				+ ((Math.abs(getErrorBound() - NegInf) <= 0.00000000001) ? (" - ")
						: (getErrorBound() + ""));
	}

}
