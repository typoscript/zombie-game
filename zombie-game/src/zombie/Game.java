package zombie;

import java.util.Scanner;

public class Game {
	private final int MENU_MOVE = 1;
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
				case MENU_MOVE:
					runMenuAttack();
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
	
	private void runMenuAttack() {
		while (true) {
			System.out.print("1) 공격 2) 물약 사용: ");

			int menu = sc.nextInt();
			
			switch (menu) {
				case MENU_HERO_ATTACK:
					hero.attack(boss);
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
			
			if (zombie.isDead()) {
				System.out.println("좀비 사망");
			}
		}
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
		map.addUnitToMap(hero);
		map.addUnitToMap(zombie);
		map.addUnitToMap(boss);
	}
}
