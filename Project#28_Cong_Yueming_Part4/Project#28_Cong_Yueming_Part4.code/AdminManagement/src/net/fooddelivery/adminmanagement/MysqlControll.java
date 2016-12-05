package net.fooddelivery.adminmanagement;


import java.sql.*;
public class MysqlControll {
	//load driver from file 
	static{
	try{
	String driverName =
	"oracle.jdbc.driver.OracleDriver";
	Class.forName(driverName);
	}catch(Exception e){
	e.printStackTrace();
	}
	}
	//establish connection
	public static Connection getConnection(){
	Connection con = null;
	try{
	String url = 
	"jdbc:oracle:thin:@192.168.0.26:1521:tarena";
	String usr = " ";
	String pwd = " ";
	con = DriverManager.getConnection(
	url,usr,pwd);
	}catch(Exception e){
	e.printStackTrace();
	}
	return con;
	}

	//close resultSet,statement and connection
	public static void close(ResultSet rs,Statement stmt,Connection con){
	try{
	if(rs!=null) rs.close();
	}catch(Exception ex){
	ex.printStackTrace();
	}
	try{
	if(stmt!=null) stmt.close();
	}catch(Exception ex){
	ex.printStackTrace();
	}
	try{
	if(con!=null) con.close();
	}catch(Exception ex){
	ex.printStackTrace();
	}
	}

}
