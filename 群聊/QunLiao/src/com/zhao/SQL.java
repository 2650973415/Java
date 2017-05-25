package com.zhao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextArea;

public class SQL {
	//查询添加到jTextArea
	public void select(JTextArea area){
		//接收历史消息
		Connection con = MysqlUtil.getInstace();
		//创建statement对象，用来执行SQL语句
		Statement statement;
		try {
			statement = con.createStatement();
			String sql = "select name,Datetime,message from qunliao";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				area.setText(area.getText()+rs.getString("name")+"  "+rs.getString("Datetime")+"：\n  "+rs.getString("message")+"\n");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	//插入数据
	public void insert(String name,String message){
		//连接Mysql
		Connection con = MysqlUtil.getInstace();
		PreparedStatement psql;
		//插入
		try {
			psql = con.prepareStatement("insert into qunliao (name,Datetime,message) " + "values(?,?,?)");
			psql.setString(1, name);
			//当前时间
			Date d = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d H:m:s");
			String date = dateFormat.format(d);
			psql.setString(2, date);
			psql.setString(3, message);
			psql.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
