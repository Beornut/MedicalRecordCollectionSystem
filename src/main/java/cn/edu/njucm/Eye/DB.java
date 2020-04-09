package cn.edu.njucm.Eye;

import java.sql.*;

import javax.swing.JOptionPane;

public class DB {
	String patient_name=null;    //姓名
	String sex=null;      	   //性别
	String age=null;			   //年龄
	String time=null;			   //诊次
	String patient_speak=null;   //主述
	String doctor_watch=null;    //诊察
	String disease_name=null;    //病名
	String dialectic=null;       //辩证
	String treatment=null;       //治法
	String prescription=null;    //药方
	

	public DB(String patient_name, String sex, String age, String time, String patient_speak, String doctor_watch,
			String disease_name, String dialectic, String treatment, String prescription) {
		super();
		this.patient_name = patient_name;
		this.sex = sex;
		this.age = age;
		this.time = time;
		this.patient_speak = patient_speak;
		this.doctor_watch = doctor_watch;
		this.disease_name = disease_name;
		this.dialectic = dialectic;
		this.treatment = treatment;
		this.prescription = prescription;
	}


	public void insert() {

		try {
	          Class.forName("com.mysql.jdbc.Driver");
	        }
	        catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "驱动加载失败！");
	          e.printStackTrace();
	        }
	  try {
		  Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?&useSSL=false","root","zz970524");
	       PreparedStatement Statement=connect.prepareStatement("INSERT INTO data VALUES(?,?,?,?,?,?,?,?,?,?)");
	       Statement.setString(1,patient_name);
	       Statement.setString(2,sex);
	       Statement.setString(3,age);
	       Statement.setString(4,time);
	       Statement.setString(5,patient_speak);
	       Statement.setString(6,doctor_watch);
	       Statement.setString(7,disease_name);
	       Statement.setString(8,dialectic);
	       Statement.setString(9,treatment);
	       Statement.setString(10,prescription);
	       Statement.executeUpdate();
	       JOptionPane.showMessageDialog(null, "添加成功！");
	   }
	  catch(SQLException e){
		  JOptionPane.showMessageDialog(null, "添加失败！");
	   }

	}
	
	public static int select(String name, String pwd){
		try {
		      	Class.forName("com.mysql.jdbc.Driver");
		    }catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "加载驱动失败！");
			    e.printStackTrace();
		}
		try {
	    	Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?&useSSL=false","root","zz970524");
	    	Statement stmt = connect.createStatement();
	    	ResultSet rs = stmt.executeQuery("select * from user where name =" + "'" + name + "'");                                                      
	    	if (rs.next()) {
		    	  if(rs.getString("pwd").equals(pwd))
		    		  return rs.getInt("type");
	    	}
	    	connect.close();
		 }catch (Exception e) {
			 JOptionPane.showMessageDialog(null, "查找失败！");
		     e.printStackTrace();
		 }
		return 0;
	}
}
