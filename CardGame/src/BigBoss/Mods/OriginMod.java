package BigBoss.Mods;

import BigBoss.AbstractModification;

public class OriginMod extends AbstractModification{

	public OriginMod(String name, AbstractModification last) {
		super(name, last);
		this.unlock();
	}

	@Override
	public boolean isUnlockConditionMet() {
		return true;
	}

	@Override
	public String getToolTip() {
		return "The first step in the journy";
	}
	
}
