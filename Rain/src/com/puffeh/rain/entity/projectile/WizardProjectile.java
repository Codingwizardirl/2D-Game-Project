package com.puffeh.rain.entity.projectile;

import com.puffeh.rain.entity.spawner.ParticleSpawner;
import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.level.Level;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 5;// Higher int= slower rate of fire;

	public WizardProjectile(double x, double y, double dir) {
		super(x, y, dir);
		range = 200;
		speed = 4;
		damage = 20;
		sprite = Sprite.projectile_wizard;

		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision((int) (x + nx), (int) (y + ny), 6, 6, 4)) {
			level.add(new ParticleSpawner((int) x, (int) y, 44, 50, level));
			remove();
		}
		move();
		
		//Kill Mobs method:NOT POLISHED!!
		/*for (int i = 0; i < Level.entities.size(); i++) {
	         if (x < Level.entities.get(i).getX() +12
	            && x > Level.entities.get(i).getX() -12
	            && y <  Level.entities.get(i).getY() +12
	            && y >  Level.entities.get(i).getY() -12
	            ) {
	            remove();
	            //Level.entities.get(i).health -= 1; when I add health
	            
	         }*/
	      }
	

	protected void move() {
		x += nx;
		y += ny;
		if (distance() > range)
			remove();

	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs(((xOrigin - x) * (xOrigin - x))
				+ ((yOrigin - y) * (yOrigin - y))));
		return dist;
	}

	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this);
	}

}
