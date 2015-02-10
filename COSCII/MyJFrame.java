//Example 15-3-5
//MyJFrame.java
import javax.swing.*;								
import java.awt.event.*; 								
class MyJFrame extends JFrame			
{
	private JButton btn1 = new JButton("Hi");				
public MyJFrame()							
{
		addControls();
registerListeners();
		setTitle("Event handling");						
		setSize(200,100); 						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );		
setVisible(true);							
	}									
	public void addControls()							
	{
		add(btn1);
}									
	public void registerListeners()
	{
		btn1.addActionListener(
		new ActionListener()						//line 26	
		{
			public void actionPerformed(ActionEvent e)
			{
				((JButton)e.getSource()).setForeground(java.awt.Color.red);  	//line 30
			}
		});								//line 32
	}									
	public static void main(String[] args)
   	{
		MyJFrame f=new MyJFrame();	
	}
}