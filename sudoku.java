import java.util.Scanner;

public class sudoku
{
	//sets the test Sudoko puzzle
	public static int[][] test= 
	{
	  {5, 3, 0, 0, 7, 0, 0, 0, 0},
	  {6, 0, 0, 1, 9, 5, 0, 0, 0},
	  {0, 9, 8, 0, 0, 0, 0, 6, 0},
	  {8, 0, 0, 0, 6, 0, 0, 0, 3},
	  {4, 0, 0, 8, 0, 3, 0, 0, 1},
	  {7, 0, 0, 0, 2, 0, 0, 0, 6},
	  {0, 6, 0, 0, 0, 0, 2, 8, 0},
	  {0, 0, 0, 4, 1, 9, 0, 0, 5},
	  {0, 0, 0, 0, 8, 0, 0, 7, 9} 
	};
	
	//initializes the board array
	private int[][] board;
	
	//initializes empty cell to zero
	public static final int EMPTY = 0; 
	
	//initializes max number size of the Sudoku grid
	public static final int SIZE = 9; 
	
	//sets the all of initial board cells to zero
	public sudoku(int[][] board)
	{
		this.board = new int[SIZE][SIZE];
		
		for (int r = 0; r < SIZE; r++)
		{
			for (int c = 0; c < SIZE; c++)
			{
				this.board[r][c] = board[r][c];
			}
		}
	}
	
	//check if number is already in a row
	private boolean in_row(int row, int num)
	{
		//loop checking the cells in the row array
		for (int r = 0; r < SIZE; r++)
		{
			if (board[row][r] == num)
			{
				return true;
			}
		}
		
		return false;
	}
	
	//checks if the number is already in a column
	private boolean in_col(int col, int num)
	{
		//loop checking the cells in the column array
		for (int c = 0; c < SIZE; c++)
		{
			if (board[c][col] == num)
			{
				return true;
			}
		}
		
		return false;
	}
	
	//checks if a possible number is in the 3 by 3 box
	private boolean in_box(int row, int col, int num)
	{
		//breaks down the 9 by 9 into a 3 by 3
		int r = row - row % 3;
		int c = col - col % 3;
		
		//loop checking the rows and then columns
		for (int i = r; i < r + 3; i++)
		{
			for (int j = c; j < c + 3; j++)
			{
				if (board[i][j] == num)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	//checks to see if a number matches any others in any of the other rows, columns, or inside the 3 by 3 box
	private boolean check(int row, int col, int num)
	{
		return !in_row(row, num)  &&  !in_col(col, num)  &&  !in_box(row, col, num);
	}
	
	//recursive backtracking solve method that seaches for empty cells and tests until it finds the correct one
    public boolean solve()
    {
       	for (int row = 0; row < SIZE; row++)
       	{
       		for (int col = 0; col < SIZE; col++)
        	{
        		//searchs an empty cell
        		if (board[row][col] == EMPTY)
          		{
            	//now tries all possible numbers
            	for (int num = 1; num <= SIZE; num++)
            	{
            		//if the number ok and follows the rules
            		if (check(row, col, num))
            		{
               			board[row][col] = num;

               			//then begin recursive backtracking solve
           				if (solve())
               			{
               				//the number has been added to the cell
               				return true;
               			}
               			else
               			{ 
              				//otherwise if its not a solution, then we empty the cell and continue
               				board[row][col] = EMPTY;
               			}
           			}
           		}

				//could not solve
           		return false; 
           	}
        }
    }

	//puzzle is solved
    return true; 
	}
	
	//prints out the sudoku puzzle board
	public void display()
	{
		for (int r = 0; r < SIZE; r++)
		{
			for (int c = 0; c < SIZE; c++)
			{
				System.out.print(" " + board[r][c]);
			}
		
			System.out.println();
		}

		System.out.println();
	}

	@Override
	public String toString() {
	    StringBuilder str = new StringBuilder();
	    for (int row=0; row<9; row++){
		if (row%3==0){
		    str.append("----------------------\n");
		}
		for (int col=0; col<9; col++){
		    if (col%3=0){
			str.append('|');
		    }
		    str.append(' ' + Integer.toString(board[row][col]));
		}
		str.append("|\n");
	    }
	    str.append("----------------------");
	    return str.toString();
	}
	public static void main(String[] args)
	{
		sudoku sudoku = new sudoku(test);

		System.out.println("\nHere is the Sudoku puzzle to solve\n");

		sudoku.display();
		
		if (sudoku.solve())
		{
			System.out.println("Sudoku puzzle has been solved\n");

			sudoku.display();

		}
		else
		{
			System.out.println("The Sudoku puzzle is unsolvable");
		}
	}
}
