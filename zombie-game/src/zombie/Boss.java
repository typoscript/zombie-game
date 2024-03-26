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
}
