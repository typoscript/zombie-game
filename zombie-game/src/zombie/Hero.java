package zombie;

public class Hero extends Unit {
	private int attackPower;
	private int numOfPotions;
	
	public Hero(int position, int hp, int maxHp, int numOfPotions) {
		super(position, hp, maxHp)
		this.numOfPotions = numOfPotions; 
	}
}
