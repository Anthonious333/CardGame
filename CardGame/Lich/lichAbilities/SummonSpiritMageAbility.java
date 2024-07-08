package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.SpiritMageMinion;
import lichMinions.SpiritWarriorMinion;
import lichMisc.AbstractLichAbility;

public class SummonSpiritMageAbility extends AbstractLichAbility{

	public SummonSpiritMageAbility(AbstractCharecter owner) {
		super("Summon Spirit Mage", "Summon 10, summon a Spirit Mage.", AbilityType.UNKNOWN, owner);
		this.setSummonCost(10);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().addMinion(new SpiritMageMinion(this.getOwner(), target));
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Mage.";
	}

}
