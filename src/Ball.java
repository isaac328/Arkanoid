import processing.core.*;

public class Ball 
{
	PApplet p;
	PVector pos;
	PVector vel;
	
	public Ball(PApplet p)
	{
		this.p = p;
		pos = new PVector(p.width/2,p.height/2);
		vel = new PVector(2,10);
		
	}
	
	public void show()
	{
		p.ellipse(pos.x, pos.y, 10, 10);
	}
	
	public void update()
	{
		pos.add(vel);
		checkWalls();
	}
	
	public void checkWalls()
	{
		if(pos.x < 0 || pos.x > p.width)
		{
			vel.x = -vel.x;
		}
		if(pos.y < 0 || pos.y >= p.height)
		{
			vel.y = -vel.y;
		}
	}
	
	public void checkPaddle(Paddle pad)
	{	
		float position = pos.x - pad.pos.x;
		float newVel = p.map(position, 0, pad.width, -5, 5);
		
		if(pos.x >= pad.pos.x && pos.x <= pad.pos.x + pad.width)
		{
			if(pos.y > pad.pos.y && pos.y <= pad.pos.y + pad.height)
			{
				vel.y*=-1;
				vel.x = newVel;
			}
		}
	}
}
