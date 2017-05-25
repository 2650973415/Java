import java.util.Scanner;
public class Main{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		//三角形
		//Triangle tri = new Triangle();
		menu();
	}
	//菜单
	static void menu(){
		System.out.println("-----------------------------");
		System.out.println("请选择形状：");
		System.out.println("1.三角形");
		System.out.println("2.圆形");
		int num = sc.nextInt();
		switch(num){
			case 1:
				exportTriangle();
				break;
			case 2:
				exportCircle();
				break;
			default:
				System.out.println("没有此选项！");
				menu();
		}

	} 
	//输入边长及高，输出面积与周长----三角形
	static void exportTriangle(){
		System.out.println("请输入：");
		System.out.print("边1：");
		double a=sc.nextDouble();
		System.out.print("边2：");
		double b=sc.nextDouble();
		System.out.print("边3：");
		double c=sc.nextDouble();
		System.out.print("高：");
		double h=sc.nextDouble();
		if(a+b<=c||a+c<=b||b+c<=a&&a>0&&b>0&&c>0&&h>0){
			System.out.println("不能构成三角形！");
			exportTriangle();
		}else{
			Triangle tri = new Triangle(a,b,c,h);
			System.out.println("三角形面积："+tri.area());
			System.out.println("三角形周长："+tri.perimeter());
		}
	}
	//输入半径，输出面积与周长----圆
	static void exportCircle(){
		System.out.println("请输入正数：");
		System.out.print("半径：");
		double r=sc.nextDouble();
		if(r>0){
			System.out.println("不能构成圆形！");
			exportCircle();
		}
		Circle cir = new Circle(r);
		System.out.println("圆形面积："+cir.area());
		System.out.println("圆形周长："+cir.perimeter());
	}
}