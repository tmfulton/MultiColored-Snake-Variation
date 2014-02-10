
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.Timer;

public class SnakeMain extends JApplet
	implements ActionListener, MouseListener
{

	private int score = 0;
	private Food food;
	private SnakeLeader head;
	private ArrayList<Snake> snake;
	private Timer time;
	private int game = 0;// 0 for start, 1 for play, 2 for gameover
	
	public void init()
	{
		setSize(501,500);
		head = new SnakeLeader(20,250,2,10);
		food = new Food(10);
		snake = new ArrayList<Snake>();
		snake.add(new Snake(10,250,10,new Color((int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1))));
		snake.add(new Snake(0,250,10,new Color((int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1),(int)((Math.random() * 255) + 1))));
		this.addKeyListener(head);
		this.addMouseListener(this);
		setFocusable(true);
	}
	
	public void start()
	{
		time = new Timer(50, this);// double buffer to make smoother
	}
	
	public void restart()
	{
		init();
		score = 0;
		game = 1;
		time.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (game == 0)
		{
			g.drawString("Snake!", 240, 240);
			g.drawString("Click to begin playing!", 190, 255);
		}
		
		else if (game == 2)
		{
			g.drawString("Gameover! Press restart to play again", 130, 240);
			g.drawString("You got " + score + " points!", 195, 255);
		}
		
		else if (game == 1)
		{
			g.setColor(Color.BLACK);
			g.drawRect(0, 0, 500, 480);
			g.setColor(food.getColor());
			g.fillRect(food.getX(), food.getY(), food.getWidth(), food.getWidth());
			g.setColor(Color.BLACK);
			g.fillRect(head.getX(), head.getY(), head.getWidth(), head.getWidth());	
			g.setColor(snake.get(0).getColor());
			g.fillRect(snake.get(0).getX(), snake.get(0).getY(), snake.get(0).getWidth(), snake.get(0).getWidth());
			g.setColor(snake.get(1).getColor());
			g.fillRect(snake.get(1).getX(), snake.get(1).getY(), snake.get(0).getWidth(), snake.get(0).getWidth());
			
			if (score != 0)
			{
				for(int i = snake.size()-1; i > 1; i--)
				{
					g.setColor(snake.get(i).getColor());
					g.fillRect(snake.get(i).getX(), snake.get(i).getY(), snake.get(i).getWidth(), snake.get(i).getWidth());
					snake.get(i).moveSnake(snake.get(i-1));
					if(head.suicide(head,snake.get(i)))
						game = 2;
				}
			}
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 500, 480);
		g.drawString("Score:" + score, 10, 495);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		snake.get(1).moveSnake(snake.get(0));
		snake.get(0).move(head);
		head.move();
		
		if(head.getX() == food.getX() && head.getY() == food.getY())
		{
			snake.add(new Snake(food.getX(),food.getY(),10,food.getColor()));
			food.move();
			score+= 10;
		}
		
		if(head.getX() + head.getWidth() > 500 || head.getY() + head.getWidth() > 480 || head.getX() < 0 || head.getY() < 0)
		{
			time.stop();
			game = 2;
		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(game == 0)
		{
			game = 1;
			time.start();
		}
		else if (game == 2)
		{
			restart();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
	