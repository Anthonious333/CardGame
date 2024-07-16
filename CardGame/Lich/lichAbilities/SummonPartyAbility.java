package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritCollectorMinion;
import lichMinions.SpiritMageMinion;
import lichMinions.SpiritSheildmenMinion;
import lichMinions.SpiritSoldierMinion;
import lichMinions.SpiritWarriorMinion;
import lichMisc.AbstractLichAbility;

public class SummonPartyAbility extends AbstractLichAbility{

	public SummonPartyAbility(AbstractCharecter owner) {
		super("Summon Spirit Party", "Summon 25, summon a Spirit Soldier, a Spirit Shieldsman, a Spirit Warrior, and a Spirit Mage. \nCooldown 2", AbilityType.UNKNOWN , owner);
		this.setSummonCost(25);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(2);
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), 5));
		this.getOwner().addMinion(new SpiritWarriorMinion(this.getOwner(), target, 10));
		this.getOwner().addMinion(new SpiritMageMinion(this.getOwner(), target));
		this.getOwner().addReduceNextDamageTaken(15);
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Soldier, a Spirit Sheildmen, a Spirit Warrior, and a Spirit Mage.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfSoldier = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritSoldierMinion) {
				amountOfSoldier ++;
			}
		}
		int amountOfSheildmen = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritSheildmenMinion) {
				amountOfSheildmen ++;
			}
		}
		int amountOfWarrior = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritWarriorMinion) {
				amountOfWarrior ++;
			}
		}
		int amountOfMage = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritMageMinion) {
				amountOfMage ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", summon a Spirit Soldier, a Spirit Sheildmen, a Spirit Warrior, and a Spirit Mage. \nCooldown 2" + (amountOfSoldier > 0 || amountOfSheildmen > 0 || amountOfWarrior > 0 || amountOfMage > 0? "\nCurrent(Respectivly): " + amountOfSoldier + " - " + amountOfSheildmen + " - " + amountOfWarrior + " - " + amountOfMage: "");
	}

}