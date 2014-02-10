import java.awt.Color;


public class Poison
{
	private int x,y,w;
	private Color col;
	
	public Poison(int w)
	{
		this.x = ((int)((Math.random() * 49) + 1))*10;
		this.y = ((int)((Math.random() * 47) + 1))*10;
		this.w = w;
		this.col = new Color(255,255,255);
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
	
	public void move()
	{
		x = ((int)((Math.random() * 49) + 1))*10;
		y = ((int)((Math.random() * 47) + 1))*10;
	}
}
