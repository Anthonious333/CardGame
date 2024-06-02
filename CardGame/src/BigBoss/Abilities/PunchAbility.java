package BigBoss.Abilities;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BossEnemy;

public class PunchAbility extends AbstractAbility{

	public PunchAbility(AbstractCharecter owner) {
		super("Punch", owner);
	}

	@Override
	public void use(AbstractCharecter target) {
		target.damage(this.getOwner().getStat("ATK"));
	}

	
}
