package zombie;

public class Boss extends Zombie {
	private int shield;
	
	public Boss(int position, int hp, int maxHp, int shield) {
		super(position, hp, maxHp);
		this.shield = shield;
	}
	
	public void setShield(int shield) {
		this.shield = shield;
	}
	
	public int getShield() {
		return this.shield;
	}
	
	public int getRandomAttackPower() {
		final int MIN_ATTACK_POWER = 5;
		final int MAX_ATTACK_POWER = 20;

		int attackPower = (int)(Math.random() * (MAX_ATTACK_POWER - MIN_ATTACK_POWER + 1)) + MIN_ATTACK_POWER;

		return attackPower;
	}
}
