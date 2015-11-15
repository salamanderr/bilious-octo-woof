package basic;

import resources.Reader;
import resources.Writer;
import resources.Formatter;
import javax.swing.JOptionPane;

public class RUN{
	public static void main(String[]args){
		Writer save = new Writer("save.dat");
		Reader saveReader = new Reader("save.dat");
		
		String asdf = JOptionPane.showInputDialog("NEW for a new game, LOAD for a saved game. DONT USE LOAD IF THERE IS NO SAVED FILE. ITS BROKEN LOL");
		String name = "";

		/*
		 * if the player chooses to create a new game, the program uses JOptionPane to prompt for a new name for the save.
		 */
		
		if(asdf.equalsIgnoreCase("new")){							
			name = JOptionPane.showInputDialog("Please enter your name");
		}
		
		/*
		 * if player chooses to load a game, the program uses the saveReader object to read the saved data.
		 */
		
		if(asdf.equalsIgnoreCase("load")){
			name = saveReader.readWord();
		}
		
		Player one = new Player(name);
		
		boolean done = false;
		
		while(!done){
			
		}
	}
}
