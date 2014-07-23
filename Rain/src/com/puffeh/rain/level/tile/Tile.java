package com.puffeh.rain.level.tile;

import com.puffeh.rain.graphics.Screen;
import com.puffeh.rain.graphics.Sprite;
import com.puffeh.rain.level.tile.spawn_level.SpawnFloorTile;
import com.puffeh.rain.level.tile.spawn_level.SpawnGrassTile;
import com.puffeh.rain.level.tile.spawn_level.SpawnHedgeTile;
import com.puffeh.rain.level.tile.spawn_level.SpawnRockTile;
import com.puffeh.rain.level.tile.spawn_level.SpawnWallTile;
import com.puffeh.rain.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass= new GrassTile(Sprite.grass);
	public static Tile flower= new FlowerTile(Sprite.flower);
	public static Tile rock= new RockTile(Sprite.rock);
	public static Tile voidTile= new VoidTIle(Sprite.voidSprite);

	public static Tile spawn_grass= new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge= new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_rock= new SpawnRockTile(Sprite.spawn_rock);
	public static Tile spawn_flower= new SpawnGrassTile(Sprite.spawn_flower);
	public static Tile spawn_dirt= new SpawnGrassTile(Sprite.spawn_dirt);
	public static Tile spawn_water= new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall= new SpawnWallTile(Sprite.spawn_wall);
	public static Tile spawn_floor= new SpawnFloorTile(Sprite.spawn_floor);
	
	
	
	public final static int col_spawn_grass = 0xFF0AFF00;
	public final static int col_spawn_hedge = 0xFF007F0E;
	public final static int col_spawn_rock = 0xFF808080;
	public final static int col_spawn_flower = 0xFFFFD800;
	public final static int col_spawn_dirt = 0xFFFF6A00;   
	public final static int col_spawn_water = 0xFF0094FF;
	public final static int col_spawn_wall = 0xFF000000;
	public final static int col_spawn_floor = 0xFF7F3300;
	
	
	
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
		
	}

	public boolean solid() {
		return false;
	}
}
