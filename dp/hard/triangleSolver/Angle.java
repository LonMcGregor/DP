package uk.lonm.dp.hard.triangleSolver;

public class Angle {
	private double size;
	public Angle(double size){
		this.size=size;
	}
	public String toString(){
		return "Angle: "+size;
	}
	public double val(){
		return size;
	}
}
