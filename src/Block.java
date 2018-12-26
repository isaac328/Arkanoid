import processing.core.*;

public class Block 
{
	PApplet p;
	PVector pos;
	int width;
	int height;
	boolean hit;
	
	public Block(PApplet p, int x, int y, int width, int height)
	{
		this.p = p;
		pos = new PVector(x,y);
		this.width = width;
		this.height = height;
		hit = false;
	}
	
	public void update()
	{
		
	}
	
	public void show()
	{
		if(hit == false)
			p.rect(pos.x, pos.y, width, height);
		else
		{
			width = 0;
			height = 0;
			pos.x = 0;
			pos.y = 0;
		}
	}
}
