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

}
