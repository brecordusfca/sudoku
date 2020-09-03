# Sudoku

Sudoku is a java class that uses back-tracking to solve a standard Sudoku game.

## Usage

To use the class, first declare and initialize a 9 x 9 array

```java
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
```
Then create an instance of a sudoku game and pass the array.
```java
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
```

## Contributers
Brad Record & Dunham McBride