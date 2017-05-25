import java.util.Scanner;
public class Student{
	private int id;
	private String name;
	private char sex;
	private int age;
	//增加数据9
	public Student(){
	
	}
	public Student(String name,char sex,int age,int id){
		this.name=name;
		this.sex=sex;
		this.age=age;
		this.id=id;
	}
	public void shuchu(){
		System.out.println("--------------------------------------------------------");
		System.out.println("|  "+id+"  |\t"+name+"  |  "+sex+"  |  "+age+"  |");
	}
	//name
	public String sName(){
		return name;
	}
	public void sName(String name){
		this.name=name;
	}
	//sex
	public char sSex(){
		return sex;
	}
	public void sSex(char sex){
		this.sex=sex;
	}
	//age
	public int sAge(){
		return age;
	}
	public void sAge(int age){
		this.age=age;
	}
	//id
	public int sId(){
		return id;
	}
	public void sId(int id){
		this.id=id;
	}
}