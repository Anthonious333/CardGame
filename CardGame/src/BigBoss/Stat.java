package BigBoss;

public class Stat {

	private int value;
	private String name;
	private boolean limited;
	private int min, max;
	
	public Stat (String name, int value) {
		this(name, value, -1, -1);
		limited = false;
	}
	
	public Stat (String name, int value, int min, int max) {
		this.name = name;
		this.value = value;
		this.max = max;
		this.min = min;
		limited = true;
	}

	public int getValue() {
		return value;
	}

	public void addValue(int value) {
		if (limited && this.value + value > max) {
			this.value = max;
		} else if (limited && this.value + value < min) {
			this.value = min;
		} else {
			this.value += value;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String ret = name + ": " + value;
		if (limited) {
			ret += "/" + max;

		}
		return ret;
	}
}
