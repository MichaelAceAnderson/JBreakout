import java.io.File;

import javax.swing.SwingUtilities;

import display.view.GameFrame;
import game.Game;
import game.type.breakout.Breakout;

public class Main {
    public static void main(String [] args){
		
		// Create the game frame asynchonously (not immediately)
		// in a separate thread
        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GameFrame gameFrame = new GameFrame();
				// Create the game and attach it to the frame
				Game game = new Breakout(gameFrame);
				game.start();
			}
		});
		System.out.println(Breakout.ASSETS_PATH + "images" + File.separator + "entities" + File.separator + "ball.png");
    }
}
