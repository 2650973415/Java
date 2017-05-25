public class Student{
	String name;//姓名
	int age;//年龄
	char sex;//性别
	static int num = 19991002;
	//构造器
	public Student(){
	
	}
	//构造器
	public Student(String name,int age,char sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	//自我介绍
	public void shuchu(){
		System.out.println("我叫"+name+"，性别"+sex+",今年"+age+"岁！");
	}
	//状态
	public void chi(){
		System.out.println(name+"在吃饭！");
	}
	public void wan(){
		System.out.println(name+"在玩游戏！");
	}
	public void yundong(){
		System.out.println(name+"在运动！");
	}
}