package main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import entidades.Crab;
import world.World;

import graficos.Spritesheet;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	
	public static int WIDTH = 480;
	public static int HEIGHT = 480;
	
	public static Spritesheet spritesheet;
	public static Crab crab;
	public static World world;
	
	
	public Game() {
		addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		spritesheet = new Spritesheet("/spritesheet.png");
		crab = new Crab(0, 0);
		world = new World("/level1.png");
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		JFrame frame = new JFrame();
		frame.setTitle("Pegue o carangueijo!");
		frame.add(game);
		frame.setResizable(false);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		new Thread(game).start();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		world.render(g);
		
		g.setColor(Color.black);
		g.fillOval((HEIGHT/2 - 35), (WIDTH/2 - 35), 70, 70);
		
		crab.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void tick() {
		crab.tick();
	}

	@Override
	public void run() {
		requestFocus();
		double fps = 60.0;
		while(true) {
			tick();
			render();
			try {
				Thread.sleep((int)(1000/fps));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
