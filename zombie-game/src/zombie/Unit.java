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
	
	public int getPosition() {
		return this.position;
	}
	
	public int getHp() {
		return this.hp;
	}

	public int getMaxHp() {
		return this.MAX_HP;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}	
	
	public void move() {
		final int MAX_POSITION = 10;

		if (position <= MAX_POSITION)
			position++;
		
		System.out.println("오른쪽으로 이동. 현재 위치: " + position);
	}
}
