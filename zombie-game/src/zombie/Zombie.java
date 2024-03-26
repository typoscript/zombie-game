package zombie;

public class Zombie extends Unit {
	private int attackPower;
	
	public Zombie(int position, int hp, int maxHp) {
		super(position, hp, maxHp);
	}
	
	@Override
	public void attack(Unit hero) {
		final int MIN_ATTACK_POWER = 1;
		final int MAX_ATTACK_POWER = 10;

		attackPower = Utility.getRandomNumber(MIN_ATTACK_POWER, MAX_ATTACK_POWER);
		
		hero.damageHp(attackPower);
		
		this.healHp(attackPower / 2);
		
		System.out.printf(
			"좀비가 공격력 %d로 공격 | 공격 후 Hero의 HP: %d | 공격으로 체력 회복 후 좀비의 체력: %d\n",
			attackPower, hero.getHp(), getHp()
		);
	}
}
