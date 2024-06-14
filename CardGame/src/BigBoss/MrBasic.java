package BigBoss;

import BigBoss.Abilities.EmptyAbility;
import BigBoss.Abilities.PunchAbility;
import javafx.scene.image.Image;

public class MrBasic extends AbstractCharecter{

	public MrBasic() {
		super("Mr. Basic");
		this.addStatsToList(
				new Stat("ATK", 100), 
				new Stat("HP", "Dont let it drop!", 100, 0, 100, true)
				);
		this.addRollTokens(100);
		//TODO fix this, default ability should be a moethod of some sort or param 
		this.addStatPoints(10);
		AbstractAbility punch = new PunchAbility(this);
		this.setPosibleAbilities(punch, new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this));
		this.equipAbility(punch, 0);
		
		
		MightMod might1 = new MightMod(null, 1, .10, this);
		MightMod might2 = new MightMod(might1, 2, .15, this);
		MightMod might3 = new MightMod(might2, 3, .25, this);
		MightMod might4 = new MightMod(might3, 4, .50, this);

		 might1.setNext(might2);
		 might2.setNext(might3);
		 might3.setNext(might4);
		 
		this.setMods(might1, might2, might3, might4);
	}

	@Override
	public int getStat(String ID) {
		double mightPower = 0;
		
		if (ID.equals("ATK")) {
			for (AbstractModification m : this.getMods()) {
				if (m.getClass() == MightMod.class && m.isUnlocked()) {
					mightPower += (super.getStat(ID) * m.getMagicNumber());
				}
			}
		}
		return super.getStat(ID) + (int)mightPower;
	}

	@Override
	protected Object clone() {
		return new MrBasic();
	}


	
		
}
