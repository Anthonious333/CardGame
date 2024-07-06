package mrBasicModifications;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import mrBasicCharecter.MrBasic;

public class ReviveMod extends AbstractModification{

	public ReviveMod(AbstractModification last, AbstractCharecter owner) {
		super("Revive", last, owner);
		this.setMagicNumber(1500);
	}

	@Override
	public boolean isUnlockConditionMet() {
		if (getOwner().getStat("HP") >= this.getMagicNumber()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onUnlock() {
		((MrBasic) this.getOwner()).setRevives(true);
	}

	@Override
	public String getToolTip() {
		return "Once per fight, upon reaching 0 HP, revive to your max HP" + (this.isUnlocked()? "" : "\n" + this.getOwner().getStat("HP") + "/" + (int)this.getMagicNumber());
	}
}
