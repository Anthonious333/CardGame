package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritCollectorMinion;
import lichMinions.SpiritSheildmenMinion;
import lichMinions.SpiritSoldierMinion;
import lichMinions.SpiritWarriorMinion;
import lichMisc.AbstractLichAbility;

public class SummonSquadAbility extends AbstractLichAbility{

	public SummonSquadAbility(AbstractCharecter owner) {
		super("Summon Spirit Squad", "Summon 20, summon a Spirit Soldier, a Spirit Shieldsman, and a Spirit Warrior. \nCooldown 1", AbilityType.UNKNOWN , owner);
		this.setSummonCost(20);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), 5));
		this.getOwner().addMinion(new SpiritWarriorMinion(this.getOwner(), target, 10));
		this.getOwner().addReduceNextDamageTaken(15);
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Soldier, a Spirit Sheildmen, and a Spirit Warrior.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfSoldier = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritCollectorMinion) {
				amountOfSoldier ++;
			}
		}
		int amountOfSheildmen = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritCollectorMinion) {
				amountOfSheildmen ++;
			}
		}
		int amountOfWarrior = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritCollectorMinion) {
				amountOfWarrior ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Soldier, a Spirit Sheildmen, and a Spirit Warrior. \nCooldown 1" + (amountOfSoldier > 0 || amountOfSheildmen > 0 || amountOfWarrior > 0? "\nCurrent(Respectivly): " + amountOfSoldier + " - " + amountOfSheildmen + " - " + amountOfWarrior: "");
	}

}
