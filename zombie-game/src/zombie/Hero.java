package zombie;

public class Hero extends Unit {
	private int attackPower;
	private int numOfPotions;
	
	public Hero(int position, int hp, int maxHp, int numOfPotions) {
		super(position, hp, maxHp)
		this.numOfPotions = numOfPotions; 
	}

	public void attack(Unit target) {
		switch (target) {
			case target instanceof Boss:
				return;
			case target instanceof Zombie:
				return;
			default:
				System.out.println("공격할 수 없는 대상입니다");
				return;
		}
	}
}
