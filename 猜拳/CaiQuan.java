import java.util.*;
public class CaiQuan{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
		new CaiQuan().caiQuan();
	}
	//猜拳
	public void caiQuan(){
		System.out.println("\n*****猜拳游戏(人机)*****\n");
		System.out.println("    1.石头");
		System.out.println("    2.剪刀");
		System.out.println("    3.布\n");
		int num = 0;
		int computer = (int)(Math.random()*3+1);
		while(true){
			System.out.print("请选择(序号)：");
			num = num();
			if(num == 1 || num == 2 || num == 3){
				break;
			}
			System.out.print("错误，");
		}
		System.out.print("　我："+(num==1?"石头":num==2?"剪刀":num==3?"布":"")+"\n电脑："+(computer==1?"石头":computer==2?"剪刀":computer==3?"布":"")+"\n结果：");
		if(num == computer){
			System.out.println("平局！");
		}else if(computer == 1 && num == 2 || computer == 2 && num == 3 || computer == 3 && num == 1){
			System.out.println("电脑赢了！你个小渣渣！！！");
		}
		else if(num == 1 && computer == 2 || num == 2 && computer == 3 || num == 3 && computer == 11){
			System.out.println("你赢了！！");
		}
		caiQuan();
	}
	/**
	*输入数字
	*/
	public int num(){
		String str = sc.next();
		try{
			return Integer.parseInt(str);
		}catch (Exception e) {
			System.out.println("请输入整数：");
		}
		return num();
	}
}