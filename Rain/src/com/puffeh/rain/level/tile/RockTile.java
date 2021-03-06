package com.puffeh.rain.level.tile;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
		
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}
	
	public boolean solid() {
		return true;
	}
}
