import java.awt.Color;


public class Snake
{
	
	private int xPos, yPos, width;
	private Color col;
	
	public Snake(int x, int y, int w, Color c)
	{
		xPos = x;
		yPos = y;
		width = w;
		col = c;
	}
	
	public Color getColor()
	{
		return col;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}

	public int getWidth()
	{
		return width;
	}
	
	public void move(SnakeLeader s)
	{
		xPos = s.getX();
		yPos = s.getY();
	}
	
	public void moveSnake(Snake s)
	{
		xPos = s.getX();
		yPos = s.getY();
	}
}
