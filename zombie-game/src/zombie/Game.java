package zombie;

public class Game {
	private final int MENU_HERO_MOVE = 1;
	private final int MENU_QUIT = 2;
	
	private final int MENU_HERO_ATTACK = 1;
	private final int MENU_HERO_USE_POTION = 2;
	
	private static Game instance = new Game();
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	private Map map;
	private boolean isRunning;
	
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
			
			int menu = Utility.scanner.nextInt();
			
			runMenu(menu);
		}
		
		printGameResult();
	}
	
	private void runMenu(int menu) {
		switch (menu) {
			case MENU_HERO_MOVE:
				runMenuMove();
				break;
			case MENU_QUIT:
				quit();
				break;
			default:
				System.out.println("잘못된 메뉴입니다");
				break;
		}
	}
	
	private void runMenuMove() {
		map.printMap();

		if (map.isHeroAtEndOfMap()) {
			quit();
			return;
		}
		
		if (!map.doesUnitExist(hero.getPosition() + 1)) {
			map.moveUnitPosition(hero);
			return;
		}
		
		runMenuHero();
	}
	
	private void runMenuHero() {
		Unit target = map.getUnit(hero.getPosition() + 1);
		String targetName = map.getNameOfUnit(target);
		System.out.printf("%s 발견\n", targetName);

		while (true) {
			System.out.print("1) 공격 2) 물약 사용: ");
			int menu = Utility.scanner.nextInt();
			
			switch (menu) {
				case MENU_HERO_ATTACK:
					runHeroBattle();
					break;
				case MENU_HERO_USE_POTION:
					hero.healByPotion();
					break;
				default:
					System.out.println("잘못된 메뉴입니다");
					continue;
			}
			
			if (isUnitDead(target, targetName))
				return;
		}
	}
	
	private void runHeroAction(int menu) {
		switch (menu) {
			case MENU_HERO_ATTACK:
				runHeroBattle();
				break;
			case MENU_HERO_USE_POTION:
				hero.healByPotion();
				break;
			default:
				System.out.println("잘못된 메뉴입니다");
		}
	}
	
	private boolean isUnitDead(Unit target, String targetName) {
		if (hero.isDead()) {
			System.out.println("플레이어 사망");
			quit();
			return true;
		}
		
		if (target.isDead()) {
			System.out.printf("%s 사망\n", targetName);
			map.moveUnitPosition(hero);
			return true;
		}
		
		return false;
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
		this.hero = new Hero(Map.HERO_POSITION, 100, 100, 5);
		this.zombie = new Zombie(Map.ZOMBIE_POSITION, 100, 100);
		this.boss = new Boss(Map.BOSS_POSITION, 200, 200, 5);
	}
	
	private void addUnitsToMap() {
		map = new Map();

		map.addUnitToMap(hero);
		map.addUnitToMap(zombie);
		map.addUnitToMap(boss);
	}
	
	private void printGameResult() {
		if (map.isHeroAtEndOfMap())
			System.out.println("Hero 승리");
		else
			System.out.println("종료");
	}
}
