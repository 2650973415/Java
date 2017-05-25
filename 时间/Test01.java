import java.text.*;
import java.util.*;

public class Test01 {
	public static void main(String[] args){
		Date date = new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		SimpleDateFormat sdf2 = new SimpleDateFormat("H时m分s秒");
		System.out.println(sdf2.format(date.getTime()));
		//格式化
		//Date date2 = getDate(strDate);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 00时00分00秒");
		//时间转换成字符串
		String strDate = sdf.format(date);
		System.out.println("当前日期为："+strDate);
		String strDate2 = "12时10分30秒";
		try {
			//字符串转换成时间
			Date date2 = sdf2.parse(strDate2);
			System.out.println(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println("今年是"+year);
		int a = Integer.parseInt("21");
		System.out.println(a);
	}
}


