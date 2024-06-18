package BigBoss.Mods;

import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;

public class MightMod extends AbstractModification{

	private int level;
	private AbstractCharecter owner;
	private double magicNumber;
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner) {
		this(last, level, magicNumber, owner, true);
	}
	
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner, boolean locks) {
		super("Might " + level, last, locks);
		this.level = level;
		this.setMagicNumber(magicNumber);
		this.owner= owner;
	}
	@Override
	public boolean isUnlockConditionMet() {
		if (owner.getStat("ATK") >= magicNumber * 100) {
			return true;
		}
		return false;
	}

}
