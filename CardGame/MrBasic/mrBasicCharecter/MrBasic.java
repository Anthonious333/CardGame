package mrBasicCharecter;

import java.util.ArrayList;

import BigBoss.AbstractAbility;
import BigBoss.AbstractAbilityAnimation;
import BigBoss.AbstractCharecter;
import BigBoss.AbstractModification;
import BigBoss.Stat;
import BigBoss.Animations.AbleToParryAnimation;
import BigBoss.Animations.ReviveAnimation;
import javafx.animation.Animation.Status;
import mrBasicAbilities.AvaidAbility;
import mrBasicAbilities.JabAbility;
import mrBasicAbilities.KickAbility;
import mrBasicAbilities.ParryAbility;
import mrBasicAbilities.PunchAbility;
import mrBasicAbilities.UppercutAbility;
import mrBasicModifications.BulkMod;
import mrBasicModifications.MightMod;
import mrBasicModifications.OnePunchMod;
import mrBasicModifications.ReviveMod;
import theBossAbilities.HealAbility;
import theBossCharecter.BossEnemy;

public class MrBasic extends AbstractCharecter{

	private int dodgeAmount = 0;
	private boolean revives = false;
	private AbstractAbilityAnimation parrying;

	
	public MrBasic() {
		super("Mr. Basic");
		this.addStatsToList(
				new Stat("ATK", 25), 
				new Stat("HP", "Dont let it drop!", 50, 0, 50, true)
				);
		AbstractAbility punch = new PunchAbility(this);
		AbstractAbility kick = new KickAbility(this);
		AbstractAbility avaid = new AvaidAbility(this);
		AbstractAbility heal = new HealAbility(this, 10);

		
		this.setPosibleAbilities(
				punch,
				kick,
				avaid,
				new ParryAbility(this),
				new UppercutAbility(this),
				new JabAbility(this),
				heal
				);
		
		this.equipAbility(heal, 0);
		this.equipAbility(kick, 1);
		this.equipAbility(avaid, 2);

		
		BulkMod bulk1 = new BulkMod(null, 1, 50, 100, this, false);
		BulkMod bulk2 = new BulkMod(bulk1, 2, 100, 250, this);
		BulkMod bulk3 = new BulkMod(bulk2, 3, 100, 500, this);
		BulkMod bulk4 = new BulkMod(bulk3, 4, 250, 1000, this);
		ReviveMod revive = new ReviveMod(bulk4, this);
		
		MightMod might1 = new MightMod(null, 1, .10, this, false);
		MightMod might2 = new MightMod(might1, 2, .15, this);
		MightMod might3 = new MightMod(might2, 3, .25, this);
		MightMod might4 = new MightMod(might3, 4, .50, this);
		OnePunchMod onePunch = new OnePunchMod(might4, this);

//		start.setNext(might1, bulk1);
		might1.setNext(might2);
		might2.setNext(might3);
		might3.setNext(might4);
		might4.setNext(onePunch);
		
		bulk1.setNext(bulk2);
		bulk2.setNext(bulk3);
		bulk3.setNext(bulk4);
		bulk4.setNext(revive);
		 
		this.addTree(might1, might2, might3, might4, onePunch);
		this.addTree(bulk1, bulk2, bulk3, bulk4, revive);

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
	
	
	//add revive animation
	@Override
	public void setDead(boolean b) {
		if (b && this.revives) {
			this.findStat("HP").reset();
			revives = false;
			AbstractAbilityAnimation animation = new ReviveAnimation(this.getSelfImage());
			animation.play();
			this.setDelayAtNextKeyTime(animation.getTotalDuration().toSeconds());
			this.addTextAtNextKeyTime(this.getName() + " revived!");
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
	public ArrayList<String> atEndOfTurn(AbstractCharecter charecter, BossEnemy boss) {
		if (this.dodgeAmount != 0) {
			parrying.play();
		} else if (parrying.getStatus() == Status.RUNNING){
			parrying.stop();
		}
		return super.atEndOfTurn(charecter, boss);
	}
	
	@Override
	public ArrayList<String> atStartOfCombat(AbstractCharecter charecter, BossEnemy boss) {
		parrying = new AbleToParryAnimation(this.getSelfImage());
		return super.atStartOfCombat(charecter, boss);
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
