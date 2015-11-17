package basic;

/*
 * This is the main enemy object class. This is quite similar to the Player object, but with less options.
 */

public class Enemy{
	private int level;
	private double damage;
	private double health;
	private int goldValue;
	private int xpValue;
	
	public Enemy(Player a1){
		level = a1.level;
		damage = level * 2;
		health = 10 + (level * 2);
		goldValue = level;
		xpValue = (level * level) - (level - 1);
	}
	
	public int getLevel(){
		return level;
	}
	public double getDamage(){
		return damage;
	}
	public double getHealth(){
		return health;
	}
	public int getGoldValue(){
		return goldValue;
	}
	public int getXPValue(){
		return xpValue;
	}
	public void takeDamage(double change){
		health-= change;
		/*
		 * Same formula as the Player damage. Doesn't work. Idk.
		 */
	}
}
