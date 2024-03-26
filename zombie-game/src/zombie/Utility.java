package zombie;

import java.util.Scanner;

public class Utility {
	public static Scanner scanner = new Scanner(System.in);

	public static int getRandomNumber(int min, int max) {
		return (int)(Math.random() * ((max + 1) - min)) + min;
	}
}
