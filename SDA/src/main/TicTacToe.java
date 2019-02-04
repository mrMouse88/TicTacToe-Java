package main;

import java.util.Scanner;

public class TicTacToe 
{

//	rysuje planszę	
	public static void DisplayBoard (char board[][])
	//public static void DisplayBoard ()
	{
		
		
		for(int j=1;j<4;j++)
		{
			for(int i=1;i<4;i++)
			{
				System.out.printf("| "+board[j][i]+" |");
				//System.out.printf("| |");
				//System.out.print(board[j][i]);
//				if((board[j][i]!='+')||(board[j][i]!='o'));
//				{
//				 	board[j][i]=' ';
//				}
			}
			System.out.println("");
		}
	}

//	sprawdza kto wygrał
	public static void GetWinner(char board[][])
	{
		
		//sprawdzanie w poziomie
		for(int j=1;j<4;j++)
		{
			int h=0;
			for(int i=1;i<4;i++)
			{
				
				if((board[j][i])==(board[j][i+1]))
				{
					h=h+1;
				}
			}
			if(h==2)
			{
				System.out.println("Wygrały: "+board[1][1]);
				break;
			}
		}	
		//sprawdzanie w pionie
		for(int j=1;j<4;j++)
		{
			int h=0;
			for(int i=1;i<4;i++)
			{
				
				if((board[i][j])==(board[i+1][j]))
				{
					h=h+1;
				}
			}
			if(h==2)
			{
				System.out.println("Wygrały: "+board[1][1]);
				break;
			}
		}
		//sprawdzanie po skosie od lewej do prawej
		for(int j=1;j<4;j++)
		{
			int h=0;
			for(int i=1;i<4;i++)
			{
				
				if((board[j][i])==(board[j+1][j+1]))
				{
					h++;
				}
			}
			if(h==2)
			{
				System.out.println("Wygrały: "+board[1][1]);
				break;
			}
		}
		//sprawdzanie po skosie od prawej do lewej
				for(int j=1;j<4;j++)
				{
					int h=0;
					for(int i=1;i<4;i++)
					{
						
						if((board[j][i+2])==(board[j-1][j-1]))
						{
							h++;
						}
					}
					if(h==2)
					{
						System.out.println("Wygrały: "+board[1][1]);
						break;
					}
				}

	}
	
	public static void main(String[] args) 
	{
		Scanner reading = new Scanner(System.in);
		char [][]board = new char[4][4];
		//boolean roung = null;
		
		for(int j=1;j<4;j++)
		{
			for(int i=1;i<4;i++)
			{
				board[j][i]=' ';
			}
		}
		
		DisplayBoard(board);
		for(int i=1;i<10;i++)
		{
			System.out.println("Podaj współrzędną poziomą: ");
			int horizontal = reading.nextInt();
			
	
			System.out.println("Podaj współrzędną pionową: ");
			int vertical = reading.nextInt();
			
	
			System.out.println("Podaj znak: ");
			//char sign = reading.nextLine();
			//char sign = reading.nextChar();
			char sign=reading.next().charAt(0);
			if((sign=='+')||(sign=='o'))
			{	
				if(board[horizontal][vertical]==' ')
				{
					board[horizontal][vertical]=sign;
				}
				else 
				{
					System.out.println("Miejsce jest zajęte");
					
				}
			}	
				else 
				{
					System.out.println("Niepoprawny znak");

				}
				
			DisplayBoard(board);
			GetWinner(board);
		}

	
	reading.close();
	}

}
