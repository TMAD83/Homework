//Jeopardy.java
import javax.swing.*;								
import java.awt.*; 								
import java.awt.event.*; 								
public class Jeopardy extends JFrame implements ActionListener			
{
	private JLabel[] category=new JLabel[6];
	private Font labelFont=new Font("Ariel", Font.BOLD, 25);  	
	private JButton[] catCompSci=new JButton[5];
	private JButton[] catMath=new JButton[5];
	private JButton[] catSci=new JButton[5];
	private JButton[] catPeople=new JButton[5];
	private JButton[] catSports=new JButton[5];
	private JButton[] catGames=new JButton[5];
	private Font buttonFont=new Font("Courier", Font.BOLD, 25);  	
	private JPanel pnlNorth=new JPanel();
	private JPanel pnlCenter=new JPanel();
	private String[] cat1Question=new String[5];
	private String[] cat1Answer=new String[5];
	private String[] cat2Question=new String[5];
	private String[] cat2Answer=new String[5];
	private String[] cat3Question=new String[5];
	private String[] cat3Answer=new String[5];
	private String[] cat4Question=new String[5];
	private String[] cat4Answer=new String[5];
	private String[] cat5Question=new String[5];
	private String[] cat5Answer=new String[5];
	private String[] cat6Question=new String[5];
	private String[] cat6Answer=new String[5];
	public Jeopardy()							
	{
		category[0]=new JLabel("CompSci");
		category[1]=new JLabel("Math");
		category[2]=new JLabel("Science");
		category[3]=new JLabel("People");
		category[4]=new JLabel("Sports");
		category[5]=new JLabel("Games");
		setUpButtons();
		addControls();
		registerListeners();
		setTitle("Jeopardy");	
		setSize(1000, 700); 						
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );		
		setVisible(true);			
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		setUpQuestions();
	}									
	public void addControls()
	{
		addControlsNorth();
		addControlsCenter();
		setLabelFontColor();
		setButtonFontColor();
	}	
	public void addControlsNorth()
	{
		pnlNorth.setLayout(new GridLayout(1, 6, 5, 0));
		for(int i=0; i<category.length; ++i)
		{
			pnlNorth.add(category[i]);
		}
	}
	public void addControlsCenter()
	{
		pnlCenter.setLayout(new GridLayout(5, 6, 10, 10));
		for(int i=0; i<catCompSci.length; ++i)
		{
			pnlCenter.add(catCompSci[i]);
			pnlCenter.add(catMath[i]);
			pnlCenter.add(catSci[i]);
			pnlCenter.add(catPeople[i]);
			pnlCenter.add(catSports[i]);
			pnlCenter.add(catGames[i]);
		}
	}
	public void setUpButtons()
	{
		for(int i=0; i<catCompSci.length; ++i)
		{	
			String s=String.valueOf((i+1)*100);
			catCompSci[i]=new JButton(s);
			catMath[i]=new JButton(s);
			catSci[i]=new JButton(s);
			catPeople[i]=new JButton(s);
			catSports[i]=new JButton(s);
			catGames[i]=new JButton(s);
		}
	}
	public void setLabelFontColor()
	{
		for(int i=0; i<category.length; ++i)
		{
			category[i].setFont(labelFont);
			category[i].setOpaque(true);
			category[i].setBackground(Color.blue);
			category[i].setForeground(Color.pink);
		}
	}
	public void setButtonFontColor()
	{
		for(int i=0; i<catCompSci.length; ++i)
		{
			catCompSci[i].setFont(buttonFont);
			catCompSci[i].setBackground(Color.yellow);
			catMath[i].setFont(buttonFont);
			catMath[i].setBackground(Color.yellow);
			catSci[i].setFont(buttonFont);
			catSci[i].setBackground(Color.yellow);
			catPeople[i].setFont(buttonFont);
			catPeople[i].setBackground(Color.yellow);
			catSports[i].setFont(buttonFont);
			catSports[i].setBackground(Color.yellow);
			catGames[i].setFont(buttonFont);
			catGames[i].setBackground(Color.yellow);			
		}
	}
	public void registerListeners()
	{
		for(int i=0; i<catCompSci.length; ++i)
		{
			catCompSci[i].addActionListener(this);
			catMath[i].addActionListener(this);
			catSci[i].addActionListener(this);
			catPeople[i].addActionListener(this);
			catSports[i].addActionListener(this);
			catGames[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<catCompSci.length; ++i)
			if (e.getSource() == catCompSci[i]) 
			{
				catCompSci[i].setEnabled(false);
				catCompSci[i].setBackground(Color.gray);
				MyJFrame f= new MyJFrame(cat1Question[i], cat1Answer[i]);
			}
		for(int i=0; i<catMath.length; ++i)
			if(e.getSource()==catMath[i])
			{
				catMath[i].setEnabled(false);
				catMath[i].setBackground(Color.gray);
				MyJFrame f=new MyJFrame(cat2Question[i], cat2Answer[i]);
			}
		for(int i=0; i<catSci.length; ++i)
			if(e.getSource()==catSci[i])
			{
				catSci[i].setEnabled(false);
				catSci[i].setBackground(Color.gray);
				MyJFrame f=new MyJFrame(cat3Question[i], cat3Answer[i]);
			}
		for(int i=0; i<catPeople.length; ++i)
			if(e.getSource()==catPeople[i])
			{
				catPeople[i].setEnabled(false);
				catPeople[i].setBackground(Color.gray);
				MyJFrame f=new MyJFrame(cat4Question[i], cat4Answer[i]);
			}
		for(int i=0; i<catSports.length; ++i)
			if(e.getSource()==catSports[i])
			{
				catSports[i].setEnabled(false);
				catSports[i].setBackground(Color.gray);
				MyJFrame f=new MyJFrame(cat5Question[i], cat5Answer[i]);
			}
		for(int i=0; i<catGames.length; ++i)
			if(e.getSource()==catGames[i])
			{
				catGames[i].setEnabled(false);
				catGames[i].setBackground(Color.gray);
				MyJFrame f=new MyJFrame(cat6Question[i], cat6Answer[i]);
			}
	}
	public void setUpQuestions()
	{
		setUpCat1();
		setUpCat2();
		setUpCat3();
		setUpCat4();
		setUpCat5();
		setUpCat6();
	}
	public void setUpCat1()
	{
		cat1Question[0]="COSC Q1";
		cat1Question[1]="COSC Q2";
		cat1Question[2]="COSC Q3";
		cat1Question[3]="COSC Q4";
		cat1Question[4]="COSC Q5";
		cat1Answer[0]="COSC A1";
		cat1Answer[1]="COSC A2";
		cat1Answer[2]="COSC A3";
		cat1Answer[3]="COSC A4";
		cat1Answer[4]="COSC A5";
	}
	public void setUpCat2()
	{
		cat2Question[0]="Math Q1";
		cat2Question[1]="Math Q2";
		cat2Question[2]="Math Q3";
		cat2Question[3]="Math Q4";
		cat2Question[4]="Math Q5";
		cat2Answer[0]="Math A1";
		cat2Answer[1]="Math A2";
		cat2Answer[2]="Math A3";
		cat2Answer[3]="Math A4";
		cat2Answer[4]="Math A5";
	}
	public void setUpCat3()
	{
		cat3Question[0]="Science Q1";
		cat3Question[1]="Science Q2";
		cat3Question[2]="Science Q3";
		cat3Question[3]="Science Q4";
		cat3Question[4]="Science Q5";
		cat3Answer[0]="Science A1";
		cat3Answer[1]="Science A2";
		cat3Answer[2]="Science A3";
		cat3Answer[3]="Science A4";
		cat3Answer[4]="Science A5";
	}
	public void setUpCat4()
	{
		cat4Question[0]="People Q1";
		cat4Question[1]="People Q2";
		cat4Question[2]="People Q3";
		cat4Question[3]="People Q4";
		cat4Question[4]="People Q5";
		cat4Answer[0]="People A1";
		cat4Answer[1]="People A2";
		cat4Answer[2]="People A3";
		cat4Answer[3]="People A4";
		cat4Answer[4]="People A5";
	}
	public void setUpCat5()
	{
		cat5Question[0]="Sports Q1";
		cat5Question[1]="Sports Q2";
		cat5Question[2]="Sports Q3";
		cat5Question[3]="Sports Q4";
		cat5Question[4]="Sports Q5";
		cat5Answer[0]="Sports A1";
		cat5Answer[1]="Sports A2";
		cat5Answer[2]="Sports A3";
		cat5Answer[3]="Sports A4";
		cat5Answer[4]="Sports A5";
	}
	public void setUpCat6()
	{
		cat6Question[0]="Games Q1";
		cat6Question[1]="Games Q2";
		cat6Question[2]="Games Q3";
		cat6Question[3]="Games Q4";
		cat6Question[4]="Games Q5";
		cat6Answer[0]="Games A1";
		cat6Answer[1]="Games A2";
		cat6Answer[2]="Games A3";
		cat6Answer[3]="Games A4";
		cat6Answer[4]="Games A5";
	}
	public static void main(String[] args)
   	{
		Jeopardy j=new Jeopardy();					
	}
}
class MyJFrame extends JFrame 
{
	private JTextArea txa= new JTextArea();
	private String question;
	private String answer;
	private Boolean first=true;
	public MyJFrame(String ans, String ques)
   	{
		addWindowListener(new WindowAdapter()				
		{
			public void windowClosing(WindowEvent e)
			{
				if (first==true) 
			{
				txa.setText(question);  
				first=false;	
			}
			else setDefaultCloseOperation(
			JFrame.DISPOSE_ON_CLOSE );	
		}
		});
		question =ques;
		answer =ans;
		addControls();								
		setSize(800, 600);
		setLocationRelativeTo(null);				
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	
		setVisible(true);							
	}
	public void addControls()							
	{
		add(txa);
		txa.setText(answer);
		txa.setEditable(false);
		Font f=new Font("Helvetica", Font.BOLD, 50);  	
		txa.setFont(f);				
		txa.setForeground(Color.yellow);
		txa.setBackground(Color.blue);
		txa.setLineWrap(true);
		txa.setWrapStyleWord(true);
	}
}