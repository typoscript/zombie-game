package zombie;

public class Game {
	private static Game instance = new Game();
	private Hero hero;
	private Zombie zombie;
	private Boss boss;
	
	private Game() { }
	
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
		
	}
}
