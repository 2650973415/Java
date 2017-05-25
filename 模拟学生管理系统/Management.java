import java.util.Scanner;
public class Management{
	//输入
	public static Scanner sc = new Scanner(System.in);
	//学生信息
	static Student[] stus = new Student[100];
	Student stu = new Student();
	//菜单
	int count = 0;
	public void menu(){
		while(true){
			System.out.println("---------------------------------");
			System.out.println("--请选择所需功能（序号）：-------");
			System.out.println("----1.添加-----------------------");
			System.out.println("----2.查询-----------------------");
			System.out.println("----3.删除-----------------------");
			System.out.println("----4.修改-----------------------");
			System.out.print("----5.退出-----------------------\n---------------------------------\n输入：");
			int num = sc.nextInt();
			switch(num){
				case 1://添加
					addDate();
					break;
				case 2://查询
					selectDate();
					break;
				case 3://删除
					deleteDate();
					break;
				case 4://修改
					updateDate();
					break;
				case 5://退出
					System.exit(0);
					break;
				default://输入错误提示
					System.out.print("没有此选项，");
			}
		}
	}
	//增加数据
	static int i=0;
	static void addDate(){
		while(true){
			System.out.println("----------------------------\n学生："+(i+1));
			i++;
			System.out.print("输入姓名：");
			String name = sc.next();
			System.out.print("输入性别：");
			char sex = sc.next().charAt(0);
			System.out.print("输入年龄：");
			int age = sc.nextInt();
			for(int i=0;i<stus.length;i++){
				if(stus[i]==null){
					Student stu2 = new Student(name,sex,age,i+1);
					stus[i]=stu2;
					break;
				}
			}
			//是否继续添加
			System.out.println("添加成功,是否继续添加：\n1.是\n2.否\n其他输入退出添加！");
			int num = sc.nextInt();
			if(num==1){
			
			}else{
				break;
			}
		}
	}
	//添加
	public void add(){
		while(true){
			System.out.println("请选择要修改的列：\n1.编号\n2.姓名\n3.性别\n4.年龄\n5.返回上级菜单");
			int num = sc.nextInt();
			switch(num){
				case 1:
					System.out.print("编号：");
					int id = sc.nextInt();
					stu.sId(id);
					break;
				case 2:
					System.out.print("姓名：");
					String name = sc.next();
					stu.sName(name);
					break;
				case 3:
					System.out.print("性别：");
					char sex = sc.next().charAt(0);	
					stu.sSex(sex); 
					break;
				case 4:
					System.out.print("年龄：");
					int age = sc.nextInt();
					stu.sAge(age);
					break;
				case 5:
					updateDate();
					break;
				default:
					System.out.print("没有此选项，");
			}
			System.out.println("是否修改其他字段(选重复的为最后一次选择的值)：\n1.是\n2.否\n其他输入退出修改！");
			int num2 = sc.nextInt();
			if(num2==1){
				
			}else{
				break;
			}
		}
	}
	//查询数据
	public void selectDate(){
		while(true){
			System.out.println("选择查询类型：\n1.所有数据\n2.条件查询\n3.返回菜单");
			int num = sc.nextInt();
			switch(num){
				case 1:
					System.out.println("| 编号"+" |  姓名 "+" | 性别 "+" | 年龄 |");
					selectDate1(1);
					break;
				case 2:
					System.out.println("");
					selectDate2(1);
					break;
				case 3:
					menu();
					break;
				default:
					System.out.print("没有此选项，请");
			}
			System.out.println("查询成功,是否查询其他结果：\n1.是\n2.否");
			int num2 = sc.nextInt();
			if(num2==1){
			
			}else{
				break;
			}
		}
	}
	//删除数据
	public void deleteDate(){
		while(true){
			System.out.println("选择删除类型：\n1.所有数据\n2.指定条件\n3.返回菜单");
			int num = sc.nextInt();
			switch(num){
				case 1:
					selectDate1(2);
					break;
				case 2:
					add();
					selectDate2(2);
					break;
				case 3:
					menu();
					break;
				default:
					System.out.print("没有此选项，请");
			}
			System.out.println("删除成功,是否继续删除：\n1.是\n2.否");
			int num2 = sc.nextInt();
			if(num2==1){
			
			}else{
				break;
			}
		}
	}
	//修改数据
	public void updateDate(){
		while(true){
			System.out.println("选择修改方式：\n1.所有数据列\n2.指定条件\n3.返回菜单");
			int num = sc.nextInt();
			switch(num){
				case 1:
					add();
					selectDate1(3);
					break;
				case 2:
					selectDate2(3);
					break;
				case 3:
					menu();
					break;
				default:
					System.out.print("没有此选项，请");
			}
			System.out.println("修改成功,是否继续修改：\n1.是\n2.否");
			int num2 = sc.nextInt();
			if(num2==1){
			
			}else{
				break;
			}
		}
	}
	//修改
	public void upDate(int k,Student url){
		if(url.sId()!=0){
			stus[k].sId(url.sId());
		}
		if(url.sName()!=null){
			stus[k].sName(url.sName());
		}
		if(url.sSex()!=' '){
			stus[k].sSex(url.sSex());
		}
		if(url.sAge()!=0){
			stus[k].sAge(url.sAge());
		}
	}
	//查询所有数据
	public void selectDate1(int k){
		//计数器
		count = 0;
		//遍历所有学生
		for(int i=0;i<stus.length;i++){
			if(stus[i]!=null){
				count++;
				switch(k){
					case 1:
						stus[i].shuchu();
						break;
					case 2:
						stus[i]=null;
						break;
					case 3:
						upDate(i,stu);
						break;
				}
			}
		}
	}
	//条件查找
	//k==1;--->查询数据
	//k==2;--->删除数据
	//k==3;--->修改数据
	public void selectDate2(int k){
		System.out.println("  请输入查询条件(\"*\"表示全部)：");
		System.out.print("    姓名为：");
		String name = sc.next();
		System.out.print("    性别为：");
		char sex = sc.next().charAt(0);
		System.out.println("  请选年龄范围：");
		System.out.println("    1.大于等于");
		System.out.println("    2.小于等于");
		System.out.println("    3.等于");
		System.out.println("    4.之间(小-->大)");
		System.out.println("    5.所有");
		int num = sc.nextInt();
		//年龄
		int age=0;
		int age2=0;
		if(num!=5){
			System.out.print("值：");
			age = sc.nextInt();
			if(num==4){
				age2 = sc.nextInt();
				System.out.print("值2：");
			}
		}
		System.out.println("姓名");
		//判断名字
		boolean bName=true;
		//判断性别
		boolean bSex=true;
		//判断年龄
		boolean bAge=true;
		//判断数组元素是否为空
		boolean bStus=true;
		if(k==3){			
			add();
		}
		if(k==1){
			System.out.println("| 编号"+" |  姓名 "+" | 性别 "+" | 年龄 |");
		}
		//计数器
		count = 0;
		//遍历符合条件的学生
		for(int i=0;i<stus.length;i++){
			bStus = (stus[i]!=null);
			if(bStus){
				bName = (stus[i].sName().equals(name)||name.charAt(0)=='*');
				bSex = (stus[i].sSex()==sex||sex=='*');
				switch(num){
					case 1:
						bAge = (stus[i].sAge()>=age);
						break;
					case 2:
						bAge = (stus[i].sAge()<=age);
						break;
					case 3:
						bAge = (stus[i].sAge()==age);
						break;
					case 4:
						bAge = (stus[i].sAge()>=age&&stus[i].sAge()<=age2);
						break;
					case 5:
						bAge=true;
						break;
					default:
						System.out.println("没有此选项，请选择");
				}
			}
			if(bStus&&bName&&bSex&&bAge){
				switch(k){
					case 1://查询
						stus[i].shuchu();
						break;
					case 2://删除
						stus[i]=null;
						break;
					case 3://修改
						upDate(i,stu);
						break;
				}
			}
		}
	}
}