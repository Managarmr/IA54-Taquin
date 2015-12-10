package utbm.ia54.projet.gui;

public class EcoNPuzzleLauncher {

	// This static method is called by the PuzzleCreator agent to create the GUI
	public static void launchInterface(){
		
      // Run the GUI construction on the event-dispatching thread for thread safety
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new EcoNPuzzleGUI("Eco NPuzzle Solver"); // Let the constructor do the job
         }
      });
		
	}
}
