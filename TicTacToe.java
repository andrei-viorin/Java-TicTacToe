package test;
import java.util.Scanner;

public class TicTacToe {

	private final static int SIZE=3;
	private static char[][] game;
	private static int count;
	
	public static void reset () {
		count=0;
		game = new char[SIZE][SIZE];
		for (int i=0;i<game.length;i++) {
			for (int j=0;j<game[i].length;j++) {
				game[i][j] = ' ';
			}
		}
	}
	
	public static void printBoard() {
		int a=0;
		System.out.println("\t  0   1   2");
		System.out.println("\t-------------");
		for (int i=0;i<game.length;i++) {
			System.out.print(a++ + "\t");
			for (int j=0;j<game[i].length;j++) {
				System.out.print("| " + game[i][j] + " ");
			}
			System.out.println("|");	
			System.out.println("\t-------------");
		}
	}
	
	public static boolean isAvailable(int i, int j) {
		return (game[i][j]==' ');
	}
	
	public static char checkTurn() {
		if (count%2==0) 
			return 'X';
		else return 'O';
	}
	
	public static void addMove(int i, int j) {
		// check if isAvailable first
			game[i][j] = checkTurn();
			count++;
	}
	
	public static boolean isFull() {
		boolean isfull = true;
		for (int i=0;i<game.length; i++) {
			for (int j=0;j<game[i].length;j++) {
				if (isAvailable(i,j))
					isfull = false;
			}
		}
		return isfull;
	}
	
	public static boolean checkSpaces(char i, char j, char k) {
		return ((i!=' ')&&(i==j)&&(i==k));
	}
	
	public static boolean checkDiag() {
		if ((checkSpaces(game[0][0], game[1][1], game[2][2])==true) || (checkSpaces(game[2][0], game[1][1], game[0][2])==true))
			return true; 
		return false;
	}
	
	public static boolean checkRows() {
		for (int i=0;i<game.length;i++)
			if (checkSpaces(game[i][0], game[i][1], game[i][2])==true)
				return true;
		return false;
	}
	
	public static boolean checkColumns() {
		for (int j=0;j<game.length;j++) 
			if (checkSpaces(game[0][j], game[1][j], game[2][j])==true)
					return true;
		return false;
	}
	
	public static boolean isWinner() {
		if ((checkDiag()==true) || (checkRows()==true) || (checkColumns()==true))
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i,j;
		System.out.println("Tic Tac Toe has started! Please choose your moves wisely!");
		reset();		
		while (!isFull() && !isWinner()) {
			printBoard();
			do {
			System.out.print("It is Player's " + checkTurn() + " turn. Please choose the row for your move: " );
			i = input.nextInt();
			System.out.print("Please select the column for your move: ");
			j = input.nextInt();
			} while (!isAvailable(i,j));
			addMove(i,j);
		}
		printBoard();
		if (isWinner()==true) {
			count--;
			System.out.println("Congratulations. Player " + checkTurn() + " has won the Tic Tac Toe game.");
		}
		else 
			System.out.println("It is a tie!");
	}
}
