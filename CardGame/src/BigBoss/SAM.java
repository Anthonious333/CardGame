package BigBoss;

import java.util.ArrayList;

import theBossCharecter.BossEnemy;

public abstract class SAM {
	
	private double magicNumber;
	private String toolTip = "";
	private double delayAtNextKeyTime = 0;
	private ArrayList<String> textAtNextKeyTime = new ArrayList<String>();

	public String getToolTip() {
		return toolTip;
	}

	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	
	public String atEndOfCombat(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}
	
	public String atEndOfTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}
	
	public String atEndOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}
	
	public String atEndOfEnemyTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";

	}
	
	public String atStartOfTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}
	
	public String atStartOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}
	
	public String atStartOfEnemyTurn(AbstractCharecter charecter, BossEnemy boss) {
		return "";

	}
	
	public String atStartOfCombat(AbstractCharecter charecter, BossEnemy boss) {
		return "";
	}

	public String onOwnerTakeDamage(int amount, boolean physical) {
		return "";
	}
	
	public String onPlayerUseAbility(AbstractCharecter owner, AbstractCharecter target) {
		return "";
	}
	
	public String onEnemyUseAbility(AbstractCharecter owner, AbstractCharecter target) {
		return "";
	}
	
	public String onUseAbility(AbstractCharecter owner, AbstractCharecter target) {
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

	public ArrayList<String> getTextAtNextKeyTime() {
		ArrayList<String> ret = new ArrayList<String>();
		for(String s : textAtNextKeyTime) {
			ret.add(s);
		}
		textAtNextKeyTime.clear();
		return ret;
	}

	public void setTextAtNextKeyTime(ArrayList<String> textAtNextKeyTime) {
		this.textAtNextKeyTime = textAtNextKeyTime;
	}

	
}
