package com01;

//public class Student implements Comparable  {
public class Student {
	private String name;
	private int age;
	private int id;
	public Student(){
		
	}
	public Student(int id,String name,int age){
		this.setId(id);
		this.name = name;
		this.age = age;
	}
	//toString()
	public String toString(){
		return "" + id + "\t" + name + "\t" + age + "\t";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//¸²Ð´equals
	public boolean equals(Object obj){
		if(obj == this){
			return true;
		}
		if(obj == null){
			return false;
		}
		Student s = (Student)obj;
		if(id == s.getId() || name.equals(s.getName()) && age == s.getAge()){
			return true;
		}
		return false;
	}
	//¸²Ð´HashCode
	public int hashCode(){
		final int a = 31;
		int i = 1;
		i = a * i + (name.equals(null) ? 0:name.hashCode());
		i = a * i + id + age;
		return 0;
	}
	//×ÔÈ»ÅÅÐò£¬¼Ì³ÐCompareble½Ó¿Ú£¬¸²Ð´compareTo()·½·¨
//	public int compareTo(Object obj){
//		if (obj instanceof Student) { 
//			Student stu = (Student) obj; 
//			return stu.id - id; 
//		} 
//		return 0; 
//	}
}
