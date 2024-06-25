package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;

public class OriginMod extends AbstractModification{

	public OriginMod(String name, AbstractModification last, AbstractCharecter owner) {
		super(name, last, owner);
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
