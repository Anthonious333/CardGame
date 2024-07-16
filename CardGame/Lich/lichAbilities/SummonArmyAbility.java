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

public class SummonArmyAbility extends AbstractLichAbility{

	public SummonArmyAbility(AbstractCharecter owner) {
		super("Summon Spirit Army", "Summon 30, summon 3 Spirit Soldiers, and 3 Spirit Shieldsman. \nCooldown 2", AbilityType.UNKNOWN , owner);
		this.setSummonCost(30);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.setCooldown(2);
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), 5));
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), 5));
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), 5));
		this.getOwner().addReduceNextDamageTaken(15);
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon 3 Spirit Soldiers, and 3 Spirit Shieldsman.";
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
		
		return "Summon " + this.getSummonCost() + ", summon 3 Spirit Soldiers, and 3 Spirit Shieldsman. \nCooldown 2" + (amountOfSoldier > 0 || amountOfSheildmen > 0? "\nCurrent(Respectivly): " + amountOfSoldier + " - " + amountOfSheildmen: "");
	}

}