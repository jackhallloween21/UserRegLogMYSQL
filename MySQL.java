package JDBC;
	import java.sql.*;
	import java.util.Scanner;
	class Registration
	{
		Scanner sc;
		Connection cn=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String uname=null;
		String pass=null;
		String pno;
		String email =null;
		String fname=null;
		String select_sql="select * from register"; //register table show data
		String insert_sql="insert into register values(?,?,?,?,?)"; //inserting user name, password, Full name, Phone and email
		String delete_sql="delete from register where uname=?"; // delete user
		String update_sql="update register set password=? where uname=?"; //change password
		String login_sql="select fname, email, pno, uname from register where uname=? and password=?";
		public void getData()
		{
			try
			{
			  
	         Connection_Factory con=new Connection_Factory();
	         cn=con.getConn();
	         st=cn.createStatement();//statement created
			  rs=st.executeQuery(select_sql);
			  while(rs.next())
			  {
				  System.out.println(" Username :"+rs.getString(1)+" \n Password:"+rs.getString(2)+" \n Full Name:"+rs.getString(3)+" \n Phone No:"+rs.getString(4)+" \n Email:"+rs.getString(5));
				  System.out.println();
				  
			  }
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		public void addData()
		{
			sc=new Scanner(System.in);
			System.out.println("Enter Username:");
			uname=sc.next();
			System.out.println("Enter Full name:");
			fname=sc.next();
			System.out.println("Set Password:");
			pass=sc.next();
			System.out.println("Enter Email:");
			email=sc.next();
			System.out.println("Phone number:");
			pno=sc.next();
			try
			{
				Connection_Factory con=new Connection_Factory();
		         cn=con.getConn();
		      ps=cn.prepareStatement(insert_sql);
			  ps.setString(1, uname);
			  ps.setString(2, pass);
			  ps.setString(3, fname);
			  ps.setString(4, pno);
			  ps.setString(5, email);
			  ps.executeUpdate();
			  System.out.println("User Registered Successfully!");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		}
		public void updateData()
		{
			sc=new Scanner(System.in);
			System.out.println("Enter Username:");
			uname=sc.next();
			System.out.println("Enter new Password");
			pass=sc.next();
			try
			{
				Connection_Factory con=new Connection_Factory();
		         cn=con.getConn();
			  ps=cn.prepareStatement(update_sql);
			  ps.setString(2, uname); // for checking user name number corresponding to ? in the sql query
			  ps.setString(1, pass);
			  ps.executeUpdate();
			  System.out.println("Password Reset Successfully!");
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		}
		public void loginData()
		{
			sc=new Scanner(System.in);
			System.out.println("Enter Username to login:");
			uname=sc.next();
			System.out.println("Enter new Password");
			pass=sc.next();
			try
			{
				Connection_Factory con=new Connection_Factory();
		         cn=con.getConn();
			  ps=cn.prepareStatement(login_sql);
			  ps.setString(1, uname);
			  ps.setString(2, pass);
			  ResultSet rs = ps.executeQuery();
			  System.out.println("User logged in Successfully!");
			  while(rs.next())
			  {
				  System.out.println(" Username :"+rs.getString(4)+"\n Full Name:"+rs.getString(1)+" \n Phone No:"+rs.getString(3)+" \n Email:"+rs.getString(2));
				  System.out.println();
			 }
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		public void deleteData()
		{
			sc=new Scanner(System.in);
			System.out.println("Enter Username to Delete:");
			uname=sc.next();
			try
			{
				Connection_Factory con=new Connection_Factory();
		         cn=con.getConn();
			  ps=cn.prepareStatement(delete_sql);
			  ps.setString(1, uname);
			  ps.executeUpdate();
			  System.out.println("User Deleted Successfully!");
			}
			
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	public class MySQL {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	 //Registration fd=new Registration(); // debugging before creating menu class
	 //fd.addData();
	 //fd.deleteData();
	 //fd.getData();
	 //fd.loginData();
	  //fd.updateData();
	  //fd.getData();
		}

	}
