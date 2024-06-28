package BigBoss;

public abstract class SAM {
	
	private double magicNumber;
	private String toolTip = "";
	private double delayAtNextKeyTime = 0;
	private String textAtNextKeyTime = "";

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	
	public String atEndOfCombat() {
		return "";
	}
	
	public String atEndOfTurn() {
		return "";
	}
	
	public String atEndOfPlayerTurn() {
		return "";
	}
	
	public String atEndOfEnemyTurn() {
		return "";

	}
	
	public String atStartOfCombat() {
		return "";
	}

	public double getMagicNumber() {
		return magicNumber;
	}

	public void setMagicNumber(double magicNumber) {
		this.magicNumber = magicNumber;
	}

	public double getDelayAtNextKeyTime() {
		double ret = delayAtNextKeyTime;
		delayAtNextKeyTime = 0;
		return ret;
	}

	public void setDelayAtNextKeyTime(double delayAtNextKeyTime) {
		this.delayAtNextKeyTime = delayAtNextKeyTime;
	}

	public String getTextAtNextKeyTime() {
		String ret = textAtNextKeyTime;
		textAtNextKeyTime = "";
		return ret;
	}

	public void setTextAtNextKeyTime(String textAtNextKeyTime) {
		this.textAtNextKeyTime = textAtNextKeyTime;
	}
}
