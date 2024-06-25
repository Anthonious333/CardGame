package BigBoss.Characters;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import BigBoss.Abilities.*;
import BigBoss.Mods.BulkMod;
import BigBoss.Mods.MightMod;
import BigBoss.Mods.OnePunchMod;
import BigBoss.Mods.OriginMod;
import BigBoss.Mods.ReviveMod;

public class MrBasic extends AbstractCharecter{

	private int dodgeAmount = 0;
	private boolean revives = false;
	
	public MrBasic() {
		super("Mr. Basic");
		this.addStatsToList(
				new Stat("ATK", 1125), 
				new Stat("HP", "Dont let it drop!", 750, 0, 750, true)
				);
		this.addRollTokens(100);
		this.addStatPoints(10);
		AbstractAbility punch = new PunchAbility(this);
		AbstractAbility kick = new KickAbility(this);
		AbstractAbility avaid = new AvaidAbility(this);

		this.setPosibleAbilities(
				punch,
				kick,
				avaid,
				new ParryAbility(this),
				new UppercutAbility(this),
				new JabAbility(this)
				);
		this.equipAbility(punch, 0);
		this.equipAbility(kick, 1);
		this.equipAbility(avaid, 2);

		
		OriginMod start = new OriginMod("Mr . Basic\nOrigin", null, this);
		
		BulkMod bulk1 = new BulkMod(start, 1, 50, 100, this, false);
		BulkMod bulk2 = new BulkMod(bulk1, 2, 100, 250, this);
		BulkMod bulk3 = new BulkMod(bulk2, 3, 100, 500, this);
		BulkMod bulk4 = new BulkMod(bulk3, 4, 250, 1000, this);
		ReviveMod revive = new ReviveMod(bulk4, this);
		
		MightMod might1 = new MightMod(start, 1, .10, this, false);
		MightMod might2 = new MightMod(might1, 2, .15, this);
		MightMod might3 = new MightMod(might2, 3, .25, this);
		MightMod might4 = new MightMod(might3, 4, .50, this);
		OnePunchMod onePunch = new OnePunchMod(might4, this);

		start.setNext(might1, bulk1);
		might1.setNext(might2);
		might2.setNext(might3);
		might3.setNext(might4);
		might4.setNext(onePunch);
		
		bulk1.setNext(bulk2);
		bulk2.setNext(bulk3);
		bulk3.setNext(bulk4);
		bulk4.setNext(revive);
		 
		this.setMods(start, might1, might2, might3, might4, bulk1, bulk2, bulk3, bulk4, onePunch, revive);
		
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
	public int damage (int amount, boolean physical) {
		if (dodgeAmount < 0) {
			dodgeAmount = 0;
			return super.damage(0, physical);
		}
		amount -= dodgeAmount;
		dodgeAmount = 0;
		return super.damage(amount, physical);
	}
	
	@Override
	public void setDead(boolean b) {
		if (b && this.revives) {
			this.findStat("HP").reset();
			revives = false;
			return;
		}
		super.setDead(b);
	}
	
	@Override
	public void reset() {
		super.reset();
		this.dodgeAmount = 0;
		for (AbstractModification m : this.getMods()) {
			if (m instanceof ReviveMod && m.isUnlocked()) {
				this.setRevives(true);
			}
		}
	}

	@Override
	protected Object clone() {
		return new MrBasic();
	}

	public int getDodgeAmount() {
		return dodgeAmount;
	}

	public void setDodgeAmount(int dodgeAmount) {
		this.dodgeAmount = dodgeAmount;
	}

	public boolean revives() {
		return revives;
	}

	public void setRevives(boolean revives) {
		this.revives = revives;
	}


	
		
}
