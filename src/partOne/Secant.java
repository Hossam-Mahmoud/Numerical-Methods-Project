package partOne;

import java.util.Arrays;

import Function.Function;
import Function.Parser;

public class Secant extends PartOne {

	public Secant(Function fn, double precision, int maxIterations) {
		super(fn, precision, maxIterations);
		// TODO Auto-generated constructor stub
	}

	public Secant(Function fn) {
		super(fn);
		// TODO Auto-generated constructor stub
	}

	public double[][] doAlgo(double x, double y) {
		interval = x + " " + y;

		double t1 = System.currentTimeMillis();
		double ans[][] = new double[2][1];// the array that will be returned
		// answer [0] contains the value of xi
		// answer [1] contains the value of xi
		// answer [2] contains the value of fp- function evaluation
		// answer [3] contains the number of iterations
		ans[0] = new double[getMaxIterations()];
		ans[1] = new double[getMaxIterations()];
		// answer[2] = new double[1];

		double x1 = x;// x1 stands for xi
		double x2 = y;// x2 stands for xi-1
		double fp = function.evaluate(x1);
		double fp2;
		int iter = 0;// number of iterations
		while (Math.abs(fp) > getPrecision() && iter < getMaxIterations()) {

			fp = function.evaluate(x1);
			fp2 = function.evaluate(x2);
			ans[0][iter] = x1;
			// ans[1][iter] = x2;
			ans[1][iter] = fp;

			// x3 stands for xi+1
			double x3 = x1 - (fp * (x1 - x2)) / (fp - fp2);
			x2 = x1;
			x1 = x3;
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
			setErrorBound(x1 - x2);
			setIterations(iter);
			return ans;
		}
		setExecutionTime(System.currentTimeMillis() - t1);
		return null;

	}

	public static void main(String[] args) {
		Parser parser = new Parser();
		Function f = parser.parse("x^(3)-3*x+2");
		Secant newton = new Secant(f, 0.0000001, 50);
		newton.doAlgo(-2.6, -2.4);

		double[][] completeAnswer = newton.getAnswer();
		System.out.println(newton.getIterations());
		for (int i = 0; i < completeAnswer.length; i++)
			System.out.println(Arrays.toString(completeAnswer[i]));

		Function f2 = parser.parse("x^(3)-0.165*x^(2)+3.993*10^(-4)");

		System.out.println(f2.evaluate(0.05));
	}

}
