import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SnakeLeader
	implements KeyListener
{
	private int xPos, yPos, dir, width;
	
	public SnakeLeader(int x, int y, int dir, int w) // 1-up, 2-right, 3-down, 4-left
	{
		xPos = x;
		yPos = y;
		this.dir = dir;
		width = w;
	}
	
	public void move() //too fast, slow fram rate. use timer
	{
		if (dir == 4)
		{
			xPos-= 10;
		}
		
		if (dir == 3)
		{
			yPos+=10;
		}
		
		if (dir == 2)
		{
			xPos+=10;
		}
		
		if (dir == 1)
		{
			yPos-=10;
		}
	}
	
	public boolean suicide(SnakeLeader sL, Snake s)
	{
		if(sL.getX() == s.getX() && sL.getY() == s.getY())
			return true;
		else
			return false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT && dir != 2)
		{
			dir = 4;
		}
		
		if (key == KeyEvent.VK_RIGHT && dir !=4)
		{
			dir = 2;
		}
		
		if (key == KeyEvent.VK_UP && dir != 3)
		{
			dir = 1;
		}
		
		if (key == KeyEvent.VK_DOWN && dir != 1)
		{
			dir = 3;
		}
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
	
	public int getDirec()
	{
		return dir;
	}
	
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
}
