package zombie;

public class Utility {
	public static int getRandomNumber(int min, int max) {
		return (int)(Math.random() * ((max + 1) - min)) + min;
	}
}
