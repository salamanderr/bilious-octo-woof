package basic;

import resources.Reader;
import resources.Writer;
import javax.swing.JOptionPane;
import resources.ActionPane;
/*
 * ActionPane is a class created by a friend of mine that extends JOptionPane to be a button menu. It's kind of
 * spaghetti but until I can create my own, it works OK.
 */
public class RUN{
	public static void main(String[]args){
		Reader con = new Reader();
		Writer save = new Writer("D:\\Java\\bilious-octo-woof\\save.dat");
		Reader saveReader = new Reader("D:\\Java\\bilious-octo-woof\\save.dat");
		
		ActionPane load = new ActionPane("Name Placeholder", "Choose an option to start").addPane("Load").addPane("New");
		load.run();
		
		String asdf = load.getResult();
		String name = "";

		Player one = new Player(name);
		
		
		if(asdf.equalsIgnoreCase("new")){							
			name = JOptionPane.showInputDialog("Please enter your name");
			one = new Player(name);
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
			ActionPane prompt = new ActionPane("Basic Menu", "Choose an option").addPane("Next Run").addPane("Stats").addPane("Armory").addPane("Quit");
			prompt.run();
			String input = prompt.getResult();
			
			if(input.equalsIgnoreCase("Quit")){
				save.print(one.getName() + " ");
				save.print(one.getLevel() + " ");
				save.print(one.getDamage() + " ");
				save.print(one.getArmor() + " ");
				save.print(one.getHealth() + " ");
				save.print(one.getXP() + " ");
				save.print(one.getGold());
				done = true;
				/*
				 * This should create a file called save.dat in the project folder, that can be read later for loading a game.
				 * 					!!! DOESN'T WORK ATM, WRITER IS BROKEN !!!
				 */
			}
			if(input.equalsIgnoreCase("Stats")){
				System.out.println("Name: " + one.getName());
				System.out.println("Level: " + one.getLevel());
				System.out.println("Damage: " + one.getDamage());
				System.out.println("Armor: " + one.getArmor());
				System.out.println("Health: " + one.getHealth());
			}
			if(input.equalsIgnoreCase("Next Run")){
				boolean dead = false;
				int i = 1;
				if(i % 10 != 0){
					while(!dead){
						Enemy a1 = new Enemy(one);
						ActionPane atk = new ActionPane("Floor: " + i + "HP: " + one.getHealth(), "Enemy HP: " + a1.getHealth()).addPane("Attack");
						atk.run();
						String qw = atk.getResult();
						if(qw.equalsIgnoreCase("Attack")){
							a1.takeDamage(one.getDamage());
						}
						if(a1.getHealth() > 0){
							one.takeDamage(a1.getDamage());
						}
						if(one.getHealth() <= 0){
							dead = true;
						}
					}
				}
				else{
					/*
					 * Boss floor every 10 floors. Gonna create a Boss class eventually. I really like the word 'eventually', huh?
					 */
				}
			}
		}
	}
}
