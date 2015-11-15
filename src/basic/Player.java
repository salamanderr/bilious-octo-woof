package basic;

/*
 * This is the main object class for the player character. It's pretty similar to the enemy class, but with more framework for the eventual blacksmith / weapon shop.
 * 
 * I hope to eventually add in a system for luck based gold gain, found items, and maybe classes (mage, necromancer, paladin etc.)
 * 
 * Created by @salamanderr 11/15/2015
 */

public class Player{
	private String name;
	int level;
	private double dmg;
	private double armr;
	private double health;
	private int xp;
	private int xpLevel;
	private int gold;
	
	public Player(String name){
		this.name = name;
		level = 1;
		dmg = 5.0;
		armr = 0;
		health = 10;
		xp = 0;
		xpLevel = level*level;
		gold = 0;
	}
	public String getName(){
		return name;
	}
	public int getLevel(){
		return level;
	}
	public double getDamage(){
		return dmg;
	}
	public double getArmor(){
		return armr;
	}
	public double getHealth(){
		return health;
	}
	public int getGold(){
		return gold;
	}
	public int getXP(){
		return xp;
	}
	public void heal(double change){
		health+= change;
	}
	public void addDamage(int change){
		dmg+= change;
	}
	public void addArmor(int change){
		armr+= change;
	}
	public void addGold(int change){
		gold+= change;
	}
	public void takeDamage(int change){
		if(armr < change)
			health-= (change - armr);
		/*
		 * Program currently uses damage - armor as the damage formula. Probably going to be changed to be more complex eventually, but for now this works.
		 */
	}
	public void addXP(int change){
		xp+= change;
		if(xp > xpLevel){
			level+= (xp / xpLevel);
			xp=(xp / xpLevel);
		}
	}
	public void loadSave(String name, int level, double dmg, double armr, double health, int xp, int gold){
		this.name = name;
		this.level = level;
		this.dmg = dmg;
		this.armr = armr;
		this.health = health;
		this.xp = xp;
		this.gold = gold;
	}
}
