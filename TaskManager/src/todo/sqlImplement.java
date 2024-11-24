package todo;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;
public class sqlImplement {
//code to implement sql database into taskManager using WampServer
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		Class.forName("com.mysql.jdc.Driver"); //loads the java database connector driver class
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/filler","root",""); //filler is a place holder, change when table is created
		

	}

}
