package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;

public class MightMod extends AbstractModification{

	private AbstractCharecter owner;
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner) {
		this(last, level, magicNumber, owner, true);
	}
	
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner, boolean locks) {
		super("Might " + level, last, locks);
		this.setMagicNumber(magicNumber);
		this.owner= owner;
	}
	@Override
	public boolean isUnlockConditionMet() {
		if (owner.getStat("ATK") >= (this.getMagicNumber() * 100)) {
			return true;
		}
		return false;
	}

	@Override
	public String getToolTip() {
		return "Gain " + ((int)(this.getMagicNumber() * 100)) + "% more ATK" + (this.isUnlocked()? "" : "\n" + owner.getStat("ATK") + "/" + ((int)(this.getMagicNumber() * 100)));
	}
}
