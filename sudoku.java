import java.util.Scanner;

public class sudoku
{	
	//initializes the empty board array
	private int[][] board;
	
	//initializes empty cell to zero
	public static final int EMPTY = 0; 
	
	//initializes max number size of the Sudoku grid
	public static final int SIZE = 9;

	//allows user to set the all of initial board cells
	public void enterBoard()
	{
		System.out.println("Enter rows in table: ");
    	Scanner input = new Scanner(System.in); 
    
		int x = input.nextInt();
	
		System.out.println("Enter col in table: ");
    
		int y = input.nextInt();
	
		board= new int[x][y];
    
   		System.out.println("Enter array: ");
   
   		for (int r = 0; r < SIZE; r++)
		{
			for (int c = 0; c < SIZE; c++)
			{
	   			board[r][c]=input.nextInt();   			
   			}

   			System.out.println("The test puzzle board has been added.");
   			return;
   			}
   		return;
	}
	
	//sets the all of initial board cells to zero
	public sudoku()
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
    public boolean fillBoard()
    {
       	for (int r = 0; r < SIZE; r++)
       	{
       		for (int c = 0; c < SIZE; c++)
        	{
        		//searchs an empty cell
        		if (board[r][c] == EMPTY)
          		{
            	//now tries all possible numbers
            	for (int num = 1; num <= SIZE; num++)
            	{
            		//if the number ok and follows the rules
            		if (check(r, c, num))
            		{
               			board[r][c] = num;

               			//then begin recursive backtracking solve
           				if (fillBoard())
               			{
               				//the number has been added to the cell
               				return true;
               			}
               			else
               			{ 
              				//otherwise if its not a solution, then we empty the cell and continue
               				board[r][c] = EMPTY;
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
	public void printBoard()
	{
		StringBuilder str = new StringBuilder();
		for (int r=0; r<9; r++)
		{
			if (r%3==0)
			{
				str.append("----------------------\n");
			}
			for (int c=0; c<9; c++)
			{
				if (c%3==0)
				{
					str.append('|');
				}
					str.append(' ' + Integer.toString(board[r][c]));
			}
			str.append("|\n");
		}
		str.append("----------------------");
		System.out.println(str);
	}


	public static void main(String[] args)
	{
		System.out.println("\nThis is the Sudoku Puzzle Program\n");

		sudoku sudoku = new sudoku();

		sudoku.enterBoard();
		
		System.out.println("\nHere is the Sudoku puzzle to solve\n");

		sudoku.printBoard();

		if (sudoku.fillBoard())
		{
			System.out.println("Sudoku puzzle has been solved\n");

			sudoku.printBoard();

		}
		else
		{
			System.out.println("The Sudoku puzzle is unsolvable");
		}
	}
}
