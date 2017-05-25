package com01;

import java.util.*;



public class StuFunction {
	public static Scanner sc = new Scanner(System.in);
	public static MyComparetor mc = new MyComparetor();
	public static TreeSet<Student> alStu = new TreeSet<Student>(mc);
	//菜单
	public void menu(){
		
	};
	//注册
	public void enter(){
		alStu.add(new Student(1,"zhao",17));
		alStu.add(new Student(2,"qing",16));
		alStu.add(new Student(3,"hai",18));
		alStu.add(new Student(4,"qing",14));
		alStu.add(new Student(5,"hai",13));
		System.out.print("学号：");
		int sId = Number();
		System.out.print("姓名：");
		String sName = sc.next();
		System.out.print("年龄：");
		int sAge = Number();
		alStu.add(new Student(sId,sName,sAge));
	}
	//打印学生信息
	public void printStu(){
		System.out.println("学号：\t姓名：\t年龄：\t");
		Iterator<Student> i = alStu.iterator();
		while(i.hasNext()){
			Student s = (Student)i.next();
			String str = s.toString();
			System.out.println(str);
		}
	}
	public static int Number(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("请输入整数：");
		}
		return Number();
	}
}
