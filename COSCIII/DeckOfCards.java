//Thomas Madigan
//tfmadigan12@ole.augie.edu
//DeckOfCards.java
import java.util.Random;
enum Suit {DIAMOND, CLUB, HEART, SPADE };
enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING };
public class DeckOfCards
{
	private static DeckOfCards d=null;
	private Rank[] r;
	private Suit[] s;
	private int top=0;
	//Post:	This DeckOfCards initialized to a new deck; the cards are ordered from AceSpace 
	//		to KingDiamond as in a new deck; top initialized to 0.
	private DeckOfCards()
	{
		r=new Rank[52];
		s=new Suit[52];
		for(int i=0; i<4; ++i)
		{
			r[i*13]=Rank.ACE;
			r[i*13+1]=Rank.TWO;
			r[i*13+2]=Rank.THREE;
			r[i*13+3]=Rank.FOUR;
			r[i*13+4]=Rank.FIVE;
			r[i*13+5]=Rank.SIX;
			r[i*13+6]=Rank.SEVEN;
			r[i*13+7]=Rank.EIGHT;
			r[i*13+8]=Rank.NINE;
			r[i*13+9]=Rank.TEN;
			r[i*13+10]=Rank.JACK;
			r[i*13+11]=Rank.QUEEN;
			r[i*13+12]=Rank.KING;
		}
		for(int i=0; i<13; ++i)
			s[i]=Suit.SPADE;
		for(int i=13; i<26; ++i)
			s[i]=Suit.HEART;
		for(int i=26; i<39; ++i)
			s[i]=Suit.CLUB;
		for(int i=39; i<52; ++i)
			s[i]=Suit.DIAMOND;
		top=0;
	}
	//Return: If d is null it returns a new DeckOfCards
	public static DeckOfCards getDeck()
	{
		if(d==null) d=new DeckOfCards();
		return d;
	}	
	
	
	
	//Post:	This DeckOfCards thoroughly shuffled; top set to 0.
	public void shuffle()
	{
		Random rand=new Random();
		for(int i=0; i<1000; ++i)
		{
			int card1=rand.nextInt(52);
			int card2=rand.nextInt(52);
			Rank temp=r[card1];
			r[card1]=r[card2];
			r[card2]=temp;
			Suit temp2=s[card1];
			s[card1]=s[card2];
			s[card2]=temp2;
		}
		top=0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Post:	top incremented by 1.
	//Return:	The top card of this DeckOfCards as a String such as "AceHeart"
	//			is returned.
	public String deal()
	{
		String Result="";
		String rank="";
		String suit="";
		if(top<52)
		{
			switch(r[top])
			{
				case ACE: rank="Ace"; break;
				case TWO: rank="Two"; break;
				case THREE: rank="Three"; break;
				case FOUR: rank="Four"; break;
				case FIVE: rank="Five"; break;
				case SIX: rank="Six"; break;
				case SEVEN: rank="Seven"; break;
				case EIGHT: rank="Eight"; break;
				case NINE: rank="Nine"; break;
				case TEN: rank="Ten"; break;
				case JACK: rank="Jack"; break;
				case QUEEN: rank="Queen"; break;
				case KING: rank="King"; break;
			}
			switch(s[top])
			{
				case SPADE: suit="Spade"; break;
				case HEART: suit="Heart"; break;
				case CLUB: suit="Club"; break;
				case DIAMOND: suit="Diamond"; break;
			}
			Result=rank+suit;
		}
		else
			Result= "NoMoreCard";
		++top;
		return Result;
	}
}