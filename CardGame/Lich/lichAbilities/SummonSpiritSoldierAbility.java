package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritSoldierMinion;
import lichMisc.AbstractLichAbility;
import theBossCharecter.BossEnemy;

public class SummonSpiritSoldierAbility extends AbstractLichAbility{

	public SummonSpiritSoldierAbility(AbstractCharecter owner) {
		super("Summon Spirit Soldier", "Summon 5, Summon Spirit Soldier", AbilityType.UNKNOWN, owner);
		this.setSummonCost(5);
		this.setMagicNumber(5);
	}

	@Override
	public String use(AbstractCharecter target) {
		((BossEnemy)target).cantrip(this);
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, (int) this.getMagicNumber()));
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Sheildmen.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritSoldierMinion) {
				amountOfThis ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Sheildmen." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

}
