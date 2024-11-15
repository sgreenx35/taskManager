
package todo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//adds functions to handle the tasks and bring uniqueness to them
public class Task {
	//instance variables
	private JPanel taskPanel;
	private JCheckBox checkBox;
	private JLabel taskLabel;
	private JPanel parentPanel; //primary panel
	
	//constructor functions
	//How the tasks will appear
	public Task(String taskText, JPanel parentPanel) {
		this.parentPanel = parentPanel; //saves the panel as 'parentPanel'
		taskPanel = new JPanel();
		taskPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); //set the tasks left aligned
		
		//creates checkboxes and a label for the tasks specifically
		checkBox = new JCheckBox();
		taskLabel = new JLabel(taskText);
		
		//listener to check for checkbox being clicked and if the task being right clicked for additonal options
		// also moves completed tasks to the bottom of the panel
		checkBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateTaskStatus();
				moveCompletedTaskToEnd();
				
				
			}
			
		});
		
		//add components to panel
		taskPanel.add(checkBox);
		taskPanel.add(taskLabel);
		
		//menu for the right click, delete || rename
		JPopupMenu popupMenu = new JPopupMenu();
		
		//creates delete task option (right click)
		popupMenu.add("Delete").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteTask();
				
			}
			
		});
		//creates rename task option (right click)
		popupMenu.add("Rename").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				renameTask();
				
			}
			
		});
		
		//rightclick menu for individual tasks
		taskPanel.addMouseListener(new MouseAdapter() {
			@Override
		
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(taskPanel, e.getX(), e.getY()); //makes sure the pop up appears at the location of the mouse pointer
				}
			}
		});
	}
		//creates update task
		private void updateTaskStatus() {
			//if checkbox is selected, then gray out task and italicize it
			if(checkBox.isSelected()) {
				taskLabel.setForeground(Color.GRAY);
				taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.ITALIC, taskLabel.getFont().getSize()));
			}
			//if checkbox is not selected, keep in black color and normal font
			else {
				taskLabel.setForeground(Color.BLACK);
				taskLabel.setFont(new Font(taskLabel.getFont().getName(), Font.PLAIN, taskLabel.getFont().getSize()));
		}
		
	}
	 
		//method to move task to bottom of list 
		private void moveCompletedTaskToEnd() {
			//if checkbox was selected move to the bottom of the list
			if (checkBox.isSelected()) {
				parentPanel.remove(checkBox);
				parentPanel.add(taskPanel);
				parentPanel.revalidate();
				parentPanel.repaint(); //makes changes to panel 
		
			}
		}
	//method to rename tasks
		private void renameTask() {
			//asks user to enter a new task name
			String newTaskText = JOptionPane.showInputDialog(null, "Enter New Task Name: ", taskLabel.getText());
			//check if user gives valid input to update task name
			if(newTaskText != null && !newTaskText.isEmpty()) { //if something was change then it can update 
				taskLabel.setText(newTaskText);
				
				
			}
		}
		//create delete tasks
		private void deleteTask() {
			//removes tasks and doesn't add them back in the panel
			parentPanel.remove(taskPanel);
			parentPanel.revalidate();
			parentPanel.repaint();
		}
		
		//get method for task panel for the Main.java repeatedly
		public JPanel getTaskPanel() {
			return taskPanel;
			
		}
}
