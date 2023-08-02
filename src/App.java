package src;

import javax.swing.JFrame;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;

import src.Engine.Scene;
import src.Scenes.Gameplay;

public class App extends Canvas implements Runnable, MouseListener {
	BufferStrategy bufferstrategy;
	Graphics2D graphics;

	Scene current_scene;

	BufferedImage tiles_texture;
	Image test;

	public App() {
		this.setFocusable(true);
		this.setPreferredSize(new Dimension(840, 680));

		addMouseListener(this);

		// Loads
		try {
			tiles_texture = ImageIO.read(new File("data\\tiles-sheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		test = tiles_texture.getSubimage(0, 0, 16, 16);
	}

	void Update() {
		
	}

	void Render() {
		bufferstrategy = this.getBufferStrategy();

		if (bufferstrategy == null) {
			this.createBufferStrategy(3);
			System.out.println("CREATE BUFFER");
			return;
		}

		graphics = (Graphics2D) bufferstrategy.getDrawGraphics();
		graphics.drawImage(test, 0, 0, 60, 60, null);

		bufferstrategy.show();
	}

	public static void main(String[] args) {
		App app = new App();
		JFrame window = new JFrame("Isometric Game - Java Version");
		window.add(app);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		new Thread(app).start();
	}

	@Override
	public void run() {
		while (true) {
			Update();
			Render();
			try 
			{ Thread.sleep(1000/60); }
			
			catch (InterruptedException e)
			{ e.printStackTrace(); }
		}
	}

	@Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Pos: "+e.getX());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
  
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        return;   
    }

    @Override
    public void mouseExited(MouseEvent e) {
        return;
    }
}