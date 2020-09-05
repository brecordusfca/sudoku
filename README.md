# Sudoku

Sudoku is a java class that uses back-tracking to solve a standard Sudoku game.

## Usage

To use the class, first create an instance of a sudoku game then execute sudoku.enterBoard(). Optionally, you can use sudoku.printBoard() to display the 9 x 9 grid before and after filling. 

To fill the board, run sudoku.fillBoard().

```java
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
```

## Time and Space Complexity

### Time Complexity 

This is the time and space complexity of fillBoard()...

The first portion of the function checks wether each element is empty and in a worst-case scenario, all are empty and assuming all nine possible values are attempted we get O(9n) ...
```java 
    public boolean fillBoard()
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
```
... The 9 washes out giving us O(n).

The next portion of the function calls itself recursively incase no numbers can be made to fill a given square, this cause a repeat of the entire functions executiong givins another O(n) operations...
```java
//if the number ok and follows the rules
            			if (check(row, col, num))
            			{
               				board[row][col] = num;

               				//then begin recursive backtracking solve
           				if (fillBoard())
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
```
This gives us another O(n).

All in all, the algorithm has a time complexity of O(n^2).

### Space Complexity

The only variables instantiated are constant in size, the board, row, col, and num. This gives us O(85) which comes out to constant memory O(1).


## Contributers
Brad Record & Dunham McBride