package partTwo;

import java.util.ArrayList;

import Function.Function;
import Function.Parser;

public class Lagrange extends Interpolation{
	private String function;
	private int step;
	public Lagrange(double[] newPoints,double[] funOfPnts, int num){
		numOfPoints = num;
		points = newPoints;
		funPoints = funOfPnts;
		function = "";
		step = 2;
		
	}
	
	@Override
	public String interpolate() 
	{
		double coff=1;
		String tmp="";
		for(int i=0 ; i<points.length; i++){
			for(int j=0; j<points.length; j++)
			{
				if(i != j)
				{
					coff *=(points[i]-points[j]);
					if(points[j]<0)
						tmp += "*(x+"+(-1*points[j])+")";
					else
						tmp += "*(x-"+points[j]+")";
				}
			}
			coff = funPoints[i]/coff;
			if(i==0)
				tmp ="("+coff+tmp+")";
			else if(coff<0)
				tmp = "-("+(-1*coff)+tmp+")";
			else
				tmp ="+("+coff+tmp+")";
			function +=tmp;
			tmp="";
			coff=1;
		}
		return function;
	}
	
	private String getStep(int iterations){
		double coff=1;
		String tmp="";
		String func ="";
		for(int i=0 ; i<iterations; i++)
		{
			for(int j=0; j<iterations; j++)
			{
				if(i != j)
				{
					coff *=(points[i]-points[j]);
					if(points[j]<0)
						tmp += "*(x+"+(-1*points[j])+")";
					else
						tmp += "*(x-"+points[j]+")";
				}
			}
			coff = funPoints[i]/coff;
			if(i==0)
				tmp ="("+coff+tmp+")";
			else if(coff<0)
				tmp = "-("+(-1*coff)+tmp+")";
			else
				tmp ="+("+coff+tmp+")";
			func +=tmp;
			tmp="";
			coff=1;
		}
		return func;
	}

	@Override
	public String conv(String arg) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getNext(){
		String tmp = getStep(step);
		if((step+1)<= points.length)
			step++;
		return tmp;
	}
	
	public static void main(String[] args) {
		double[] pnts = new double[4];
		double[] func = new double[4];
		pnts[0] =-3; pnts[1]=1; pnts[2]=2;pnts[3]=5;
		func[0]=-23;func[1]=-11;
		func[2]=-23;func[3]=1;
		Lagrange tmp = new Lagrange(pnts, func, 3);
		String temp = tmp.interpolate();
		System.out.println(temp);
		
	
		
	}
	
}
