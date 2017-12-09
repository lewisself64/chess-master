package pieces;

import java.util.ArrayList;

public abstract class Piece 
{
	private String name;
	private String color;
	private String image;
	
	private int value;
	private int x;
	private int y;
	
	// Set the piece activity to false on creation and the first move to true
	private boolean active    = false;
	private boolean firstMove = true;
	
	Piece(String pName, String pColor, int pValue, int pY, int pX, String pImage)
	{
		this.name  = pName;
		this.color = pColor;
		this.value = pValue;
		this.x     = pX;
		this.y     = pY;
		this.image = pImage;
	}

	public ArrayList<ArrayList<Integer>> singlePath(int y, int x)
	{
		ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();
		
		// Prevents the king going to squares off the board
		if((y < 8 && y > -1) && (x < 8 && x > -1))
		{
			ArrayList<Integer> moves = new ArrayList<Integer>();

			moves.add(y);
			moves.add(x);
			path.add(moves);
		}
		
		return path;
	}
	
	public ArrayList<ArrayList<Integer>> createPathDown()
	{
		ArrayList<ArrayList<Integer>> pathDown = new ArrayList<ArrayList<Integer>>();
		
		// Create path to move rook downwards
		for(int i = x + 1; i < 8; i++)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();

			moves.add(y);
			moves.add(i);
			
			pathDown.add(moves);
		}
		
		return pathDown;
	}
	
	/**
	 * Calculates the path upwards of the piece.
	 * 
	 * @return Returns the path containing the x and y coordinates of the squares upwards of the piece
	 */
	public ArrayList<ArrayList<Integer>> createPathUp()
	{
		// Create an ArrayList to hold each move in the upwards path. Each move will also contain the x and y location of the square.
		ArrayList<ArrayList<Integer>> pathUp = new ArrayList<ArrayList<Integer>>();
		
		// Get the current X position of the piece and calculate possible squares upwards
		for(int i = x - 1; i > -1; i--)
		{
			// Create a moves ArrayList which will hold the coordinates for the possible upwards squares generated by the for loop
			ArrayList<Integer> moves = new ArrayList<Integer>();

			// Add y and x coordinates to the ArrayList
			moves.add(y);
			moves.add(i);
			
			// Add each move to the upwards path
			pathUp.add(moves);
		}
		
		return pathUp;
	}
	
	/**
	 * Calculates the path to the left of the piece.
	 * 
	 * @return Returns the path containing the x and y coordinates of the squares to the left of the piece
	 */
	public ArrayList<ArrayList<Integer>> createPathLeft()
	{
		// Create an ArrayList to hold each move in the left path. Each move will also contain the x and y location of the square.
		ArrayList<ArrayList<Integer>> pathLeft = new ArrayList<ArrayList<Integer>>();
		
		// Get the current Y position of the piece and calculate possible squares to the left
		for(int i = y - 1; i > -1; i--)
		{
			// Create a moves ArrayList which will hold the coordinates for the possible left squares generated by the for loop
			ArrayList<Integer> moves = new ArrayList<Integer>();

			// Add y and x coordinates to the ArrayList
			moves.add(i);
			moves.add(x);
			
			// Add each move to the left path
			pathLeft.add(moves);
		}
		
		return pathLeft;
	}
	
	public ArrayList<ArrayList<Integer>> createPathRight()
	{
		ArrayList<ArrayList<Integer>> pathRight = new ArrayList<ArrayList<Integer>>();
		
		// Create path to move rook right
		for(int i = y + 1; i < 8; i++)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();

			moves.add(i);
			moves.add(x);
			
			pathRight.add(moves);
		}
		
		return pathRight;
	}
	
	public ArrayList<ArrayList<Integer>> createPathBottomRight()
	{
		ArrayList<ArrayList<Integer>> pathBottomRight = new ArrayList<ArrayList<Integer>>();
		
		for(int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();

			moves.add(j);
			moves.add(i);
			pathBottomRight.add(moves);
		}
		
		return pathBottomRight;
	}
		
	public ArrayList<ArrayList<Integer>> createPathTopRight()
	{
		ArrayList<ArrayList<Integer>> pathTopRight = new ArrayList<ArrayList<Integer>>();
		
		for(int i = x - 1, j = y + 1; i > -1 && j < 8; i--, j++)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();
			
			moves.add(j);
			moves.add(i);
			pathTopRight.add(moves);
		}
		
		return pathTopRight;
	}
	
	public ArrayList<ArrayList<Integer>> createPathBottomLeft()
	{
		ArrayList<ArrayList<Integer>> pathBottomLeft = new ArrayList<ArrayList<Integer>>();
		
		for(int i = x + 1, j = y - 1; i < 8 && j > -1; i++, j--)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();
			
			moves.add(j);
			moves.add(i);
			pathBottomLeft.add(moves);
		}
		
		return pathBottomLeft;
	}
	
	public ArrayList<ArrayList<Integer>> createPathTopLeft()
	{
		ArrayList<ArrayList<Integer>> pathTopLeft = new ArrayList<ArrayList<Integer>>();
		
		for(int i = x - 1, j = y - 1; i > -1 && j > -1; i--, j--)
		{			
			ArrayList<Integer> moves = new ArrayList<Integer>();
			
			moves.add(j);
			moves.add(i);
			pathTopLeft.add(moves);
		}
		
		return pathTopLeft;
	}
		
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getColor() 
	{
		return color;
	}

	public void setColor(String color) 
	{
		this.color = color;
	}

	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public String getImage() 
	{
		return image;
	}

	public void setImage(String image) 
	{
		this.image = image;
	}

	public boolean isActive() 
	{
		return active;
	}

	public void setActive(boolean active) 
	{
		this.active = active;
	}

	public boolean isFirstMove() 
	{
		return firstMove;
	}

	public void setFirstMove(boolean firstMove) 
	{
		this.firstMove = firstMove;
	}
	
	public abstract ArrayList<ArrayList<ArrayList<Integer>>> possibleMoves();
}