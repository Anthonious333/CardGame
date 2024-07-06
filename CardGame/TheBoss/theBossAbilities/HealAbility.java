package theBossAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.HealAnimation;

public class HealAbility extends AbstractAbility{

	private int power;
	
	public HealAbility(AbstractCharecter owner, int power) {
		super("Heal", "Recover " + power + " HP.", AbilityType.BUFF, owner);
		this.power = power;
		this.setAnimation(new HealAnimation());
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " healed for " + this.getOwner().heal(power) + " HP.";
	}
	
	@Override
	public boolean canSelect() {
		if (this.getOwner().getStat("HP") < power) {
			return super.canSelect();
		} else {
			return false;
		}
	}


}
