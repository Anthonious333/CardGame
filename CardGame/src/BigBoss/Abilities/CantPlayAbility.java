package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import theBossCharecter.BossEnemy;

public class CantPlayAbility extends AbstractAbility{

	
	public CantPlayAbility(AbstractCharecter owner) {
		super("Cant Play", AbilityType.UNKNOWN,  owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " can not play.";
	}
	
	@Override
	public boolean canSelect() {
		return false;
	}

}
