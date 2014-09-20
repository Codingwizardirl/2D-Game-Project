package com.puffeh.rain.level.tile.spawn_level;

import com.puffeh.rain.graphics.AnimatedSprite;
import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.level.tile.Tile;

public class AnimatedTile extends Tile {

	private Sprite tile;
	private AnimatedSprite sprite_anim;
	private boolean solid;

	public AnimatedTile(AnimatedSprite sprite, boolean solid) {
		super(sprite);
		this.solid = solid;
		sprite_anim = sprite;
	}

	public void update() {
		sprite_anim.update();
	}

	public void render(int x, int y, Screen screen) {
		tile = sprite_anim.getSprite();
		screen.renderTile(x << 4, y << 4, tile);
	}

	public boolean solid() {
		return (solid) ? true : false;
	}
}
