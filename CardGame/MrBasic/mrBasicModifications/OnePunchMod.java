package mrBasicModifications;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import mrBasicAbilities.TheOnePunchAbility;

public class OnePunchMod extends AbstractModification{

	
	public OnePunchMod(AbstractModification last, AbstractCharecter owner) {
		super("One Punch", last, owner);
		this.setOwner(owner);
		this.setMagicNumber(1000);
	}

	@Override
	public boolean isUnlockConditionMet() {
		if (this.getOwner().getStat("ATK") >= this.getMagicNumber()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void onUnlock() {
		this.getOwner().getPosibleAbilities().add(new TheOnePunchAbility(this.getOwner()));
		
	}
	
	@Override
	public String getToolTip() {
		return "Gain the ability to unlock The One Punch" + (this.isUnlocked()? "" : "\n" + this.getOwner().getStat("ATK") + "/" + (int)this.getMagicNumber());
	}


}
