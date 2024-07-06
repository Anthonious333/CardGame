package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritSheildmenMinion;
import lichMinions.SpiritWarriorMinion;
import lichMisc.AbstractLichAbility;

public class SummonSpiritWarriorAbility extends AbstractLichAbility{

	public SummonSpiritWarriorAbility(AbstractCharecter owner) {
		super("Summon Spirit Warrior", "Summon 15, Summon Spirit Warrior", AbilityType.UNKNOWN, owner);
		this.setMagicNumber(10);
		this.setSummonCost(15);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().addMinion(new SpiritWarriorMinion(this.getOwner(), target, (int) this.getMagicNumber()));
		this.getOwner().addReduceNextDamageTaken((int)this.getMagicNumber());
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Warrior.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritWarriorMinion) {
				amountOfThis ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Warrior." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

}
