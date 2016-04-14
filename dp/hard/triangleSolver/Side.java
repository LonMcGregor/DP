package uk.lonm.dp.hard.triangleSolver;

public class Side {
	private double length;
	public Side(double length){
		this.length=length;
	}
	public String toString(){
		return "Side: "+length;
	}
	public double val(){
		return length;
	}
}
