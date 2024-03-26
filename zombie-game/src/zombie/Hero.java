package zombie;

public class Hero extends Unit {
	private int attackPower = 20;
	private int numOfPotions;
	
	public Hero(int position, int hp, int maxHp, int numOfPotions) {
		super(position, hp, maxHp);
		this.numOfPotions = numOfPotions; 
	}
	
	public void healByPotion() {
		final int POTION_HP_HEAL_AMOUNT = 20;

		if (numOfPotions == 0) {
			System.out.println("물약이 없습니다");
			return; 
		}
		
		healHp(POTION_HP_HEAL_AMOUNT);
		numOfPotions--;

		System.out.printf("물약 사용 후 HP: %d\n", getHp());
	}

	public void attack(Unit target) {
		System.out.printf("Hero 공격력: %d로 공격 | ", this.attackPower);

		if (target instanceof Boss) {
			Boss boss = (Boss)target;
			boss.damageHp(attackPower);
			
			System.out.printf("공격 당한 후 Boss의 HP: %d\n", boss.getHp());
		} else if (target instanceof Zombie) {
			Zombie zombie = (Zombie)target;
			zombie.damageHp(attackPower);

			System.out.printf("공격 당한 후 Zombie의 HP: %d\n", zombie.getHp());
		} else {
			System.out.println("공격할 수 없는 대상입니다");
		}
	}
}
