package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;

public class TheOnePunchAbility extends AbstractAbility{

	public TheOnePunchAbility(AbstractCharecter owner) {
		super("The One Punch", "Deal damage equal to 1000* your ATK", AbilityType.ATTACK_PHYSICAL, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(-2);
		return this.getOwner().getName() + " dealt " + target.damage(this.getOwner().getStat("ATK") * 1000, true) + " damage to " + target.getName();
	}

	@Override 
	public void atEndOfCombat() {
		if (this.getCooldown() == -2) {
			AbstractAbility a = BigBossGame1.getRandomUnlockedAndUnequipedAbility(getOwner());
			this.getOwner().equipAbility(a, this.getEquipIndex());
			this.setUnlocked(false);
		}
	}
}
