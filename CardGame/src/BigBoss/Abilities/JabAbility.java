package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import BigBoss.Characters.*;

public class JabAbility extends AbstractAbility{

	public JabAbility(AbstractCharecter owner) {
		super("Jab", "Deal damage equal to half your attack.\nCantrip.", AbilityType.ATTACK_PHYSICAL, owner);
		if (owner instanceof BossEnemy) {
			this.setAnimation(new AttackAnimation(true, .25));
		} else {
			this.setAnimation(new AttackAnimation(false, .25));
		}
	}

	@Override
	public String use(AbstractCharecter target) {
		((BossEnemy)target).cantrip(this);
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") / 2, true) + " damage to " + target.getName();
	}

}
