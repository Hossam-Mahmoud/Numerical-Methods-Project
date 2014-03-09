package partOne;

import java.util.Arrays;
import java.util.Vector;

import Function.Function;
import Function.Parser;

public class FalsePosition extends PartOne {

	public FalsePosition(Function fn, double precision, int maxIterations) {
		super(fn, precision, maxIterations);
		// TODO Auto-generated constructor stub
	}

	public FalsePosition(Function fn) {
		super(fn);
		// TODO Auto-generated constructor stub
	}

	public double[][] doAlgo(double a, double b) {
		interval = a + " " + b;
		double t1 = System.currentTimeMillis();

		Vector<Vector<Double>> g = new Vector<Vector<Double>>();
		Vector<Double> v0 = new Vector<Double>();

		double fa = function.evaluate(a);
		double fb = function.evaluate(b);
		v0.add(fa);
		v0.add(fb);
		if (!haveDifferentSign(fa, fb))// have same signs
		{
			setExecutionTime(System.currentTimeMillis() - t1);
			return null;
		}

		int iter = 1;
		double c = 0;
		c = b - ((fb * (b - a)) / (fb - fa));
		v0.add(c);
		double fc = function.evaluate(c);
		v0.add(fc);
		g.add(v0);
		while (iter < getMaxIterations() && Math.abs(fc) > getPrecision()) {
			Vector<Double> v = new Vector<Double>();
			if (haveDifferentSign(fc, fb))
				a = c;
			else
				b = c;
			c = b - ((fb * (b - a)) / (fb - fa));
			fc = function.evaluate(c);
			iter++;
			v.add(a);
			v.add(b);
			v.add(c);
			v.add(fc);
			g.add(v);
		}
		if (Math.abs(fc) <= getPrecision()) {
			setEnoughIterations(true);
		} else {
			// need more iterations
			setEnoughIterations(false);
		}
		setErrorBound(Math.abs(b - a) / 2);
		setIterations(iter);
		double[][] arr = new double[g.size()][4];
		for (int i = 0; i < g.size(); i++)
			for (int j = 0; j < 4; j++)
				arr[i][j] = g.get(i).get(j);
		answer = arr;
		setExecutionTime(System.currentTimeMillis() - t1);
		return arr;

	}

	public static void main(String[] args) {
		Parser parser = new Parser();
		Function f = parser.parse("(x*sin(x))-1");
		FalsePosition b = new FalsePosition(f, 0.001, 50);
		b.doAlgo(0, 2);
		double[][] completeAnswer = b.getAnswer();
		System.out.println(b.getIterations());
		for (int i = 0; i < completeAnswer.length; i++)
			System.out.println(Arrays.toString(completeAnswer[i]));

	}

}
