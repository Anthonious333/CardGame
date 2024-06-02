package BigBoss.Abilities;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;

public class HealAbility extends AbstractAbility{

	private int power;
	
	public HealAbility(AbstractCharecter owner, int power) {
		super("Heal", owner);
		this.power = power;
	}

	@Override
	public void use(AbstractCharecter target) {
		this.getOwner().heal(power);
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
