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

		return Utility.getRandomNumber(MIN_ATTACK_POWER, MAX_ATTACK_POWER);
	}
	
	public boolean canDoubleAttackPower() {
		final int DOUBLE_CHANCE_PERCENTAGE = 80;
		final int RANDOM_CHANCE_PERCENTAGE = (int)(Math.random() * 101);
		
		boolean canDoubleAttackPower = DOUBLE_CHANCE_PERCENTAGE > RANDOM_CHANCE_PERCENTAGE;
		
		return canDoubleAttackPower;
	}
	
	@Override
	public void attack(Unit hero) {
		int attackPower = getRandomAttackPower();
		
		if (canDoubleAttackPower()) {
			System.out.println("보스 필살기 공격");
			attackPower *= 2;
		} else {
			System.out.println("보스 일반 공격");
		}
		
		hero.damageHp(attackPower);

		System.out.printf(
			"보스 공격력: %d로 공격 | 공격 후 Hero의 HP: %d\n",
			attackPower, hero.getHp()
		);
	}
}
