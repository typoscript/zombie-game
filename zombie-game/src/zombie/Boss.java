package zombie;

public class Boss extends Zombie {
	private int shield;
	
	public Boss(int position, int hp, int maxHp, int shield) {
		super(position, hp, maxHp);
		this.shield = shield;
	}
	
	public boolean canDoubleAttackPower() {
		final int DOUBLE_ATTACK_POWER_CHANCE_PERCENTAGE = 80;
		final int RANDOM_CHANCE_PERCENTAGE = (int)(Math.random() * 101);
		
		return DOUBLE_ATTACK_POWER_CHANCE_PERCENTAGE > RANDOM_CHANCE_PERCENTAGE;
	}
	
	@Override
	public void damageHp(int damage) {
		if (shield >= damage)
			return;

		super.damageHp(damage - shield);
	}
	
	@Override
	public void attack(Unit hero) {
		final int MIN_ATTACK_POWER = 5;
		final int MAX_ATTACK_POWER = 10;

		int attackPower = Utility.getRandomNumber(MIN_ATTACK_POWER, MAX_ATTACK_POWER);
		
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
