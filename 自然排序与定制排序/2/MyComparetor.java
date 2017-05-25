package com01;

/**
 * 定制排序：
 *    第一步：自定义一个类或用匿名类实现Comparator接口
 *    第二步：覆写compare()方法，return 正，负，0;
 */
import java.util.Comparator;

public class MyComparetor implements Comparator{
	public int compare(Object o1,Object o2){
		if(o1 instanceof Student && o2 instanceof Student){
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			return s2.getId()-s1.getId();
		}
		return 0;
	}
}
