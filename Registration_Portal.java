package JDBC;
import java.util.*;
public class Registration_Portal {
	static Registration fd=new Registration();
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int ch=0;
		while(ch!=6) {
			System.out.println("Enter: \n 1 to Register \n 2 to Login \n 3 to reset password \n 4 to show users and their details \n 5 to delete user ");
			ch = in.nextInt();
		switch(ch)
		{
		case 1:
			  fd.addData(); //register user
			  break;
		case 2:
			fd.loginData();
			break;
		case 3:
			fd.updateData(); //forgot password
			break;
		case 4:
			fd.getData(); //show users
			break;
		case 5:
			fd.deleteData(); //delete user
			break;
		default:
			System.out.println("Wrong Choice!!");
		}

	}
	}

}
