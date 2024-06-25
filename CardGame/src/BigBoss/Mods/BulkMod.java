package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;

public class BulkMod extends AbstractModification{

	private double threshhold;
	public BulkMod(AbstractModification last, int level, double magicNumber, double threshhold, AbstractCharecter owner) {
		this(last, level, magicNumber, threshhold, owner, true);
	}
	
	public BulkMod(AbstractModification last, int level, double magicNumber, double threshhold, AbstractCharecter owner, boolean locks) {
		super("Bulk " + level, last, owner, locks);
		this.setMagicNumber(magicNumber);
		this.threshhold = threshhold;
	}
	@Override
	public boolean isUnlockConditionMet() {
		if (this.getOwner().getStat("HP") >= threshhold) {
			return true;
		}
		return false;
	}

	@Override
	public void onUnlock() {
		
		Stat hp = this.getOwner().findStat("HP");
		hp.addTempValue((int) this.getMagicNumber());
		hp.commitTempStat();
		
	}
	@Override
	public String getToolTip() {
		return "Gain " + (int)this.getMagicNumber() + " HP upon unlocking" + (this.isUnlocked()? "" : "\n" + this.getOwner().getStat("HP") + "/" + (int)this.threshhold);
	}
}
