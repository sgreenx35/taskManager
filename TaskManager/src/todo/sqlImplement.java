
package sqlTrial1;

//import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

public class TaskManagerConnect {

	public static void main(String[] args) throws Exception{
		
		Scanner scanner=new Scanner(System.in);
		//Main Parts for Connection Code
				Class.forName("com.mysql.jdbc.Driver"); //loads the java database connector driver class
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/taskmanager","root",""); //tells the connection where its connecting to, user:root, no password
				//Libraries is the database used
				
				PreparedStatement statement = con.prepareStatement("SELECT * FROM tasks "); //selects all from table 'books' like a mySQL statement 
				
				ResultSet result=statement.executeQuery(); //takes everything from books and storing it || appending
				while(result.next()) {
					System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)); //getString() are columns, 
				}
				
				//creates new table tasks
				Statement  stmt = null;
				String sql;
				
				
				//gather user input for author table
				System.out.println("Enter the number of the task: ");
				int taskID= scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the title of your task: ");
				String Task_Name=scanner.nextLine();
				System.out.println("Has this task been completed?: (Yes/No)");
				String Task_Completion = scanner.nextLine();
				
				//formats input into author table
				
				//need to be spelled the same way the columns are spelled 
				sql="INSERT INTO tasks (taskID, Task_Name,Task_Completion)VALUES (?,?,?) "; //wildcards for authorID, firstName, and lastName
				statement=con.prepareStatement(sql); //prepares string 
				statement.setInt(1, taskID);
				statement.setString(2, Task_Name);
				statement.setString(3,  Task_Completion);
				statement.executeUpdate();
				
				statement = con.prepareStatement("SELECT * FROM tasks"); //selects all from table 'books' like a mySQL statement 
				
				result=statement.executeQuery(); //takes everything from books and storing it || appending
				System.out.println("\ntaskID\tTask_Name\tTask_Completion");
				while(result.next()) {
					System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)); //getString() are columns, 
				}
				
				
			}

		}
