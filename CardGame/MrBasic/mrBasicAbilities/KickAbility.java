package mrBasicAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import theBossCharecter.BossEnemy;

public class KickAbility extends AbstractAbility{

	public KickAbility(AbstractCharecter owner) {
		super("Kick", "Deal danage equal to 2X your ATK.\nCooldown 1", AbilityType.ATTACK_PHYSICAL, owner);
		if (owner instanceof BossEnemy) {
			this.setAnimation(new AttackAnimation(true, .75));
		} else {
			this.setAnimation(new AttackAnimation(false, .75));
		}
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(1);
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") * 2, true) + " damage to " + target.getName();
	}

	

}
