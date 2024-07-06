package lichMisc;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import lichCharecter.Lich;

public abstract class AbstractLichAbility extends AbstractAbility{

	private int summonCost;
	
	public AbstractLichAbility(String name, String toolTip, AbilityType intent, AbstractCharecter owner) {
		super(name, toolTip, intent, owner);
	}
	
	public int litchDamage(AbstractCharecter target, int amount, boolean minion) {
		return litchDamage(target, amount, false, minion);
	}

	public int litchDamage(AbstractCharecter target, int amount, boolean physical, boolean minion) {
		if (minion) {
			this.getOwner().addStat("SOULS", amount / 2);
		}
		return target.damage(amount, physical);
	}
	
	
	public Lich getOwner() {
		return (Lich) super.getOwner();
	}
	
	public boolean canSummon(int amount) {
		if (this.getOwner().getStat("SOULS") >= amount) {
			return true;
		} 
		return false;
	}
	
	public int paySouls(int amount) {
		return this.getOwner().reduceStat("SOULS", amount);
	}

	public int getSummonCost() {
		return summonCost;
	}

	public void setSummonCost(int summonCost) {
		this.summonCost = summonCost;
	}
	
	@Override
	public boolean canPlay() {
		if (!canSummon(getSummonCost())) {
			return false;
		} 
		return super.canPlay();
	}
	
	@Override
	public String getCantPlayMessage() {
		if (!canSummon(getSummonCost())) {
			return "\nInsufficient Souls.";
		} 
		return super.getCantPlayMessage();
	}
	
}
