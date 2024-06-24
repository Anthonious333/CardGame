package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;

public class BulkMod extends AbstractModification{

	private AbstractCharecter owner;
	private double threshhold;
	public BulkMod(AbstractModification last, int level, double magicNumber, double threshhold, AbstractCharecter owner) {
		this(last, level, magicNumber, threshhold, owner, true);
	}
	
	public BulkMod(AbstractModification last, int level, double magicNumber, double threshhold, AbstractCharecter owner, boolean locks) {
		super("Bulk " + level, last, locks);
		this.setMagicNumber(magicNumber);
		this.owner= owner;
		this.threshhold = threshhold;
	}
	@Override
	public boolean isUnlockConditionMet() {
		if (owner.getStat("HP") >= threshhold) {
			return true;
		}
		return false;
	}

	@Override
	public void onUnlock() {
		
		Stat hp = owner.findStat("HP");
		hp.addTempValue((int) this.getMagicNumber());
		hp.commitTempStat();
		
	}
	@Override
	public String getToolTip() {
		return "Gain " + (int)this.getMagicNumber() + " HP upon unlocking" + (this.isUnlocked()? "" : "\n" + this.owner.getStat("HP") + "/" + (int)this.threshhold);
	}
}
