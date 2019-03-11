package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;


public class MyDao {

	public Connection start()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb?user=root&password=root");
			
		}catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	public ArrayList<EmployeeBean> getAllEmp()
	{
		ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
		try(Connection con=start()) {
	PreparedStatement ps=con.prepareStatement("select * from Employee");
	    ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
	   EmployeeBean e=new EmployeeBean();
		e.setEid(rs.getInt("eid"));
		e.setEname(rs.getString("ename"));
		e.setAddress(rs.getString("address"));
		e.setEmail(rs.getString("email"));
		e.setJoiningdate(rs.getDate("joiningdate"));
        e.setSalary(rs.getDouble("salary"));
			list.add(e);
		}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return list;
		
	}
		
	
	
	
}
