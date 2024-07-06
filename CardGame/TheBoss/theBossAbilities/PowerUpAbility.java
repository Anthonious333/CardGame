package theBossAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.JumpAnimation;
import theBossCharecter.BossEnemy;

public class PowerUpAbility extends AbstractAbility{

	private int power;
	
	
	public PowerUpAbility(AbstractCharecter owner, int power) {
		super("Power Up", "Icrease ATK by " + power + ".", AbilityType.BUFF, owner);
		this.power = power;
		setRoleDifficulty(1);
		this.setAnimation(new JumpAnimation(3, .5));
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " Powered up by " + this.getOwner().addStat("ATK", power) + " ATK!";
	}

}
