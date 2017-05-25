
import java.util.Comparator;

public class MyComparator implements Comparator<Object>{
	public int compare(Object o1, Object o2) {  
        // 在compare方法中，传入自定义对象x，并指定是由x的哪一个具体属性做判断来排序  
        //if(o1 instanceof Fruit && o2 instanceof Fruit)  
        Student f1 = (Student) o1;  
        Student f2 = (Student) o2;  
        if(f1.getScore()<f2.getScore()){
        	return 1;
        }
        if(f1.getScore() == f2.getScore()){
        	if(f1.getAge() < f2.getAge()){
        		return 1;
        	}
        	if(f1.getAge() == f2.getAge()){
        		return 0;
        	}
        	return -1;
        }
        return -1; 
    }
}
