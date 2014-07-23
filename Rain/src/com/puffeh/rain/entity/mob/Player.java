package com.puffeh.rain.entity.mob;

import com.puffeh.rain.Game;
import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.input.Keyboard;
import com.puffeh.rain.input.Mouse;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;

	}

	public void update() {
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		int xa = 0, ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		updateShooting();
	}

	private void updateShooting() {

		if (Mouse.getButton() == 1) {
			double dx = Mouse.getX() - Game.getWindowWidth()/2;
			double dy = Mouse.getY() - Game.getWindowHeight()/2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {

		if (dir == 0) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else {
					sprite = Sprite.player_right_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_forward_1;
				} else {
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else {
					sprite = Sprite.player_left_2;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite);

	}

}
