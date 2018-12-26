import processing.core.*;

public class Paddle 
{
	PApplet p;
	PVector pos;
	PVector vel;
	PVector acc;
	
	int height = 30;
	int width = 200;
	
	public Paddle(PApplet p)
	{
		this.p = p;
		pos = new PVector(p.width/2, p.height-80);
		vel = new PVector(0,0);
		acc = new PVector(0,0);
	}
	
	public void show()
	{
		p.stroke(255);
		p.fill(255);
		p.rect(pos.x, pos.y, width, height);
	}
	
	public void update()
	{
		vel.add(acc);
		pos.add(vel);
		vel.limit(4);
		if(p.keyPressed)
		{
			if(p.key == 'a')
			{
				acc.add(-.2f, 0);
			}
			if(p.key == 'd')
			{
				acc.add(.2f,0);
			}
		}
		else
		{
			if(vel.x > 1)
			{
				acc.add(-0.50f,0);
			}
			else if(vel.x < -1)
			{
				acc.add(0.5f, 0);
			}
			else
			{
				acc.x = 0;
				vel.x = 0;
			}
				
				
		}
		
		checkBounds();
	}
	
	public void checkBounds()
	{
		if(pos.x + width > p.width || pos.x < 0)
		{
			vel.mult(0);
			acc.mult(0);
			if(pos.x + width > p.width)
				pos.x = p.width - width;
			else
				pos.x = 1;
		}
	}
}
