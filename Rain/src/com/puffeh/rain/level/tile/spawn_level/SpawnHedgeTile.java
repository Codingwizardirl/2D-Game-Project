package com.puffeh.rain.level.tile.spawn_level;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}

	public boolean solid(){
	return true;
	}
	
	public boolean breakable(){
		return true;
	}
}
