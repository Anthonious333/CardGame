package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Characters.MrBasic;

public class ReviveMod extends AbstractModification{

	public ReviveMod(AbstractModification last, AbstractCharecter owner) {
		super("Revive", last, owner);
	}

	@Override
	public boolean isUnlockConditionMet() {
		if (getOwner().getStat("HP") >= 1000) {
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
		return "Once per fight, upon reaching 0 HP, revive to your max HP" + (this.isUnlocked()? "" : "\n" + this.getOwner().getStat("HP") + "/" + 1000);
	}
}
