package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BossEnemy;

public class PowerUpAbility extends AbstractAbility{

	private int power;
	
	
	public PowerUpAbility(AbstractCharecter owner, int power) {
		super("Power Up", AbilityType.BUFF, owner);
		this.power = power;
		setRoleDifficulty(1);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " Powered up by " + this.getOwner().addStat("ATK", power) + " ATK!";
	}

}
