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

	public boolean isDead() {
		return this.hp == 0;
	}
	
	public void healHp(int hp) {
		this.hp += hp;
		
		if (this.hp > this.MAX_HP)
			this.hp = this.MAX_HP;
	}

	public void damageHp(int hp) {
		this.hp -= hp;
		
		if (this.hp < 0)
			this.hp = 0;
	}
	
	public void move() {
		if (position <= Map.SIZE)
			position++;
		
		System.out.println("오른쪽으로 이동" + position);
	}
	
	abstract void attack(Unit unit);
}
