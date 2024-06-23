package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;

public class CantripAbility extends AbstractAbility{

	public CantripAbility(AbstractCharecter owner) {
		super("Cantrip", AbilityType.UNKNOWN, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " did nothing.";
	}

	@Override
	public boolean isUnlocked() {
		return false;
	}
}
