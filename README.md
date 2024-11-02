# taskManager, IS-345 Project code Initial 
package project_Code;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// make sure to open with windowbuilder editor for the GUI functions
//Constructors code
// TaskManager class to handle tasks
class TaskManager {
    private List<String> tasks = new ArrayList<>(); // List to store multiple tasks, arraylist allows for that

    // Method to add a task
    public void addTask(String newTask) {
        tasks.add(newTask); // Add the new task to the list
        System.out.println("Task added: " + newTask);
    }

    // Method to delete a task, used google and w3schools.com/java to help for this section
    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            System.out.println("Task deleted: " + tasks.remove(taskIndex));
        } else {
            System.out.println("Invalid task number.");
        }
    }

    //Method to display the count of tasks
    public void displayTaskCount() {
        int taskCount = tasks.size();
        switch (taskCount) {
            case 0:
                System.out.println("No tasks added.");
                break;
            case 1:
                System.out.println("You have 1 task.");
                break;
            default:
                System.out.println("You have " + taskCount + " tasks.");
                break;
        }
    }

    // to view all tasks 
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\nYour tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}

//Class code
// Main class to run the task manager
public class project_Code {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TaskManager taskManager = new TaskManager(); // Created an instance of taskmanager for the class

        System.out.println("Welcome to the Task Manager!");

        while (true) {
            System.out.println("\nChoose an action: add, delete, view, count, or exit");
            String response = reader.nextLine().toLowerCase(); // instance user input variable
            
// switch used to keep input phase in a proper loop compared to a for loop 
            switch (response) {
                case "add": //prompts to ask what task you would like to add
                    System.out.print("Enter a new task: ");
                    String newTask = reader.nextLine();
                    taskManager.addTask(newTask);
                    break;

                case "delete": //prompts to delete the task you ask for
                    taskManager.viewTasks();
                    System.out.print("Enter the task number you want to delete: ");
                    int taskNumber = reader.nextInt();
                    reader.nextLine(); // Clears a new line
                    taskManager.deleteTask(taskNumber - 1);
                    break;

                case "view": //shows each task you have created in the input phase
                    taskManager.viewTasks();
                    break;

                case "count": //displays the number of tasks you have created
                    taskManager.displayTaskCount();
                    break;

                case "exit": //exits the task manager input phase
                    System.out.println("Exiting the task manager thank you for using this.");
                    reader.close();
                    return;

                default: // If nothing fits within the key words for the prompt then it will be invalid
                    System.out.println("Invalid option. Please try add, delete, view, count, or exit");
            }
        }
    }
    //GUI code, windowbuilder editor
    public class guiTask {
    	
    }
}

//citation
// I used w3schools java while loops for help
