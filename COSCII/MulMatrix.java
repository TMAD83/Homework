import java.util.Scanner;
public class MulMatrix
{
	//Desc: 	Multiply 2 square matrices
	//Input:	Keyboard supplies the dimensions of the matrix, the user than enters
	//	the values of the matrix by separating the values with white space
	//Output:The product of the 2 input matrices 
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);		
		System.out.print("Enter dimension of square matrix: ");		
		int n=input.nextInt();
		int[][] m1=new int[n][n];
		System.out.println("Enter values for m1:");		
		readMatrix(m1, input);		
		int[][] m2=new int[n][n];
		System.out.println("Enter values for m2:");		
		readMatrix(m2, input);		
		int[][] m3= mulMatrix (m1,m2);				
		System.out.println("Product of m1 and m2:");		
		printMatrix(m3);	
		input.close();	
	}
	//Desc: Will read the keyboard and enter the values in for the matrix
	//Input: The method will fill in the matrix by reading the values from
	//		 the keyboard
	public static void readMatrix(int[][]m, Scanner input)
	{
		for(int i=0; i<m.length; ++i)
		{
			System.out.print("Enter integers for row "+i
							 +" separated by white space:");
			for(int j=0; j<m.length; ++j)
				m[i][j]=input.nextInt();
		}
	}		
	//Desc: Will print the matrix that is passed to it
	public static void printMatrix(int[][]n)
	{
		for(int i=0; i<n.length; ++i)
		{
			for(int j=0; j<n.length; ++j)
				System.out.printf("%4d",n[i][j]);
			System.out.println("");
		}
	}
	
	
	
	
	//Desc: Will multiply two matrices together and put those values
	//		into a third matrix
	public static int[][] mulMatrix(int[][]m1, int[][]m2)
	{
		int[][] arr=new int[m1[0].length][m1.length];
		for(int i=0; i<m1.length; ++i)
			for(int j=0; j<m2.length; ++j)
				for(int k=0; k<m1.length; ++k)
					arr[i][j]+=m1[i][k]*m2[k][j];
		return arr;
	}
}
