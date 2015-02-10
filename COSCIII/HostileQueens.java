//Thomas Madigan
//tfmadigan12@ole.augie.edu
//HostileQueens.java
import java.util.Scanner;
public class HostileQueens
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the size of the board: ");
		int size=keyboard.nextInt();
		ChessBoard board = new ChessBoard(size);
		int[] queenPos = new int[size];
		System.out.print("Enter row for queen in column 0: ");
		int row = keyboard.nextInt();
		if (EightQueens.setQueens(queenPos, row, size))
		{
			board.setQueens(queenPos);
			board.drawBoard();
		}
		else System.out.println("No solution");
	}
}
class ChessBoard
{
	private boolean[][] board;
	private int size;
	public ChessBoard()
	{
		board = new boolean[8][8];
	}
	public ChessBoard(int size)
	{
		this.size=size;
		board=new boolean[size][size];
	}
	private void clearBoard()
	{
		for(int i=0;i < size;i++)
			for(int j=0;j < size;j++)
				board[i][j] = false;
	}
	//Post: Size number of queens set on board at cells (queenPos[0], 0), 
	//		(queenPos[1], 1), …, (queenPos[size], size)
	public void setQueens(int[] queenPos)
	{
		clearBoard();
		for (int col = 0; col < size; col++)
			board[queenPos[col]][col] = true;
	}
	public void drawBoard()
	{
		System.out.print("   ");
		for(int i=0; i<size; ++i)
			System.out.printf("%3d", i);
		System.out.println();
		for (int i = 0; i < size; i++)
		{
			System.out.printf("%3d", i);
			for (int j = 0; j < size; j++)
				if (board[i][j] == true) System.out.printf("%3c", 'Q');
				else System.out.printf("%3c", '-');
			System.out.println();
		}
	}
}
class EightQueens
{
	//Return:True if (row,col) is safe, that is, queens set in queenPos[0]..queenPos[col-1] cannot 
	//	attack queen at (row,col); return false otherwise.
	//Note:	(j, i) and (row,col) in the same \ diagonal if i-j=col-row
	//	(j, i) and (row,col) in the same / diagonal if i+j=col+row
	public static boolean safeLocation(int row, int col, int[] queenPos)
	{
		for (int i = 0; i < col; i++)	
		{
			int j = queenPos[i];
			if (j == row) return false;				//same row
			else if(i-j==col-row || i+j==col+row) return false;	//same diagonal
		}
		return true;
	}
	//Pre:	row is the position of the first queen
	//Post:	If there is a solution, queenPos[0] set to row, queenPos[1]..queenPos[size] set to safe 
	//	positions
	//Return:	True if there is a solution; false otherwise.
	public static boolean setQueens(int[] queenPos, int row, int size)
	{
		queenPos[0] = row;
		if (placeQueens(queenPos, 1, size)) return true;	 
		else return false;				
	}
	//Pre:	queenPos[0]..queenPos[col-1] have queens set safely
	//	col is the next column to be set
	//	col>0
	//Post:	If there is a solution, queenPos[col]..queenPos[size] set to safe positions so that 
	//	queenPos[0]..queenPos[size] are all safe
	//Return:	True if there is a solution; false otherwise.
	private static boolean placeQueens(int[] queenPos, int col, int size)
	{
		int row;
		boolean found;
		if (col == size) found = true;
		else
		{
			found = false; 
			row = 0;
			while (row < size && !found)
			{
				if (safeLocation(row, col, queenPos) == true)
				{
					queenPos[col] = row;
					found = placeQueens(queenPos,col+1,size); 
					if (!found) row++; 	
				}				
								
				else row++;			
			}	
		}
		return found;
	}
}