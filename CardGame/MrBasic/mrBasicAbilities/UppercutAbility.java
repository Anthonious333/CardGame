package mrBasicAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import theBossCharecter.BossEnemy;

public class UppercutAbility extends AbstractAbility{

	public UppercutAbility(AbstractCharecter owner) {
		super("Uppercut",  "Deal danage equal to 3X your ATK. Cooldown 2", AbilityType.ATTACK_PHYSICAL, owner);
		if (owner instanceof BossEnemy) {
			this.setAnimation(new AttackAnimation(true, .75));
		} else {
			this.setAnimation(new AttackAnimation(false, .75));
		}
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(2);
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") * 3, true) + " damage to " + target.getName();
	}

}
