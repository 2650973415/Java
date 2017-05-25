public class Person{
	private String name;//姓名
	private char sex;//性别
	private int age;//年龄
	Phone phone;//手机
	//构造器
	public Person(){
	
	}
	public Person(String name,char sex,int age,Phone phone){
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.phone=phone;
	}
	public void com(){
		phone.sim.SIMcom();
	}
	//姓名
	public String setName(){
		return this.name;
	}
	public void getName(String name){
		this.name=name;
	}
	//性别
	public char setSex(){
		return this.sex;
	}
	public void getSex(char sex){
		this.sex=sex;
	}
	//年龄
	public int setAge(){
		return this.age;
	}
	public void gerAge(int age){
		this.age=age;
	}
}