package graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Tile {

	public static BufferedImage TILE_SAND = Game.spritesheet.getSprite(0, 0, 40, 40);

	private BufferedImage sprite;
	private int x, y;
	
	public Tile(BufferedImage sprite, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {
		g.drawImage(sprite, x, y, null);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}
