package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;

public class KickAbility extends AbstractAbility{

	public KickAbility(AbstractCharecter owner) {
		super("Kick", "Deal danage equal to 2 X your ATK.\nCooldown 1", AbilityType.ATTACK_PHYSICAL, owner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(1);
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") * 2, true) + " damage to " + target.getName();
	}

	

}
