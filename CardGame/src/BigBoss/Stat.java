package BigBoss;

public class Stat {

	private int value;
	private String name;
	private boolean limited;
	private int min, max;
	private int tempValue = 0;
	
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
	
	//returns the actual change in stat (positive for adding / negative for subtracting)
	public int addValue(int value) {
		int pre = this.value;
		if (limited && this.value + value > max) {
			this.value = max;
		} else if (limited && this.value + value < min) {
			this.value = min;
		} else {
			this.value += value;
		}
		return -(pre - this.value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isLimited() {
		return limited;
	}
	
	public int getMax () {
		return max;
	}
	
	@Override
	public String toString() {
		String ret = name + ": " + value;
		if (limited) {
			ret += "/" + max;

		}
		return ret;
	}

	public void commitTempStat() {
		this.value += this.tempValue;
		if (limited) {
			max += this.tempValue;
		}
		tempValue = 0;
	}
	
	public int getTempValue() {
		return tempValue;
	}

	public void setTempValue(int tempValue) {
		this.tempValue = tempValue;
	}
	
	public void addTempValue(int tempValue) {
		this.tempValue += tempValue;
	}

}
