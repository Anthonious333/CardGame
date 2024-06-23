package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Characters.BossEnemy;

public class PunchAbility extends AbstractAbility{

	public PunchAbility(AbstractCharecter owner) {
		super("Punch", "Deal danage equal to your ATK.", AbilityType.ATTACK, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK"), true) + " damage to " + target.getName();
	}

	
}
