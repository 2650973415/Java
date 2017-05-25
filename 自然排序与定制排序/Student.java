package com.dazhi;

//public class Student implements Comparable<Object>{
public class Student{
	private String name;
	private int age;
	private int score;
	public Student(){}
	public Student(String name,int age,int score){
		this.name=name;
		this.age=age;
		this.score=score;
	}
	//getter and setter
	/**
	 *ĞÕÃû
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ÄêÁä
	 * @return
	 */
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * ³É¼¨
	 * @return
	 */
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
//	@Override
	public int compareTo(Object o) {
		Student student = (Student)o;
        if(score>student.score){
        	return 1;
        }
        if(score == student.score){
        	if(age > student.age){
        		return 1;
        	}
        	if(age == student.age){
        		return 0;
        	}
        	return -1;
        }
        return -1; 
	}
}
