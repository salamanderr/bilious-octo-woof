package basic;

public class Boss {
	int level;
	private double damage;
	private double armor;
	private double health;
	private double xpValue;
	private double goldValue;
	
	public Boss(Player one){
		level = one.level + 2;
		damage = level + 7;
		armor = level + 2;
		health = level + 3;
		xpValue = level * 5;
		goldValue = level * level;
	}
	public int getLevel(){
		return level;
	}
	public double getDamage(){
		return damage;
	}
	public double getArmor(){
		return armor;
	}
	public double getHealth(){
		return health;
	}
	public void takeDamage(double change){
		health-= (change - armor);
		/*
		 * Going to be updated to match Player armor formula, when that is finalized.
		 */
	}
}