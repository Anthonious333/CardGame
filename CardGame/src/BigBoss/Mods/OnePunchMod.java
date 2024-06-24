package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import BigBoss.Abilities.TheOnePunchAbility;

public class OnePunchMod extends AbstractModification{

	private AbstractCharecter owner;
	
	public OnePunchMod(AbstractModification last, AbstractCharecter owner) {
		super("One Punch", last);
		this.setOwner(owner);
		this.setMagicNumber(1000);
	}

	@Override
	public boolean isUnlockConditionMet() {
		if (this.owner.getStat("ATK") >= this.getMagicNumber()) {
			return true;
		}
		return false;
	}

	public AbstractCharecter getOwner() {
		return owner;
	}

	public void setOwner(AbstractCharecter owner) {
		this.owner = owner;
	}
	
	@Override
	public void onUnlock() {
		this.getOwner().getPosibleAbilities().add(new TheOnePunchAbility(this.getOwner()));
		
	}
	
	@Override
	public String getToolTip() {
		return "Gain the ability to unlock The One Punch" + (this.isUnlocked()? "" : "\n" + owner.getStat("ATK") + "/" + (int)this.getMagicNumber());
	}


}
