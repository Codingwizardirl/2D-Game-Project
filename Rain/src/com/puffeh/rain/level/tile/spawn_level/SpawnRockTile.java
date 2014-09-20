package com.puffeh.rain.level.tile.spawn_level;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.level.tile.Tile;

public class SpawnRockTile extends Tile {

	public SpawnRockTile(Sprite sprite) {
		super(sprite);
		
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}
	
	public boolean solid(){
		return true;
		}
}
