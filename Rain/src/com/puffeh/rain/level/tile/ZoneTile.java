package com.puffeh.rain.level.tile;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;

public class ZoneTile extends Tile {

	public ZoneTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}


	public boolean exit(){
		return true;
	}
}
