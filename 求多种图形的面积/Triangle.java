public class Triangle extends AreaPerimeter{
	private double a;//边
	private double b;//边
	private double c;//底边
	private double h;//高
	public Triangle(){
	}
	public Triangle(double a,double b,double c,double h){
		this.a=a;
		this.b=b;
		this.c=c;
		this.h=h;
	}
	//面积
	public double area(){
		return h*max(a,max(b,c))/2;
	}
	//周长
	public double perimeter(){
		return a+b+c;
	}
	//最大值
	public double max(double a,double b){
		return a > b ? a : b;
	}
}