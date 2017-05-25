import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class Test01 {

	public static void main(String[] args) {
		MyComparator mc = new MyComparator();
		Set<Student> stu = new TreeSet<Student>(mc);
		stu.add(new Student("zhao1",16,60));
		stu.add(new Student("zhao2",15,56));
		stu.add(new Student("zhao3",17,90));
		stu.add(new Student("zhao4",12,23));
		stu.add(new Student("zhao4",11,23));
		stu.add(new Student("zhao4",10,23));
		stu.add(new Student("zhao4",17,23));
		Iterator<Student> it = stu.iterator();
		System.out.println("ĞÕÃû£º\t"+"ÄêÁä:\t"+"³É¼¨:\t");
		while(it.hasNext()){
			Student ss = (Student)it.next();
			System.out.println(ss.getName()+"\t"+ss.getAge()+"\t"+ss.getScore()+"\t");
		}
	}

}
