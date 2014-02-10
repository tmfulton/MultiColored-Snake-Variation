import java.awt.Color;


public class Food
{
	private int x,y,w;
	private Color col;
	
	public Food(int w)
	{
		this.x = ((int)((Math.random() * 49) + 1))*10;
		this.y = ((int)((Math.random() * 47) + 1))*10;
		this.w = w;
		col = new Color((int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1));
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return w;
	}
	
	public Color getColor()
	{
		return col;
	}
	
	public void move()
	{
		x = ((int)((Math.random() * 49) + 1))*10;
		y = ((int)((Math.random() * 47) + 1))*10;
		col = new Color((int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1));
		checkColor();
	}
	
	public void checkColor()
	{
		int colR = col.getRed();
		int colB = col.getBlue();
		int colG = col.getGreen();
		while (colR >= 205 && colB >= 205 && colG >= 205)
		{
			col = new Color((int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1));
			System.out.print("New Color");
		}
	}
	
}
