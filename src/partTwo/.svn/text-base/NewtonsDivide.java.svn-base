package partTwo;

import java.util.ArrayList;

import Function.Function;
import Function.Parser;

public class NewtonsDivide extends Interpolation {
	
	private ArrayList<double[]> table;
	private String function;
	private int step;
	private ArrayList<String> funSteps;
	
	public NewtonsDivide(double[] pnts, double[]funPnts, int n){
		numOfPoints= n;
		points = pnts;
		funPoints= funPnts;
		table = new ArrayList<double[]>();
		function ="";
		step =0;
		funSteps = new ArrayList<String>();
	}

	@Override
	public String interpolate() {
		table.add(points);
		table.add(funPoints);
		int place =2;
		for(int i=1; i<points.length; i++){
			double[] row = new double[numOfPoints-i];
			for(int j=0; j<row.length; j++){
				row[j] = (table.get(place-1)[j]- table.get(place-1)[j+1])/(table.get(0)[j]-table.get(0)[j+place-1]);
			}
			table.add(row);
			place++;
		}
		for(int i=1; i<table.size(); i++){
			if( i==1 )
				function += table.get(i)[0];
			else if(table.get(i)[0]<0)
				function += "-("+(-1*table.get(i)[0]);
			else
				function += "+("+table.get(i)[0];
			if(i!=1)
			{
				for(int j=0; j<i-1; j++)
				{
					if(table.get(0)[j]<0)
						function += "*(x+"+(-1*table.get(0)[j])+")";
					else
						function += "*(x-"+table.get(0)[j]+")";
				}
				function +=")";
				funSteps.add(function);
			}
		}
		return function;
	}

	@Override
	public String conv(String arg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getNext(){
		String tmp = funSteps.get(step);
		if((step+1)< funSteps.size())
			step++;
		return tmp;
	}
	
	
	public static void main(String[] args) {
		double[] pnt = new double[5];
		double[] fn = new double[5];
		pnt[0]=3.2;pnt[1]=2.7;pnt[2]=1;
		pnt[3]=4.8;pnt[4]=5.6;
		fn[0]=22;fn[1]=17.8;fn[2]=14.2;
		fn[3]=38.3;fn[4]=51.7;
		NewtonsDivide one = new NewtonsDivide(pnt, fn, 5);
		String tmp = one.interpolate();
		System.out.println(tmp);
		System.out.println(one.getNext());
		System.out.println(one.getNext());
		System.out.println(one.getNext());
		/*Parser prs = new Parser();
		Function f = prs.parse(tmp);
		System.out.println(f.toString());*/
		
	}
}
