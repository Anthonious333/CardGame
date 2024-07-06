package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import lichMinions.AbstractMinion;
import lichMinions.SpiritSheildmenMinion;
import lichMinions.SpiritSoldierMinion;
import lichMisc.AbstractLichAbility;
import theBossCharecter.BossEnemy;

public class SummonSpiritSheildmenAbility extends AbstractLichAbility{

	public SummonSpiritSheildmenAbility(AbstractCharecter owner) {
		super("Summon Spirit Sheildmen", "Summon 7, Summon Spirit Sheildmen", AbilityType.UNKNOWN, owner);
		this.setMagicNumber(5);
		this.setSummonCost(7);
	}

	@Override
	public String use(AbstractCharecter target) {
		((BossEnemy)target).cantrip(this);
		this.getOwner().addMinion(new SpiritSheildmenMinion(this.getOwner(), (int)this.getMagicNumber()));
		this.getOwner().addReduceNextDamageTaken((int)this.getMagicNumber());
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " souls to summon a Spirit Sheildmen.";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritSheildmenMinion) {
				amountOfThis ++;
			}
		}
		return "Summon " + this.getSummonCost() + ", Summon a Spirit Sheildmen." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

	
}
