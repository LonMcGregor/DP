package dp.hard.triangleSolver;


@SuppressWarnings("unused")
public class Triangle {
	private Side a,b,c;
	private Angle A,B,C;
	private int sides, angles;
	
	
	//Initialise
	public Triangle(){}
	
	
	//Add values
	public void addSide(String s, double x){
		if(s.equals("a"))
			a = new Side(x);
		else if (s.equals("b"))
			b = new Side(x);
		else if (s.equals("c"))
			c = new Side(x);
		else
			throw new SideException(s);
		howManySides();
	}
	public void addAngle(String s, double x){
		if(s.equals("A"))
			A = new Angle(x);
		else if (s.equals("B"))
			B = new Angle(x);
		else if (s.equals("C"))
			C = new Angle(x);
		else
			throw new AngleException(s);
		howManyAngles();
	}
	//Update Counters
	private void howManyAngles(){
		int i = 0;
		if (A!=null)
			i++;
		if (B!=null)
			i++;
		if (C!=null)
			i++;
		angles = i;
	}
	private void howManySides(){
		int i = 0;
		if (a!=null)
			i++;
		if (b!=null)
			i++;
		if (c!=null)
			i++;
		sides = i;
	}
	
	
	//Output final calculation
	public void printTriangle() {
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("c: " + c);
		System.out.println("A: " + A);
		System.out.println("B: " + B);
		System.out.println("C: " + C);
	}
	
	//Calculation Templates
	public void sum180(){
		if (angles != 2)
			System.out.println("Not correct angles for calculation sum180(): "+angles+", needs to be 2");
		if(A==null){
			A = new Angle(180-B.val()-C.val());
		}else if (B==null){
			B = new Angle(180-A.val()-C.val());
		}else if (C==null){
			C = new Angle(180-A.val()-B.val());
		}
	}
	private double sinRuleAngle(double side1, double side2, double ang2 ){
		return Math.toDegrees(Math.asin(((side1*Math.sin(ang2))/side2)));
	}
	private double sinRuleSide(double ang1, double side2, double ang2 ){
		return ((Math.sin(ang1)*side2)/Math.sin(ang2));
	}
	
	
	//Start Calculations
	public void doCalculations(){
		sum180();
		calculateSide(a, "a");
		calculateSide(b, "b");
		calculateSide(c, "c");
		calculateAngle(A);
		calculateAngle(B);
		calculateAngle(C);
		
		/*
		 * Call the sum180() method
		 * for a side,
		 * 		if it has an opposite angle & an adjacent side also with opposite angle		!there must be at least one side in the triangle, but it may not have an opposite angle.
		 * 			use sine rule															!OpAng, 1 side with OpAng
		 * 		if it has two other sides & an opposite angle								
		 * 			use cos rule															!2 sides, OpAng
		 * 
		 * 
		 */
	}
	private void calculateSide(Side x, String s){
		if (x==null){
			Angle opA = opAng(s);
			if(opA!=null&&a!=null&&A!=null){
				double val = sinRuleSide(opA.val(),a.val(),A.val());//perform sine rule with
			}
		} else {
			System.out.println("Complete: " + x);
		}
	}
	private void calculateAngle(Angle x){
		if (x==null){
			
		} else {
			System.out.println("Complete: " + x);
		}
	}
	
	
	//Geometry Functions
	private Angle opAng(String side){
		if(side.equals("a"))
			return A;
		else if (side.equals("b"))
			return B;
		else if (side.equals("c"))
			return C;
		else
			throw new AngleException(side);
	}
}


//Errors
class AngleException extends RuntimeException{
	private static final long serialVersionUID = 1504611289179171869L;
	public AngleException(Object s){
		super("Invalid angle chosen: " + s + ", use A, B or C");
	}
}
class SideException extends RuntimeException{
	private static final long serialVersionUID = 5738679114439591642L;
	public SideException(Object s){
		super("Invalid side chosen: " + s + ", use a, b or c");
	}
}
