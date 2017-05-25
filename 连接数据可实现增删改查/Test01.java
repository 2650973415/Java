package Test0512;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Test01 {

	public static void main(String[] args) {
		Connection con;
		String url = "jdbc:mysql://localhost:3306/zhao";
		String user = "root";
		String password = "1002";
		try {
			//加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//连接数据库
			con = DriverManager.getConnection(url,user,password);
			//创建statement对象，用来执行SQL语句
			Statement statement = con.createStatement();
			String sql = "select * from list";
			//ResultSet类，用来存放获取的结果集
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");  
			System.out.println("-----------------");  
			System.out.println("编号" + "\t" + "姓名");  
			System.out.println("-----------------");
			while(rs.next()){
				System.out.println(rs.getString("id")+"\t"+rs.getString("name"));
			}
			rs.close();
			con.close();
			PreparedStatement psql;
//			ResultSet res;
			//插入
//			psql = con.prepareStatement("insert into list (id,name) " + "values(?,?)");
//			psql.setInt(1, 1);
//			psql.setString(2, "zhaoqinghai");
//			psql.executeUpdate();
			//更新
//			psql = con.prepareStatement("update list set name = ? where id = ?");
//			psql.setString(1, "zhaoqinghai");
//			psql.setInt(2, 2);
//			psql.executeUpdate();
			//删除
//			psql = con.prepareStatement("delete from list where id = ?");
//			psql.setInt(1, 1);
//			psql.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
