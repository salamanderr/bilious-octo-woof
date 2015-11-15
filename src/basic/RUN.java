package basic;

import resources.Reader;
import resources.Writer;
import resources.Formatter;
import javax.swing.JOptionPane;

public class RUN{
	public static void main(String[]args){
		Reader con = new Reader();
		Writer save = new Writer("save.dat");
		Reader saveReader = new Reader("save.dat");
		
		String asdf = JOptionPane.showInputDialog("NEW for a new game, LOAD for a saved game. DONT USE LOAD IF THERE IS NO SAVED FILE. ITS BROKEN LOL");
		String name = "";

		Player one = new Player(name);
		
		
		if(asdf.equalsIgnoreCase("new")){							
			name = JOptionPane.showInputDialog("Please enter your name");
			/*
			 * if the player chooses to create a new game, the program uses JOptionPane to prompt for a new name for the save.
			 */
		}
		
		if(asdf.equalsIgnoreCase("load")){
			name = saveReader.readWord();
			int level = saveReader.readInt();
			double damage = saveReader.readDouble();
			double armor = saveReader.readDouble();
			double health = saveReader.readDouble();
			int xp = saveReader.readInt();
			int gold = saveReader.readInt();
			
			one.loadSave(name, level, damage, armor, health, xp, gold);
			
			/*
			 * if player chooses to load a game, the program uses the saveReader object to read the saved data.
			 */
		}
		
		boolean done = false;
		
		while(!done){
			System.out.println("N : New Floor");
			System.out.println("A: Armor Shop");
			System.out.println("Q: Save and quit");
			String input = con.readWord();
			
			if(input.equalsIgnoreCase("Q")){
				save.println(one.getName() + " " + one.getLevel() + " " + one.getDamage() + " " + one.getArmor() + " " + one.getHealth() + " " + one.getXP() + " " + one.getGold());
				
				/*
				 * This should create a file called save.dat in the project folder, that can be read later for loading a game.
				 */
			}
		}
	}
}
