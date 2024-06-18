package BigBoss.Characters;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import BigBoss.Abilities.EmptyAbility;
import BigBoss.Abilities.PunchAbility;
import BigBoss.Mods.MightMod;
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
		
		MightMod start = new MightMod(null, 0, 0, this);
		
		MightMod might01 = new MightMod(start, 1, .10, this);
		MightMod might02 = new MightMod(might01, 2, .15, this);
		MightMod might03 = new MightMod(might02, 3, .25, this);
		MightMod might04 = new MightMod(might03, 4, .50, this);
		
		MightMod might1 = new MightMod(start, 1, .10, this, false);
		MightMod might2 = new MightMod(might1, 2, .15, this);
		MightMod might3 = new MightMod(might2, 3, .25, this);
		MightMod might4 = new MightMod(might3, 4, .50, this);

		start.setNext(might1, might01);
		might1.setNext(might2);
		might2.setNext(might3);
		might3.setNext(might4);
		
		might01.setNext(might02);
		might02.setNext(might03);
		might03.setNext(might04);
		 
		this.setMods(start, might1, might2, might3, might4, might01, might02, might03, might04);
		
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
		if (ID.equals("HP")) {
			for (AbstractModification m : this.getMods()) {
				if (m.getClass() == BulkMod.class && m.isUnlocked()) {
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
