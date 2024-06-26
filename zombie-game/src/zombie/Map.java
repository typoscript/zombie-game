package zombie;

public class Map {
	public static final int SIZE = 10;

	public static final int HERO_POSITION = 0;
	public static final int ZOMBIE_POSITION = 5;
	public static final int BOSS_POSITION = 9;
	
	private Unit[] map = new Unit[SIZE];
	
	public Unit getUnit(int position) {
		return map[position];
	}

	public String getNameOfUnit(Unit unit) {
		if (unit instanceof Boss)
			return "보스";
		else if (unit instanceof Zombie)
			return "좀비";
		
		return "???";
	}

	public void addUnitToMap(Unit unit) {
		map[unit.getPosition()] = unit;
	}
	
	public boolean doesUnitExist(int position) {
		return map[position] != null;
	}
	
	public void moveUnitPosition(Unit unit) {
		map[unit.getPosition()] = null;

		unit.move();

		map[unit.getPosition()] = unit;
	}
	
	public boolean isHeroAtEndOfMap() {
		return map[SIZE - 1] instanceof Hero;
	}	
	
	public void printMap() {
		for (Unit unit : map) {
			if (unit == null)
				System.out.print("_");
			else if (unit instanceof Hero)
				System.out.print("옷");
			else
				System.out.print("?");
		}

		System.out.println();
	}
}
