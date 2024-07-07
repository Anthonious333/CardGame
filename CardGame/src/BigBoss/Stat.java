package BigBoss;

public class Stat extends SAM{

	private int value;
	private String name;
	private boolean limited;
	private int min, max;
	private int tempValue = 0;
	private boolean resets;
	
	public Stat (String name, int value) {
		this(name, value, -1, -1, false);
		limited = false;
	}
	
	public Stat (String name, String toolTip, int value) {
		this(name, toolTip, value, -1, -1, false);
		limited = false;
	}
	
	public Stat (String name, int value, int min, int max) {
		this(name, value, min, max, false);
	}
	
	public Stat (String name, String toolTip, int value, int min, int max) {
		this(name, toolTip, value, min, max, false);
		}
	
	public Stat (String name, int value, int min, int max, boolean reset) {
		this(name, "NONE", value, min, max, false);
	}
	
	public Stat (String name, String toolTip, int value, int min, int max, boolean reset) {
		this.name = name;
		this.value = value;
		this.max = max;
		this.min = min;
		limited = true;
		this.resets = reset; //TODO this dosent work
		this.setToolTip(toolTip);
	}

	public int getValue() {
		return value;
	}
	
	//returns the actual change in stat (positive for adding / negative for subtracting)
	public int addValue(int value) {
		int pre = this.value;
		
		if (limited && this.value + value > max + tempValue) {
			this.value = max + tempValue;
		} else if (limited && this.value + value < min - tempValue) {
			this.value = min - tempValue;
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
	
	public void reset() {
		if (this.resets()) {
			this.value = max;
		}
		this.tempValue = 0;
	}
	
	public void setValue(int value) {
		if (limited) {
			max = value;
		}
		this.value = value;
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

	public boolean resets() {
		return resets;
	}

	public void setResets(boolean resets) {
		this.resets = resets;
	}


}
