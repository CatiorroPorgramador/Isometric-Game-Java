package src;

import javax.swing.JFrame;
import javax.imageio.ImageIO;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.image.BufferStrategy;

public class App extends Canvas implements Runnable, MouseListener {
	BufferStrategy bufferstrategy;
	Graphics graphics;

	public App() {
		setFocusable(true);
		setPreferredSize(new Dimension(840, 680));

		addMouseListener(this);
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

		graphics = bufferstrategy.getDrawGraphics();
		graphics.setColor(Color.gray);
		graphics.fillRect(0, 0, 840, 680);
		graphics.setColor(Color.black);
		graphics.drawString("mov eax, 0", 50, 50);

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