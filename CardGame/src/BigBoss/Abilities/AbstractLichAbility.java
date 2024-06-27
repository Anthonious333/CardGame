package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Characters.Lich;

public abstract class AbstractLichAbility extends AbstractAbility{

	public AbstractLichAbility(String name, String toolTip, AbilityType intent, AbstractCharecter owner) {
		super(name, toolTip, intent, owner);
	}
	
	public int litchDamage(AbstractCharecter target, int amount, boolean minion) {
		return litchDamage(target, amount, false, minion);
	}

	public int litchDamage(AbstractCharecter target, int amount, boolean physical, boolean minion) {
		if (minion) {
			this.getOwner().addStat("SOULS", amount / 2);
		}
		return target.damage(amount, physical);
	}
	
	
	public Lich getOwner() {
		return (Lich) super.getOwner();
	}
}
