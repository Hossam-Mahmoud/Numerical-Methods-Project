package partOne;

import java.util.Arrays;

import Function.Function;
import Function.Parser;

public class NewtonRaphson extends PartOne {

	public NewtonRaphson(Function fn, double precision, int maxIterations) {
		super(fn, precision, maxIterations);
		// TODO Auto-generated constructor stub
	}

	public NewtonRaphson(Function fn) {
		super(fn);
		// TODO Auto-generated constructor stub
	}

	public double[][] doAlgo(double x) {

		interval = " - ";
		double t1 = System.currentTimeMillis();

		double[][] ans = new double[2][1];// the array that will be returned
		// answer [0] contains the value of xi
		// answer [1] contains the value of fp- function evaluation
		// answer [2] contains the number of iterations
		ans[0] = new double[getMaxIterations()];
		ans[1] = new double[getMaxIterations()];

		Function derivative = function.differentiate();
		double x1 = x;// x1 stands for xi
		double fp = 1;// TODO any number bigger than one to pass the first
		// while loop
		// answer[0][0]=x1;
		// answer[1][0]=fp;
		double fpDash = 0;
		int iter = 0;// number of iterations
		double x2 = 0;
		// TODO
		while (Math.abs(fp) > getPrecision() && iter < getMaxIterations()) {
			fp = function.evaluate(x1);// TODO
			fpDash = derivative.evaluate(x1);
			ans[0][iter] = x1;
			ans[1][iter] = fp;
			if (fpDash == 0) {
				{
					// no answer division by zero
					setExecutionTime(System.currentTimeMillis() - t1);
					return null;
				}
			}
			// xi2 stands for xi+1
			x2 = x1 - (fp / fpDash);
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
		Function f = parser.parse("x^(3)-0.165*x^(2)+3.993*10^(-4)");
		NewtonRaphson newton = new NewtonRaphson(f, 0.00000001, 50);
		newton.doAlgo(.05);
		double[][] completeAnswer = newton.getAnswer();
		System.out.println(newton.getIterations());
		for (int i = 0; i < completeAnswer.length; i++)
			System.out.println(Arrays.toString(completeAnswer[i]));

		Function f2 = parser.parse("x^(3)-0.165*x^(2)+3.993*10^(-4)");

//		System.out.println(f2.evaluate(0.05));
	}

}
