package zombie;

import java.util.Scanner;

public class Game {
	private final int MENU_HERO_MOVE = 1;
	private final int MENU_QUIT = 2;
	
	private final int MENU_HERO_ATTACK = 1;
	private final int MENU_HERO_USE_POTION = 2;
	
	private static Game instance = new Game();
	private Scanner sc = new Scanner(System.in);
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	private boolean isRunning;
	private Map map;
	
	private Game() { }
	
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
		initUnits();
		addUnitsToMap();
		isRunning = true;
		
		while (isRunning) {
			System.out.println("Hero 현재 위치: " + hero.getPosition());
			
			System.out.print("1) 이동 2) 종료");
			
			int menu = sc.nextInt();
			
			switch (menu) {
				case MENU_HERO_MOVE:
					runMenuMove();
					break;
				case MENU_QUIT:
					quit();
					break;
				default:
					System.out.println("잘못된 메뉴입니다");
					return;
			}
		}
		
		System.out.println("종료");
	}
	
	private void runMenuMove() {
		if (!map.doesUnitExist(hero.getPosition() + 1)) {
			map.moveUnitPosition(hero);
			return;
		}
		
		if (map.isHeroAtEndOfMap()) {
			quit();
			return;
		}
		
		runMenuHero();
	}
	
	private void runMenuHero() {
		String nameOfUnit = map.getNameOfUnit(hero.getPosition() + 1);
		System.out.printf("%s 발견\n", nameOfUnit);

		while (true) {
			System.out.print("1) 공격 2) 물약 사용: ");
			int menu = sc.nextInt();
			Unit target = map.getUnit(hero.getPosition() + 1);
			
			switch (menu) {
				case MENU_HERO_ATTACK:
					runHeroBattle();
					break;
				case MENU_HERO_USE_POTION:
					hero.healByPotion();
					break;
				default:
					System.out.println("잘못된 메뉴입니다");
					return;
			}
			
			if (hero.isDead()) {
				System.out.println("사망");
				quit();
				return;
			}
			
			if (target.isDead()) {
				System.out.printf("%s 사망\n", nameOfUnit);
				map.moveUnitPosition(hero);
				break;
			}
		}
	}
	
	private void runHeroBattle() {
		Unit target = map.getUnit(hero.getPosition() + 1);

		hero.attack(target);
		
		if (!target.isDead())
			target.attack(hero);
	}
	
	private void quit() {
		isRunning = false;
	}
	
	private void initUnits() {
		this.hero = new Hero(1, 100, 100, 5);
		this.zombie = new Zombie(5, 100, 100);
		this.boss = new Boss(9, 200, 200, 5);
	}
	
	private void addUnitsToMap() {
		map = new Map();

		map.addUnitToMap(hero);
		map.addUnitToMap(zombie);
		map.addUnitToMap(boss);
	}
}
