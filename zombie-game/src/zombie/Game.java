package zombie;

import java.util.Scanner;

public class Game {
	private final int MENU_ATTACK = 1;
	private final int MENU_QUIT = 2;
	
	private static Game instance = new Game();
	private Scanner sc = new Scanner(System.in);
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	private boolean isRunning;
	
	private Game() { }
	
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
		initCharacters();
		isRunning = true;
		
		while (isRunning) {
			System.out.println("Hero 현재 위치: " + hero.getPosition());
			
			System.out.print("1) 이동 2) 종료");
			
			int menu = sc.nextInt();
			
			switch (menu) {
				case MENU_ATTACK:
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
	
	private void quit() {
		isRunning = false;
	}
	
	private void initCharacters() {
		this.hero = new Hero(1, 100, 100, 5);
		this.zombie = new Zombie(5, 100, 100);
		this.boss = new Boss(9, 200, 200, 5);
	}
}
