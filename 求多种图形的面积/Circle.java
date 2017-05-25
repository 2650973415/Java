public class Circle{
	final double PI = 3.14;
	private double r;
	public Circle(){
	
	}
	public Circle(double r){
		this.r=r;
	}
	//Ãæ»ý
	public double area(){
		return r*r*PI;
	}
	public double perimeter(){
		return 2*r*PI;
	}
	
}