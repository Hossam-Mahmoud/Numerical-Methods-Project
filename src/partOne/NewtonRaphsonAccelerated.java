package partOne;

import java.util.Arrays;

import Function.Function;
import Function.Parser;

public class NewtonRaphsonAccelerated extends PartOne {

	public NewtonRaphsonAccelerated(Function fn, double precision,
			int maxIterations) {
		super(fn, precision, maxIterations);
		// TODO Auto-generated constructor stub
	}

	public NewtonRaphsonAccelerated(Function fn) {
		super(fn);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param x
	 * @param m
	 *            stands for the order of root for acceleration
	 * @return array of double 2d where, //answer [0] contains the value of xi
	 *         //answer [1] contains the value of fp- function evaluation
	 *         //answer [2] contains the number of iterations
	 */
	public double[][] doAlgo(double x, double m) {
		interval = " - ";

		double t1 = System.currentTimeMillis();

		double ans[][] = new double[2][1];// the array that will be returned
		// answer [0] contains the value of xi
		// answer [1] contains the value of fp- function evaluation
		ans[0] = new double[getMaxIterations()];
		ans[1] = new double[getMaxIterations()];

		Function derivative = function.differentiate();
		double x1 = x;// x1 stands for xi
		// double fp = function.evaluate(x1);
		double fp = 1;
		double fpDash = 0;
		int iter = 0;// number of iterations
		double x2 = 0;
		while (Math.abs(fp) > getPrecision() && iter < getMaxIterations()) {
			fp = function.evaluate(x1);
			fpDash = derivative.evaluate(x1);

			ans[0][iter] = x1;
			ans[1][iter] = fp;

			if (fpDash == 0) {
				// no answer division by zero
				setExecutionTime(System.currentTimeMillis() - t1);
				return null;
			}
			// xi2 stands for xi+1
			x2 = x1 - (m * (fp / fpDash));
			x1 = x2;
			iter++;
		}
		if (fp < getPrecision()) {

			setExecutionTime(System.currentTimeMillis() - t1);
			answer = new double[iter][2];
			for (int i = 0; i < iter; i++)// TODO
			{
				answer[i][0] = ans[0][i];
				answer[i][1] = ans[1][i];
			}
			setErrorBound(x2 - x1);
			setIterations(iter);
			return ans;
		}
		setExecutionTime(System.currentTimeMillis() - t1);
		return null;
	}

	public static void main(String[] args) {
		Parser parser = new Parser();
		Function f = parser.parse("1+x-0.25*x^2");
		NewtonRaphsonAccelerated newton = new NewtonRaphsonAccelerated(f,
				0.0000001, 50);
		newton.doAlgo(1, 0.05);

		double[][] completeAnswer = newton.getAnswer();
		System.out.println(newton.getIterations());
		for (int i = 0; i < completeAnswer.length; i++)
			System.out.println(Arrays.toString(completeAnswer[i]));

		Function f2 = parser.parse("x^(3)-0.165*x^(2)+3.993*10^(-4)");

		System.out.println(f2.evaluate(0.05));
	}

}
