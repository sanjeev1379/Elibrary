package com.javatpoint.dao;

import java.sql.*;

//import g.GetCon;

public class DB {
public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "system");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}

public static int getPrimaryKey(){
	int nextvalue=0;
	Connection con=DB.getCon();
	PreparedStatement ps2;
	try {
	
	ps2=con.prepareStatement("select MYSEQ1.NEXTVAL from DUAL");
	
	ResultSet rs=ps2.executeQuery();
	rs.next();
	nextvalue=rs.getInt(1);

	
	
} catch (SQLException e) {
		
		e.printStackTrace();
	}
return nextvalue;

}

}
