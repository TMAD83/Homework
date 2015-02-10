 import java.awt.*;
 import javax.swing.*;
 import java.util.Scanner;
 // Create a simple GUI window
 public class TopLevelwindow
 {
	private static void createWindow(string s1, string s2)
	{
		//Create and set up the window.
		JFrame frame = new JFrame("s1"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel textLabel = new JLabel("s2",SwingConstants.CENTER);
		textLabel.setPreferredSize(new Dimension(200, 100)); 
		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
		//Display the window. frame.setLocationRelativeTo(null); 
		frame.pack();	
		frame.setVisible(true);
	}
	public static void main(String[] args)
		String s1="Test 1";
		String s2="Test 2";
		createWindow(s1,s2);		
}