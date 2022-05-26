package entidades;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;

public class Crab{
	public BufferedImage crabFront = Game.spritesheet.getSprite(40, 0, 40, 40);
	public double dx, dy;
	public int x, y;
	public double spd = 4;
	protected int frames, maxFrames, index, maxIndex;
	
	public Crab(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		g.drawImage(crabFront, x, y, null);
		//g.setColor(Color.red);
		//g.fillRect(x, y, 40, 40);
	}
	
	public void tick() {
		x++;
		y++;
	}
	
	public void setSeqAnimation(int frames, int maxFrames, int index, int maxIndex) {
		this.frames = frames;
		this.maxFrames = maxFrames;
		this.index = index;
		this.maxIndex = maxIndex;
	}
	
	protected void animar() {
		frames++;
		if(frames == maxFrames) {
			frames = 0;
			index++;
			if(index > maxIndex) {
				index = 0;
			}
		}
	}
	
}
