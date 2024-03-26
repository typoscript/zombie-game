package zombie;

public class Map {
	private final int MAP_SIZE = 10;

	public static final int HERO_POSITION = 0;
	public static final int ZOMBIE_POSITION = 5;
	public static final int BOSS_POSITION = 9;
	
	private Unit[] map = new Unit[MAP_SIZE];
	
	public void addUnitToMap(Unit unit) {
		map[unit.getPosition()] = unit;
	}
	
	public Unit getUnit(int position) {
		return map[position];
	}
	
	public boolean doesUnitExist(int position) {
		return map[position] != null;
	}
}
