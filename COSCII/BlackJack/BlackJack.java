//Eric Voss, Thomas Madigan
//envoss11@ole.augie.edu, tfmadigan12@ole.augie.edu
//BlackJack.java
import java.io.*;
import java.util.*;
import javax.swing.*;							
import java.awt.*;
import java.awt.event.*;
public class BlackJack extends JFrame
{
	private DeckOfCards deck;
	private Vector<String> dealer;
	private Vector<String> player;		
	private JButton btnDeal = new JButton("Deal");					
	private JPanel pnlCenter = new JPanel();
	private JButton Player= new JButton("Player");			
	private JButton Dealer = new JButton("Dealer");	
	private JButton New=new JButton("New");
	private JPanel pnlSouth = new JPanel();
	private JLabel[] lblPCard=new JLabel[8];
	private JLabel[] lblDCard=new JLabel[8];
	private Boolean first=true;
	private JPanel pnlNorth=new JPanel();
	private JRadioButton bet1;
	private JRadioButton bet2;
	private ButtonGroup gpBet=new ButtonGroup();
	private int money=0;
	private int bet=0;
	private JLabel total=new JLabel("You have $"+money);
	private class BtnHandler implements ActionListener, ItemListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnDeal)
			{
				printPlayer();
				printDealer();
				Player.setEnabled(true);
				Player.setBackground(null);
				btnDeal.setEnabled(false);
				btnDeal.setBackground(Color.gray);
			}
			if(e.getSource()==Player)
			{
				playerTurn();
			}
			if(e.getSource()==Dealer)
			{
				dealerTurn();
			}
			if(e.getSource()==New)
			{
				newGame();
				enableBet();
			}
		}
		public void itemStateChanged(ItemEvent e)
		{
			if(bet1.isSelected())
			{
				bet=1;
				btnDeal.setEnabled(true);
				btnDeal.setBackground(null);
			}
			if(bet2.isSelected()) 
			{
				bet=2;
				btnDeal.setEnabled(true);
				btnDeal.setBackground(null);
			}
			bet2.setEnabled(false);
			bet1.setEnabled(false);
			
		}
	}
	public static void main(String[]args)
	{
		BlackJack b=new BlackJack();
		b.setTitle("BlackJack");			
		b.setSize(660, 350);						
		b.setLocationRelativeTo(null);					
		b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		b.setVisible(true);	
	}
	public BlackJack()
	{
		dealer=new Vector<String>();
		player=new Vector<String>();
		deck=new DeckOfCards();
		deck.shuffle();
		player.add(deck.deal());
		player.add(deck.deal());
		dealer.add(deck.deal());
		dealer.add(deck.deal());
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);							
		add(pnlSouth, BorderLayout.SOUTH);
		setJLabel();
		addControlsPnlNorth();
		addControlsPnlCenter();
		addControlsPnlSouth();
		registerListeners();
	}
	private int total(Vector<String> v)
	{
		int total=0;
		for(int i=0; i<v.size(); ++i)
			total+=getValue(v.get(i));
		return total;
	}
	public int getValue(String s)
	{
        int value=0;
		if(s.indexOf("Ace")!=-1) value=11;
		else if(s.indexOf("Two")!=-1) value=2;
		else if(s.indexOf("Three")!=-1) value=3;
		else if(s.indexOf("Four")!=-1) value=4;
		else if(s.indexOf("Five")!=-1) value=5;
		else if(s.indexOf("Six")!=-1) value=6;
		else if(s.indexOf("Seven")!=-1) value=7;
		else if(s.indexOf("Eight")!=-1) value=8;
		else if(s.indexOf("Nine")!=-1) value=9;
		else if(s.indexOf("Ten")!=-1) value=10;
        else value=10;
		return value;
	}
	public void printPlayer()
	{
		for(int i=0; i<player.size(); ++i)
		{
			lblPCard[i].setIcon(new ImageIcon(player.get(i).toLowerCase()+".gif"));
		}
	}
	public void printDealer()
	{
		if(first)
		{
			lblDCard[0].setIcon(new ImageIcon(dealer.get(0).toLowerCase()+".gif"));
			lblDCard[1].setIcon(new ImageIcon("card.gif"));
			first=false;
		}
		else
		{
			for(int i=0;i<dealer.size();++i)
			{
				lblDCard[i].setIcon(new ImageIcon(dealer.get(i).toLowerCase()+".gif"));
			}
		}
	}
	public void playerTurn()
	{
		while(true)
		{
			String s=JOptionPane.showInputDialog(null, "You have "+total(player)+" Hit or stay H/S");
			if(s.equalsIgnoreCase("h"))
			{
				player.add(deck.deal());
				printPlayer();
			}
			if(total(player)>21)
			{
				JOptionPane.showMessageDialog(null, "You Busted");
				printPlayer();
				money=money-bet;
				break;
			}
			if(s.equalsIgnoreCase("s"))
				break;
		}
		Player.setEnabled(false);
		Player.setBackground(Color.gray);
		if(total(player)<=21)
		{
			Dealer.setEnabled(true);
			Dealer.setBackground(null);
		}
		else
		{
			New.setEnabled(true);
			New.setBackground(null);
		}
	}
	public void dealerTurn()
	{
		while(total(dealer)<17)
		{
			dealer.add(deck.deal());
			printDealer();
		}
		Dealer.setEnabled(false);
		Dealer.setBackground(Color.gray);
		if(total(dealer)>21)
		{
			JOptionPane.showMessageDialog(null, "The Dealer Busted");
			printDealer();   
			New.setEnabled(true);
			New.setBackground(null);
			money=money+bet;
		}
		else
		{
			printDealer();
			whoWin();
			New.setEnabled(true);
			New.setBackground(null);
		}
	}
	public void whoWin()
	{
		if(total(dealer)>total(player))
		{
			JOptionPane.showMessageDialog(null, "The Dealer won");
			money=money-bet;
		}
		if(total(dealer)<total(player))
		{
			JOptionPane.showMessageDialog(null, "You won");
			money=money+bet;
		}
		if(total(dealer)==total(player))
		{
			JOptionPane.showMessageDialog(null, "It is a tie");
		}
		
	}
	public void setJLabel()
	{
		for(int i=0; i<lblPCard.length; ++i)
		{
			lblDCard[i]=new JLabel("Dealer");
			lblPCard[i]=new JLabel("Player");
		}
	}
	public void newGame()
	{
		player.removeAllElements();
		dealer.removeAllElements();
		setJLabel();
		deck.shuffle();
		pnlCenter.removeAll();
		addControlsPnlCenter();
		pnlCenter.revalidate();
		player.add(deck.deal());
		player.add(deck.deal());
		dealer.add(deck.deal());
		dealer.add(deck.deal());
		first=true;
		New.setEnabled(false);
		New.setBackground(Color.gray);			
		gpBet.clearSelection();
		total.setText("You Have $"+money);
	}
	public void enableBet()
	{
		bet2.setEnabled(true);
		bet1.setEnabled(true);
	}
	public void addControlsPnlNorth()
	{
		pnlNorth.setLayout(new FlowLayout());
		bet1=new JRadioButton("$1 bet");
		bet2=new JRadioButton("$2 bet");
		pnlNorth.add(bet1);
		pnlNorth.add(bet2);
		pnlNorth.add(total);
		gpBet.add(bet1);
		gpBet.add(bet2);
		
	}
	public void addControlsPnlCenter()
	{
		pnlCenter.setLayout(new GridLayout(2,7,10,30));
		for(int i=0; i<lblPCard.length; ++i)
		{
			pnlCenter.add(lblPCard[i]);	
		}
		for(int i=0; i<lblPCard.length; ++i)
		{
			pnlCenter.add(lblDCard[i]);	
		}
	}
	public void addControlsPnlSouth()
	{
		pnlSouth.setLayout(new FlowLayout());		
		pnlSouth.add(btnDeal);
		btnDeal.setEnabled(false);
		btnDeal.setBackground(Color.gray);
		pnlSouth.add(Player);
		Player.setEnabled(false);
		Player.setBackground(Color.gray);
		pnlSouth.add(Dealer);
		Dealer.setEnabled(false);
		Dealer.setBackground(Color.gray);
		pnlSouth.add(New);
		New.setEnabled(false);
		New.setBackground(Color.gray);
	}
	public void registerListeners()
	{
		btnDeal.addActionListener(new BtnHandler());
		Player.addActionListener(new BtnHandler());
		Dealer.addActionListener(new BtnHandler());
		New.addActionListener(new BtnHandler());
		bet1.addItemListener(new BtnHandler());
		bet2.addItemListener(new BtnHandler());
	}
}