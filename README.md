# taskManager, IS-345 Project code Initial 
package inital_Project;

import java.util.Scanner;

//Code to create a task manager
//By inputing variables and being able to change, edit, or delete when finished

//still working on a switch

public class project_Code {

	public static void main(String[] args) {
	Scanner reader = new Scanner(System.in);
	String response = "";
	
	//Create a task to store in a user input variable
	System.out.print("Enter a task you like to keep track of: ");
	String task = reader.nextLine();
	System.out.println(task + " task created!");
	
	//Loop to continue to add, edit, or delete a task
	while (true) {
        System.out.println("\nWould you like to add, edit, or delete a previous task? \n*(Enter add, edit, delete, or exit to finish)*: ");
        response = reader.nextLine();
        
        //user chooses to add a task
        if (response.equals("add")) {
            System.out.print("Enter a task you'd like to add: ");
            String newTask = reader.nextLine();
            task = newTask; // Replace the previous task with the new one (you can store multiple tasks with a List if needed)
            System.out.println(newTask + " task added!");
        }
        //user chooses to edit the task
        else if (response.equals("edit")) {
            System.out.print("Enter the updated task: ");
            String updatedTask = reader.nextLine();
            task = updatedTask; // updates the task
            System.out.println("Task is updated to: " + updatedTask);
        }
        //user chooses to delete the task
        else if (response.equals("delete")) {
            task = null; // deletes the task
            System.out.println("The previous task is deleted!");
        }
        //user chooses to exit
        else if (response.equals("exit")) {
            System.out.println("You're all set with your tasks! ");
            break; // exits the loop
        }
        // If the input is invalid, by chance
        else {
            System.out.println("Invalid input. Please enter add, edit, delete, or exit please.");
        }
    }
	// add a switch for a count of tasks
	
	}
 }

//citation
// I used w3schools java while loops for help
