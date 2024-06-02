package BigBoss.Abilities;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BossEnemy;

public class PowerUpAbility extends AbstractAbility{

	private int power;
	
	
	public PowerUpAbility(AbstractCharecter owner, int power) {
		super("Power Up", owner);
		this.power = power;
		setRoleDifficulty(1);
	}

	@Override
	public void use(AbstractCharecter target) {
		this.getOwner().addStat("ATK", power);
	}

}
