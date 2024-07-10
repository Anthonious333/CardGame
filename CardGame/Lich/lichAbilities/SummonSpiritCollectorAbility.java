package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritCollectorMinion;
import lichMisc.AbstractLichAbility;

public class SummonSpiritCollectorAbility extends AbstractLichAbility{

	public SummonSpiritCollectorAbility(AbstractCharecter owner) {
		super("Summon Spirit Collector", "Summon 15, summon a Spirit Collector", AbilityType.UNKNOWN, owner);
		this.setSummonCost(15);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().addMinion(new SpiritCollectorMinion(this.getOwner()));
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Collector.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritCollectorMinion) {
				amountOfThis ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Collector." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

}
