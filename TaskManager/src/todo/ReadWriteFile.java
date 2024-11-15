package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//creates the file for users to write task for security purposes
	

	public class ReadWriteFile {
	    
	    private String filename;

	    // Constructor to initialize the filename
	    public ReadWriteFile(String filename) {
	        this.filename = filename;
	    }

	    // Method to write content to the file
	    public void writeToFile(String content) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
	            writer.write(content);
	            writer.newLine();
	            System.out.println("Content written to " + filename);
	        } catch (IOException e) {
	            System.out.println("An error occurred while writing to the file: " + e.getMessage());
	        }
	    }

	    // Method to read content from the file
	    public void readFromFile() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
	            String line;
	            System.out.println("Reading content from " + filename + ":");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            System.out.println("An error occurred while reading the file: " + e.getMessage());
	        }
	    }

	    // Main method to get user input and perform read/write to 'taskList.txt'
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        ReadWriteFile fileHandler = new ReadWriteFile("taskList.txt");

	        while (true) { //prompts user to input one of the options 
	            System.out.println("\nOptions:");
	            System.out.println("1. Write to file");
	            System.out.println("2. Read from file");
	            System.out.println("3. Exit");
	            System.out.print("Choose an option: ");
	            int option = scanner.nextInt();
	            scanner.nextLine();  //goes to the user input line

	            switch (option) {
	                case 1:
	                    System.out.print("Enter task(s) to write to the file: ");
	                    String userInput = scanner.nextLine();
	                    fileHandler.writeToFile(userInput);
	                    break;
	                case 2:
	                    fileHandler.readFromFile();
	                    break;
	                case 3:
	                    System.out.println("All Done!");
	                    scanner.close();
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
	}
	
