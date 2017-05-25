package Test0427;

public class DanLi02 {
	//ÀÁººÊ½µ¥Àý
	private static DanLi02 dl;
	private DanLi02(){}
	public static DanLi02 getDanLi(){
		if(dl==null){
			dl = new DanLi02();
		}
		return dl;
	}

}
