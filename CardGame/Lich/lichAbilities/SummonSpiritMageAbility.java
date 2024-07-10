package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritMageMinion;
import lichMinions.SpiritSoldierMinion;
import lichMinions.SpiritWarriorMinion;
import lichMisc.AbstractLichAbility;

public class SummonSpiritMageAbility extends AbstractLichAbility{

	public SummonSpiritMageAbility(AbstractCharecter owner) {
		super("Summon Spirit Mage", "Summon 12, summon a Spirit Mage.", AbilityType.UNKNOWN, owner);
		this.setSummonCost(12);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().addMinion(new SpiritMageMinion(this.getOwner(), target));
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Mage.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritMageMinion) {
				amountOfThis ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Mage." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

}
