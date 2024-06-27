package BigBoss;

public abstract class SAM {
	
	private double magicNumber;
	private String toolTip = "";

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	
	public void atEndOfCombat() {
		
	}
	
	public void atEndOfTurn() {
		
	}
	
	public void atEndOfPlayerTurn() {
		
	}
	
	public void atEndOfEnemyTurn() {
		
	}
	
	public void atStartOfCombat() {
		
	}

	public double getMagicNumber() {
		return magicNumber;
	}

	public void setMagicNumber(double magicNumber) {
		this.magicNumber = magicNumber;
	}
}
