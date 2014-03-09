package partOne;

import java.util.Arrays;
import java.util.Vector;

import Function.Function;
import Function.Parser;

public class FixedPoint extends PartOne {

	public FixedPoint(Function fn, double precision, int maxIterations) {
		super(fn, precision, maxIterations);
		// TODO Auto-generated constructor stub
	}

	public FixedPoint(Function fn) {
		super(fn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param p
	 * @return null when there is no answer , otherwise return table with 2
	 *         columns p , f(p)
	 */
	public double[][] doAlgo(double p) {
		interval = " - ";
		double t1 = System.currentTimeMillis();
		Vector<Double> pointPx = new Vector<Double>();
		Vector<Double> pointPy = new Vector<Double>();
		double fp = function.evaluate(p);
		Function derivative = function.differentiate();

		double fdashp = derivative.evaluate(p);
		if (Math.abs(fdashp) >= 1) {
			setExecutionTime(System.currentTimeMillis() - t1);
			return null;
		}
		int iter = 1;

		pointPx.add(p);
		pointPy.add(fp);

		while (Math.abs(fp - p) > getPrecision() && iter < getMaxIterations()) {
			p = fp;
			fp = function.evaluate(p);
			pointPx.add(p);
			pointPy.add(fp);
			iter++;

		}
		if (Math.abs(fp) > getPrecision()) {
			// need more iteration
			setEnoughIterations(false);
		} else {
			// done
			setEnoughIterations(false);
		}
		setIterations(iter);
		double[][] ans = new double[pointPx.size()][2];
		for (int i = 0; i < pointPx.size(); i++) {
			ans[i][0] = pointPx.get(i);
			ans[i][1] = pointPy.get(i);
		}
		setErrorBound(fp - p);
		answer = ans;
		setExecutionTime(System.currentTimeMillis() - t1);
		return ans;
	}

	public static void main(String[] args) {

		Parser p = new Parser();
		// Function f = p.parse("1+x-0.25*x^3");
		Function f = p.parse("0.25*x^2-x");
		FixedPoint fp = new FixedPoint(f, 0.01, 100);
		fp.doAlgo(1);
		System.out.println(fp.getIterations());
		for (int i = 0; i < fp.getAnswer().length; i++)
			System.out.println(Arrays.toString(fp.getAnswer()[i]));
	}
}
