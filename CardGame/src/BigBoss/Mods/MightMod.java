package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;

public class MightMod extends AbstractModification{

	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner) {
		this(last, level, magicNumber, owner, true);
	}
	
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner, boolean locks) {
		super("Might " + level, last, owner, locks);
		this.setMagicNumber(magicNumber);
	}
	@Override
	public boolean isUnlockConditionMet() {
		if (this.getOwner().getStat("ATK") >= (this.getMagicNumber() * 100)) {
			return true;
		}
		return false;
	}

	@Override
	public String getToolTip() {
		return "Gain " + ((int)(this.getMagicNumber() * 100)) + "% more ATK" + (this.isUnlocked()? "" : "\n" + this.getOwner().getStat("ATK") + "/" + ((int)(this.getMagicNumber() * 100)));
	}
}
