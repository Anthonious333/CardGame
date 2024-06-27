package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import BigBoss.Characters.BossEnemy;
import BigBoss.Minions.AbstractMinion;
import BigBoss.Minions.SpiritSoldierMinion;

public class SummonSpiritSoldierAbility extends AbstractLichAbility{

	public SummonSpiritSoldierAbility(AbstractCharecter owner) {
		super("Summon Spirit Soldier", "Summon 5, Summon Spirit Soldier", AbilityType.UNKNOWN, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		((BossEnemy)target).cantrip(this);
		this.getOwner().addMinion(new SpiritSoldierMinion(this.getOwner(), target, 5));
		return this.getOwner().getName() + " Summoned a Spirit Soldier";
	}
	
	@Override
	public String getToolTip() {
		int amountOfThis = 0;
		for (AbstractMinion m :this.getOwner().getMinions()) {
			if (m instanceof SpiritSoldierMinion) {
				amountOfThis ++;
			}
		}
		return "Summon 5, Summon a Spirit Soldier." + (amountOfThis > 0? " Current: " + amountOfThis : "");
	}

}
