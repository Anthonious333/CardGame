package lichAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.InfernoAnimation;
import lichMisc.AbstractLichAbility;

public class SummonSpiritFamiliarAbility extends AbstractLichAbility{
	
	private final int HP_AMOUNT = 15;

	public SummonSpiritFamiliarAbility(AbstractCharecter owner) {
		super("Summon Spirit Familiar", "Summon 6, gain 5 ATK and 15 HP", AbilityType.BUFF , owner);
		this.setSummonCost(6);
		this.setMagicNumber(5);
	}

	@Override
	public String use(AbstractCharecter target) {
		this.getOwner().findStat("ATK").addTempValue((int) this.getMagicNumber());
		this.getOwner().findStat("HP").addTempValue(HP_AMOUNT);
		return this.getOwner().getName() + " payed " + paySouls(this.getSummonCost()) + " to gain " + (int)this.getMagicNumber() + " ATK and " + HP_AMOUNT + " HP.";
	}
	
}
