package todo;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon; //allows import of an image, cite path
//imports for buttons and panel utility 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addtask {
	//instance variables 
	private JPanel panel;
	private JTextField taskTextField;
	private JButton addButton;
	
	//Constructor Functions, initialize the class
	public Addtask() {
		//create panel for pop up to get taskText
		//panel structure saved in this class to be carried through everytime its called on
		panel = new JPanel();
		panel.setLayout(null); //set null so we can control the layout
		
		//creates label
		JLabel label =  new JLabel("Task: ");
		//set bounds
		label.setBounds(10,10,50,20);
	
		//create text field for user input
		taskTextField = new JTextField(); 
		taskTextField.setBounds(70,10,200,20); //200 is horizontal, 20 is vertical, 70, 10 is coordinates
		
		//create 'AddTask' button with an image 
		ImageIcon icon = new ImageIcon("images/add.png"); //name of image, make sure to place image in 'image' folder through eclipse folder
		Image scaledImage = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage); //converts back to image icon to be usable
		//creates button
			addButton = new JButton("Add Task", scaledIcon);
		addButton.setBounds(10,40,120,30);
		
		//sets the margins to zero to control the look of the button
		//if you don't the computer will automatically set the margins
		addButton.setMargin(new Insets(0,0,0,0));
		addButton.setFocusPainted(false); //cleans up image border
		
		//add parts to panel (GUI)
		panel.add(label);
		panel.add(taskTextField);
		panel.add(addButton);
	}
	
	//get functions
	public JPanel getPanel() {
		return panel;
	}
	public JTextField getTaskTextField() {
		return taskTextField;
	}
	public JButton getAddButton() {
		return addButton;
	}
	

}
