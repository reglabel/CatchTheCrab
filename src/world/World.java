package world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.Game;

import graficos.Tile;

public class World {
	
	public static Tile[] tiles;
	public static int WIDTH, HEIGHT;
	public static final int TILE_SIZE = 16;

	public World(String path) {		
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGHT = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for(int yy = 0; yy < map.getHeight(); yy++) {
					//int pixelAtual = pixels[xx + (yy*map.getWidth())];
					tiles[xx + (yy * WIDTH)] = new Tile(Tile.TILE_SAND, xx*TILE_SIZE, yy*TILE_SIZE);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} //mapa manual
	}
	
	public void render(Graphics g) {
		int xStart = 0;
		int yStart = 0;
		
		int xFinal = xStart + (Game.WIDTH);
		int yFinal = yStart + (Game.HEIGHT);
		
		for(int xx = xStart; xx <= xFinal; xx++) {
			for(int yy = yStart; yy <= yFinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT) {
					continue;
				}
				
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
	
	public Tile[] getTiles() {
		return tiles;
	}

}
