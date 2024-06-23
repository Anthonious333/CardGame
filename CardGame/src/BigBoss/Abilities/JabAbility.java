package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Characters.*;

public class JabAbility extends AbstractAbility{

	public JabAbility(AbstractCharecter owner) {
		super("Jab", "Deal damage equal to half your attack.\nCantrip.", AbilityType.ATTACK_PHYSICAL, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		((BossEnemy)target).cantrip();
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") / 2, true) + " damage to " + target.getName();
	}

}
