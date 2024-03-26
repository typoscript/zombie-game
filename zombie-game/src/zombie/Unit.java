package zombie;

abstract public class Unit {
	private final int MAX_HP;

	private int position;
	private int hp;
	
	public Unit(int position, int hp, int maxHp) {
		this.position = position;
		this.hp = hp;
		this.MAX_HP = maxHp;
	}
}
