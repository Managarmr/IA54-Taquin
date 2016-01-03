package utbm.ia54.projet.gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import utbm.ia54.projet.util.EcoNPuzzleUtils;

public class EcoNPuzzleGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1439108651892406386L;
	private static int cellSize = 64;
	private static int windowOffset = 28;
	private Panel panel;
	
	private Timer timer = new Timer(100, this);
	
	public EcoNPuzzleGUI(String title) {
		super(title);
		
		// Initialize
		int size = EcoNPuzzleUtils.getSize();
		
		// Init context
		setVisible(true);
		setSize(size*cellSize+1,size*cellSize+windowOffset+1);
		setMinimumSize(getSize());
		setBackground(Color.lightGray);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		// Panel
		panel = new Panel();
		BoxLayout mainLay = new BoxLayout(getContentPane(),BoxLayout.Y_AXIS);
		setLayout(mainLay);
		this.add(panel);
	
		// Start the timer
		timer.start();
	}	

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == timer) {
			panel.repaint();
	    }
	}

	public static class Panel extends JPanel {
		
		private static final long serialVersionUID = -3490254537111921165L;

		public Panel() {
			
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
		    
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
		    		int agress = EcoNPuzzleUtils.getAgress(x, y);
		    		int leader = EcoNPuzzleUtils.getLeader();
		    		int blankTile = EcoNPuzzleUtils.getBlankTile();
		    		
		    		// Draw cell
		    		if(leader == v)
		    			g.setColor(Color.BLUE);
		    		else if(blankTile == v)
		    			g.setColor(Color.WHITE);
		    		else if(agress == 1)
		    			g.setColor(Color.RED);
		    		else
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
	}
}