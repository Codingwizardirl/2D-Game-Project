package com.puffeh.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.puffeh.rain.Game;
import com.puffeh.rain.entity.mob.Dummy;
import com.puffeh.rain.entity.mob.Player;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception!Could not load level file!");
		}

		// add(new Chaser(22, 55));
		// add(new Star(17,55));
		// add(new Shooter(20, 55));

		for (int i = 0; i < 5; i++) {
			add(new Dummy(15, 53));

		}

	}

	// Grass = 0xFF00FF00
	// Flower = 0xFFFFFF00
	// Rock = 0xFF7F7F00
	protected void generateLevel() {

	}

	public void checkExits(Player player, Level level, int x, int y) {
		// 16,3- The coordinates of the ZoneTile in the level.
		// System.out.println("Location:"+x+","+y);
		refresh();
		Game.getGame().setLevel(new ValleyLevel(Maps.valley_level));
		level = Game.getGame().getLevel();
		level.add(player);

		player.setPosition(new TileCoordinate(85, 188));

	}
}
