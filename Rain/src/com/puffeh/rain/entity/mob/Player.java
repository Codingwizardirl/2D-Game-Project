package com.puffeh.rain.entity.mob;

import com.puffeh.rain.Game;
import com.puffeh.rain.entity.projectile.Projectile;
import com.puffeh.rain.entity.projectile.WizardProjectile;
import com.puffeh.rain.graphics.AnimatedSprite;
import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.graphics.SpriteSheet;
import com.puffeh.rain.input.Keyboard;
import com.puffeh.rain.input.Mouse;
import com.puffeh.rain.level.TileCoordinate;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private boolean walking = false;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3,5);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3,5);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3,5);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3,5);

	private AnimatedSprite animSprite = up;

	private int fireRate = 0;
	private int tileX;
	private int tileY;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
		animSprite = up;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public void update() {
		tileX = (int) x >> 4;
		tileY = (int) y >> 4;
		if (level.getTile(tileX, tileY).exit()) level.checkExits(this, level, tileX, tileY);
		if (walking) animSprite.update();
		else animSprite.setFrame(1);
		if (fireRate > 0) fireRate--;
		input.update();

		double xa = 0, ya = 0;
		double speed = 1.4;
		if (input.up) {
			animSprite = up;
			ya -= speed;
		} else if (input.down) {
			animSprite = down;
			ya += speed;
		}
		if (input.left) {
			animSprite = left;
			xa -= speed;
		} else if (input.right) {
			animSprite = right;
			xa += speed;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) level.getProjectiles().remove(i);
		}

	}

	private void updateShooting() {

		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int) (x - 16), (int) (y - 16), sprite);

	}

	public void setPosition(TileCoordinate tileCoordinate) {
		this.x = tileCoordinate.x();
		this.y = tileCoordinate.y();

	}

}
