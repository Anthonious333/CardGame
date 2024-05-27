package BigBoss;

public class MightMod extends AbstractModification{

	private int level;
	private AbstractCharecter owner;
	private double magicNumber;
	public MightMod(AbstractModification last, int level, double magicNumber, AbstractCharecter owner) {
		super("Might " + level, last);
		this.level = level;
		this.setMagicNumber(magicNumber);
		this.owner= owner;
	}
	@Override
	public boolean isUnlockable() {
		if (owner.getStat("ATK") >= magicNumber * 100) {
			return true;
		}
		return false;
	}

}
