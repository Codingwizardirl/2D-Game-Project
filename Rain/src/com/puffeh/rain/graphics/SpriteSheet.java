package com.puffeh.rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public final int WIDTH, HEIGHT;
	public int[] pixels;
	
	
	public static SpriteSheet tiles_animated= new SpriteSheet("/textures/sheets/tiles_animated.png",256);
	public static SpriteSheet grass_anim= new SpriteSheet(tiles_animated,0,0,3,1,16);
	public static SpriteSheet water_anim= new SpriteSheet(tiles_animated,0,1,4,1,16);

	public static SpriteSheet tiles = new SpriteSheet("/textures/sheets/spritesheet.png", 256);
	public static SpriteSheet spawn_level = new SpriteSheet("/textures/sheets/spawn_level.png", 48);
	public static SpriteSheet projectile_wizard = new SpriteSheet("/textures/sheets/projectiles/wizard.png", 48);
	public static SpriteSheet zone_tiles= new SpriteSheet("/textures/sheets/zone_tiles.png", 48);

	public static SpriteSheet player = new SpriteSheet("/textures/sheets/player_sheet.png", 96, 128);
    public static SpriteSheet player_down = new SpriteSheet(player,0,0,3,1,32);
	public static SpriteSheet player_up = new SpriteSheet(player,0,3,3,1,32);
	public static SpriteSheet player_left = new SpriteSheet(player,0,1,3,1,32);
	public static SpriteSheet player_right = new SpriteSheet(player,0,2,3,1,32);
	
	
	public static SpriteSheet dummy = new SpriteSheet("/textures/sheets/npc_sheet.png", 96, 128);
	public static SpriteSheet dummy_down = new SpriteSheet(dummy,0,0,3,1,32);
	public static SpriteSheet dummy_up = new SpriteSheet(dummy,0,3,3,1,32);
	public static SpriteSheet dummy_left = new SpriteSheet(dummy,0,1,3,1,32);
	public static SpriteSheet dummy_right = new SpriteSheet(dummy,0,2,3,1,32);
	
	
	
	private Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height,
			int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		
		if (width == height)
			SIZE = width;
		else
			SIZE = -1;
		
		WIDTH = w;
		HEIGHT = h;

		pixels = new int[w * h];
		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}
		int frame=0;
		sprites = new Sprite[width * height];
		for(int ya=0;ya<height;ya++){
			for(int xa=0;xa<width;xa++){
				int[] spritePixels= new int [spriteSize*spriteSize];
				for(int y0= 0; y0<spriteSize; y0++){
					for(int x0= 0; x0<spriteSize; x0++){
						spritePixels[x0+y0*spriteSize]=pixels[(x0+xa*spriteSize)+(y0+ya*spriteSize)*WIDTH];
						
					}
				}
				Sprite sprite=new Sprite(spritePixels,spriteSize,spriteSize);
				sprites[frame++]=sprite;
			}			
		}
	}

	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		WIDTH = size;
		HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load();

	}
	
	public Sprite[] getSprites(){
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class
					.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
