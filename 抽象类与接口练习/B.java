abstract class A{
	int a;
	abstract void abs();
	public void abs2(){
		System.out.println("我是抽象类中的普通方法！");
	}
}
class C extends A{
	public void abs(){
		System.out.println("我是继承抽象类的抽象方法！");
	}
}
public class B{
	public static void main(String[] args){
		new C().abs();
		new C().abs2();
	}
}