import java.util.Scanner;
public class ZuoYe{
	public static void main(String[] args){
		ShouJi sj = new ShouJi();
		sj.xinxi();
		Scanner sc = new Scanner(System.in);
		Student stu = new Student();
		Student[] students = new Student[10];
		Student student1 = new Student("ÕÔÇìº£",17,'ÄĞ');
		students[0]=student1;
		Student student2 = new Student();
		students[1]=student2;
		student2.name="ÕÔÇìº£";
		student2.age=19;
		student2.sex='Å®';
		System.out.println(Student.num);
		for(int i=0;i<2;i++){
			students[i].chi();
			students[i].wan();
			students[i].yundong();
		}
		
	}
}