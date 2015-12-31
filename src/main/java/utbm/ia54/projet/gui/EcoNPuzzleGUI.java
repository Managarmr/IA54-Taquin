package utbm.ia54.projet.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;

import utbm.ia54.projet.util.EcoNPuzzleUtils;

public class EcoNPuzzleGUI extends JFrame {
	
	private static final long serialVersionUID = -1436701208810625113L;
	private int cellSize = 64;
	private int windowOffset = 30;
	
	public EcoNPuzzleGUI(String title) {
		super(title);
		
		// Initialize
		int size = EcoNPuzzleUtils.getSize();
		
		//
		setVisible(true);
		setSize(size*cellSize+1,size*cellSize+windowOffset+1);
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		new Thread(new Runner()).start();
	}	
	
	public void paint(Graphics g) {
	    super.paint(g);
	    
	    g.translate(0, windowOffset);
	    
	    // Protection if not initialize
	    if(!EcoNPuzzleUtils.isInit())
	    	return;
	    
	    // Get board size
	    int size = EcoNPuzzleUtils.getSize();
	    
	    // Draw grid
	    for(int i=0; i<size; ++i)
	    	g.drawLine(i*cellSize, 0, i*cellSize, size*cellSize);
	    for(int i=0; i<size; ++i)
	    	g.drawLine(0, i*cellSize, size*cellSize, i*cellSize);
	    
	    // Draw cell
	    for(int x=0; x<size; ++x) {
	    	for(int y=0; y<size; ++y) {
	    		// Get cell value 
	    		int v = EcoNPuzzleUtils.getBoard(x, y);
	    		
	    		// Draw cell
	    		//g.setColor(new Color((int) (Math.random()*120), (int) (Math.random()*120), (int) (Math.random()*120)));
	    		g.setColor(Color.DARK_GRAY);
	    		g.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
	    		g.setColor(Color.BLACK);
	    		g.drawRect(x*cellSize, y*cellSize, cellSize, cellSize);
	    		
	    		// Draw text centered
	    		String text = ""+v;
	    		FontMetrics fm = g.getFontMetrics();
	    		int posx = (x*cellSize+(x+1)*cellSize - fm.stringWidth(text)) / 2;
	            int posy = ((y*cellSize+(y+1)*cellSize - fm.getHeight()) / 2) + fm.getAscent();
	            g.setColor(Color.WHITE);
	            g.drawString(text, posx, posy);
	    	}
	    }
	}
	
	// Runner
	class Runner implements Runnable {
        @Override
        public void run() 
        {
            while(true)
            {
            	// Update GUI
            	repaint();
                try 
                {
                    // Refresh
                    Thread.sleep(200);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}