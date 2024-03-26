package zombie;

import java.util.Scanner;

public class Game {
	private static Game instance = new Game();
	private Scanner sc = new Scanner(System.in);
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	
	private Game() { }
	
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
	}
	
	private void initCharacters() {
		this.hero = new Hero(1, 100, 100, 5);
		this.zombie = new Zombie(5, 100, 100);
		this.boss = new Boss(9, 200, 200, 5);
	}
}
