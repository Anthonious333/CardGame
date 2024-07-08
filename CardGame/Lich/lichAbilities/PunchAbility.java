package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import BigBoss.Animations.InfernoAnimation;
import theBossCharecter.BossEnemy;

public class PunchAbility extends AbstractAbility{

	public PunchAbility(AbstractCharecter owner) {
		super("Punch", "Deal danage equal to your ATK.", AbilityType.ATTACK_PHYSICAL, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK"), true) + " damage to " + target.getName();
	}

	
}
