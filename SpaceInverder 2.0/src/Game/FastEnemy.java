package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
	
	
	public Handler handler;
	
	public FastEnemy(int x, int y, int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 5;
		velY = 9;
		
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16)velX *= -1;
					
	}

	
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 16, 16);
		
		
	}

	@Override
	public void changeEnemy() {
		// TODO Auto-generated method stub
		
	}

}
