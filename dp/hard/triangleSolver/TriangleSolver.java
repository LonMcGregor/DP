package uk.lonm.dp.hard.triangleSolver;

/*/r/DailyProgrammer Hard Challenge #160 */

import java.util.Scanner;

public class TriangleSolver {
	private static int totalInputs;
	private boolean enoughSides;
	private Triangle me;
	private static String [] inputs;

	public TriangleSolver(){}
	
	public void Start(){
		me = new Triangle();
		getInput();
		me.doCalculations();
		me.printTriangle();	
	}
	
	private void getInput(){

		//initial prompt
		Scanner s = new Scanner(System.in);
		System.out.println("How many inputs do you want to give?");
		boolean ready = true;
		
		//make sure it's between 6, 3 and is a number
		while(ready){
			totalInputs = 0;
			try {
				totalInputs = Integer.parseInt(s.nextLine());
			} catch(Exception e){			
				System.err.println("Make sure you enter a number betwen 3-6...");
			}
			if(totalInputs>6||totalInputs<3)
				System.err.println("Make sure you enter a number betwen 3-6...");
			else
				ready=false;
		}
		
		//get the inputs
		System.out.println("Enter your " + totalInputs + " inputs:");
		inputs = new String [totalInputs];
		for (int i = 0; i < totalInputs; i++)
			inputs[i] = s.nextLine();
		s.close();
	
		determineInputs();
		
		if (!enoughSides){
			System.out.println("At least 1 input needs to be a side.");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		TriangleSolver ts = new TriangleSolver();
		ts.Start();
	}

	private void determineInputs() {
		for(String s : inputs){
			String ids = s.substring(0,1);
			if(ids.equals("a")){
				me.addSide("a", extractData(s));
				enoughSides = true;
			} else if(ids.equals("b")){
				me.addSide("b", extractData(s));
				enoughSides = true;
			} else if(ids.equals("c")){
				me.addSide("c", extractData(s));
				enoughSides = true;
			} else if(ids.equals("A")){
				me.addAngle("A", extractData(s));
			} else if(ids.equals("B")){
				me.addAngle("B", extractData(s));
			} else if(ids.equals("C")){
				me.addAngle("C", extractData(s));
			}
		}
	}
	
	private static double extractData(String s){
		try {
			return Double.parseDouble(s.substring(2));
		} catch (Exception e){
			throw new Error("Error parsing double: " +s );
		}
	}
}
