package Function;

public class Main {
	public static void main(String[] args) {
		
		Parser parser = new Parser();
		
//		String[] exp = { "x*sin(x)", "3-x-3", "x+3","(0.5*((x)^2))-1.5*x", "x^(3)-0.165*x^(2)+3.993*10^(-4)","cotan(x)","tan(x)", "sec(x)", "cosec(x)",
//						"x", "sin(x)", "cos(x)", "ln(x)",
//						"x/5", "x/(x+1)", "x^2/x^3",
//						"(x-1)^2", "(x-1)*(x+1)", "-(x+5)",
//						"sin((x-1)^2)", "cos(sin(x))", "cos(x)/sin(x)",
//						"ln(sin(x))", "-ln(x^2)", "ln(-1)",
//						"3-x-3", "3-sin(x)-2"};
//		
//		System.out.println("------- Test Parsing -------\n");
//		for (int i = 0; i < exp.length; i++) {
//			Function f = parser.parse(exp[i]);
//			System.out.println("PARSE TEST " + (i + 1));
//			System.out.println("----------");
//			System.out.println("input : " + exp[i]);
//			System.out.println("Parsing : " + f.toString());
//			System.out.println("derivative : " + f.differentiate().toString());
//			System.out.println();
//		}
		
		String func = "x*sin(x)";
		Function f = parser.parse(func);
		for(int i = 1; i < 100; i++)
		{
			System.out.println(i);
			f = f.differentiate();
//			System.out.println(f.toString());
		}
		System.out.println(f.toString());
		System.out.println("\nTests Completed Successfully :D :D");
	}
}