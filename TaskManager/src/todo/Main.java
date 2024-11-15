//Main.java for TaskManager
package todo;

//all current imports in Main.java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class Main {
	//the instance variable
	private static JPanel taskPanel;

	public static void main(String[] args) {
		
		 // Initialize the frame
		JFrame frame = new JFrame("TaskManager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Looked this up on stacks overflow (mainly had help there)
		frame.setSize(500, 500);
		frame.setLayout(null);
		
		//panel for the task GUI and maintains them
		taskPanel = new JPanel();
		taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));		
		
		//creates a scroll function and where to put it
		JScrollPane scrollPane  = new JScrollPane(taskPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //scroll panel appears when theres too many tasks
		scrollPane.setBounds(10,10,460,400); //coordinates of the scrollpane (height, width)
		
		//Creates instance of add function as a class
		Addtask addTask = new Addtask();
		JButton addButton = addTask.getAddButton(); 
		
		//Function to addTask button
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addnewTask();
				
			}
			
		});

		//creates the Clear All Tasks button to delete all outstanding tasks
		JButton clearButton = new JButton("Clear All Tasks");
		clearButton.setBounds(250,420,120,30); //sets the property bounds of the button
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //'Clear All Tasks' method for the button
				clearAllTasks();
				
				
			}
			
		});
		
		//set and add the parts to the frame panel
		addButton.setBounds(120,420,120,30); //(x axis, y axis)
		frame.add(scrollPane);
		frame.add(addButton);
		frame.add(clearButton);
		
		//set panel to true and non resizable
		frame.setVisible(true);
		frame.setResizable(false);
	}
	//Add new task function, referenced within class
	private static void addnewTask() {
		//creates an instance for addTask
		Addtask addTask = new Addtask();
		int result =JOptionPane.showConfirmDialog(null, addTask.getPanel(), "Create A Task", JOptionPane.OK_CANCEL_OPTION); //found this on stacks overflow
		 
		
		//Conditions
		//If user clicks 'Ok', create a new task and add into the panel
		if(result == JOptionPane.OK_OPTION) {
			String taskText = addTask.getTaskTextField().getText(); //gets the input from user 
			
			if(!taskText.isEmpty()) { //Pane doesn't go away if nothing is entered
				Task newTask = new Task(taskText, taskPanel);
				taskPanel.add(newTask.getTaskPanel()); //goes inside task class
				
				//tells panel where the task should go 
				taskPanel.revalidate();
				//replaces tasks from the previous position
				taskPanel.repaint();
				
			}
		}
		
	}

	
	//Clear All Tasks function
	private static void clearAllTasks() {
		//remove all tasks from the panel
		taskPanel.removeAll();
		taskPanel.revalidate();
		taskPanel.repaint();
		
	}
}//End of Main.java

