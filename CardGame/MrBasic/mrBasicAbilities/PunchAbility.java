package mrBasicAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import theBossCharecter.BossEnemy;

public class PunchAbility extends AbstractAbility{

	public PunchAbility(AbstractCharecter owner) {
		super("Punch", "Deal danage equal to your ATK.", AbilityType.ATTACK_PHYSICAL, owner);
		if (owner instanceof BossEnemy) {
			this.setAnimation(new AttackAnimation(true, .5));
		} else {
			this.setAnimation(new AttackAnimation(false, .5));
		}
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK"), true) + " damage to " + target.getName();
	}

	
}
