import processing.core.*;
public class Pong extends PApplet
{

	Ball ball;
	Paddle player1;
	Block[][] blocks;
	int blockW = 60;
	int blockH = 35;
	
	public static void main(String[] args) 
	{
		PApplet.main("Pong");
	}
	
	public void settings()
	{
		size(1200,800, P2D);
	}
	
	public void setup()
	{
		background(0);
		colorMode(HSB);
		player1 = new Paddle(this);
		ball = new Ball(this);
		blocks = new Block[width/blockW][(height/3)/blockH];
		for(int x = 0; x < blocks.length; x++)
		{
			for(int y = 0; y < blocks[x].length; y++)
			{
				blocks[x][y] = new Block(this,x*(blockW), y*(blockH), blockW-3, blockH-3);
			}
		}
	}
	
	public void draw()
	{
		background(0);
		player1.show();
		player1.update();
		ball.show();
		ball.update();
		ball.checkPaddle(player1);
		
		for(int x = 0; x < blocks.length; x++)
		{
			for(int y = 0; y < blocks[x].length; y++)
			{
				stroke(0);
				fill(255);
				blocks[x][y].show();
				if(ball.pos.x >= blocks[x][y].pos.x && ball.pos.x <= blocks[x][y].pos.x + blockW)
				{
					if(ball.pos.y >= blocks[x][y].pos.y && ball.pos.y <= blocks[x][y].pos.y + blockH)
					{
						fill(0, 255, 255, 255);
						blocks[x][y].hit = true;
						blocks[x][y].show();
						ball.vel.y *= -1;
					}
				}
			}
		}
		
		
	}
}
