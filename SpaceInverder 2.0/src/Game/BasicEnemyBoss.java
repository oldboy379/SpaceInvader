package Game;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



public class BasicEnemyBoss extends GameObject{
	
	public Handler handler;
	
	private BufferedImage enemy_image;
	
	public BasicEnemyBoss(int x, int y,  int life, ID id, Handler handler) {
		super(x, y, life, id);
		this.handler = handler;
		
		velX = 3;
		
		
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(1, 1, 50, 41);
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 50, 41);
	}
	
	
	public void tick() {
		
		
		
		x += velX;
		if (y <= 0 || y >= Game.HEIGHT - 32)velY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 16) {
			velX *= -1;
			y += 40;
			
		}
		try {
			collision();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
	}


	public void collision() throws Exception {
		

		for (int i = 0; i < handler.player.getLenght(); i++) {
			
			GameObject tempObject = handler.player.getData(i);
			
			if (tempObject.getId() == ID.Bullet) {
				if (getBounds().intersects(tempObject.getBounds())) {
					setLife(1);
					handler.player.deleteBulletCol();
				}
				
			}
		}
		
			
		
	}
	
	public ID getID() {
		return id;
	}
	
	public void render(Graphics g) {
		g.drawImage(enemy_image, x, y, null);
		
		
	}

	@Override
	public void changeEnemy() {
		// TODO Auto-generated method stub
		
	}

}
