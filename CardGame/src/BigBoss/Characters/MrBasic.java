package BigBoss.Characters;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import BigBoss.Abilities.EmptyAbility;
import BigBoss.Abilities.PunchAbility;
import BigBoss.Mods.BulkMod;
import BigBoss.Mods.MightMod;
import BigBoss.Mods.OriginMod;
import javafx.scene.image.Image;

public class MrBasic extends AbstractCharecter{

	public MrBasic() {
		super("Mr. Basic");
		this.addStatsToList(
				new Stat("ATK", 25), 
				new Stat("HP", "Dont let it drop!", 50, 0, 50, true)
				);
		this.addRollTokens(100);
		this.addStatPoints(10);
		AbstractAbility punch = new PunchAbility(this);
		this.setPosibleAbilities(punch, new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this), new EmptyAbility(this));
		this.equipAbility(punch, 0);
		
		OriginMod start = new OriginMod("Mr . Basic\nOrigin", null);
		
		BulkMod bulk1 = new BulkMod(start, 1, 50, 100, this, false);
		BulkMod bulk2 = new BulkMod(bulk1, 2, 100, 250, this);
		BulkMod bulk3 = new BulkMod(bulk2, 3, 100, 500, this);
		BulkMod bulk4 = new BulkMod(bulk3, 4, 250, 1000, this);
		
		MightMod might1 = new MightMod(start, 1, .10, this, false);
		MightMod might2 = new MightMod(might1, 2, .15, this);
		MightMod might3 = new MightMod(might2, 3, .25, this);
		MightMod might4 = new MightMod(might3, 4, .50, this);

		start.setNext(might1, bulk1);
		might1.setNext(might2);
		might2.setNext(might3);
		might3.setNext(might4);
		
		bulk1.setNext(bulk2);
		bulk2.setNext(bulk3);
		bulk3.setNext(bulk4);
		 
		this.setMods(start, might1, might2, might3, might4, bulk1, bulk2, bulk3, bulk4);
		
	}

	@Override
	public int getStat(String ID) {
		double ret = 0;
		
		if (ID.equals("ATK")) {
			for (AbstractModification m : this.getMods()) {
				if (m.getClass() == MightMod.class && m.isUnlocked()) {
					ret += (super.getStat(ID) * m.getMagicNumber());
				}
			}
		}
		return super.getStat(ID) + (int)ret;
	}

	@Override
	protected Object clone() {
		return new MrBasic();
	}


	
		
}
