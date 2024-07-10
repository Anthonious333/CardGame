package lichCharecter;

import java.util.ArrayList;

import BigBoss.AbstractCharecter;
import BigBoss.Stat;
import lichAbilities.*;
import lichMinions.*;
import lichMisc.*;
import theBossCharecter.BossEnemy;
import BigBoss.Abilities.*;


public class Lich extends AbstractCharecter{

	public static final int MINION_WIDTH = 200;
	public static final int MINION_HEIGHT = 350;

	private int startingSoulValue;
	private ArrayList<AbstractMinion> minions = new  ArrayList<AbstractMinion>();
	private int reduceNextDamageTaken;
	
	public Lich() {
		super("Lich");
		this.addStatsToList(
				new Stat("ATK", 10), 
				new Stat("HP", "Dont let it drop!", 35, 0, 35, true),
				new Stat("SOULS", "Whenever YOU(not your minions) damage the target gain half that many souls", 0)
				);
		AbstractLichAbility SummonSpiritSoldierAbility = new SummonSpiritSoldierAbility(this);
		AbstractLichAbility SummonSpiritShelidmenAbility = new SummonSpiritSheildmenAbility(this);
		AbstractLichAbility SummonSpiritWarriorAbility = new SummonSpiritWarriorAbility(this);
		AbstractLichAbility test = new SummonSquadAbility(this);
//TODO new SummonSpiritCollectorAbility(this);
		
		this.setPosibleAbilities(
				SummonSpiritSoldierAbility,
				SummonSpiritShelidmenAbility,
				SummonSpiritWarriorAbility,
				new SummonSpiritFamiliarAbility(this),
				new SummonSpiritMageAbility(this),
				test
				);
		
		this.equipAbility(test, 0);
		this.equipAbility(SummonSpiritShelidmenAbility, 1);
		this.equipAbility(SummonSpiritWarriorAbility, 2);

		this.addRollTokens(100);
		this.addStatPoints(10000);
	}

	@Override
	public ArrayList<String> atStartOfCombat(AbstractCharecter charecter, BossEnemy boss) {
		startingSoulValue = this.findStat("SOULS").getValue();
		return super.atStartOfCombat(charecter, boss);
	}
	
	@Override
	public ArrayList<String> atEndOfCombat(AbstractCharecter charecter, BossEnemy boss) {
		this.findStat("SOULS").setValue(startingSoulValue);
		return super.atEndOfCombat(charecter, boss);
	}
	
	@Override
	public ArrayList<String> atEndOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		ArrayList<String> ret = super.atEndOfPlayerTurn(charecter, boss);
		SortOfSecTrans secTrans = new SortOfSecTrans();
		
		for (AbstractMinion m : this.minions) {
			String string = m.atEndOfPlayerTurn(charecter, boss);
			if (!string.equals("")) {
				ret.add(string);
			}
			if (m.getAnimationAtNextKeyTime() != null) {
				secTrans.add(m.getAnimationAtNextKeyTime());
				m.setAnimationAtNextKeyTime(null);
			}
			
			ArrayList<String> nextKeyTime = m.getTextAtNextKeyTime();
			if (!nextKeyTime.isEmpty()) {
				ret.addAll(nextKeyTime);
			}
			this.addDelayAtNextKeyTime(m.getDelayAtNextKeyTime());
		}
		secTrans.play();
		return ret;
	}
	
	@Override
	public ArrayList<String> atEndOfEnemyTurn(AbstractCharecter charecter, BossEnemy boss) {
		ArrayList<String> ret = super.atEndOfEnemyTurn(charecter, boss);
		if (boss.hasStat("BURNING")) {
			ret.add(boss.getName() + " took " + boss.damage(boss.getStat("BURNING"), false) + " damage from BURNING.");
		}
		if (boss.hasStat("STUN")) {
			boss.setNextMove(new StunnedAbility(boss));
		}
		return ret;
	}
	
	@Override
	public ArrayList<String> atStartOfEnemyTurn(AbstractCharecter charecter, BossEnemy boss) {
		if (boss.hasStat("STUN")) {
			boss.setNextMove(new StunnedAbility(boss));
			boss.reduceStat("STUN", 1);
		}
		return super.atStartOfEnemyTurn(charecter, boss);
	}
	
	@Override
	public void onOwnerTakeDamage(int amount, boolean physical) {
		ArrayList<String> ret = this.getTextAtNextKeyTime();
		SortOfSecTrans secTrans = new SortOfSecTrans();
		
		for (AbstractMinion m : this.minions) {
			String string = m.onOwnerTakeDamage(amount, physical);
			if (!string.equals("")) {
				ret.add(string);
			}
			if (m.getAnimationAtNextKeyTime() != null) {
				secTrans.add(m.getAnimationAtNextKeyTime());
				m.setAnimationAtNextKeyTime(null);
			}
			
			this.addDelayAtNextKeyTime(m.getDelayAtNextKeyTime());
		}
		secTrans.play();
		this.setTextAtNextKeyTime(ret);
		super.onOwnerTakeDamage(amount, physical);
	}
	
	@Override
	protected Object clone() {
		return new Lich();
	}

	public ArrayList<AbstractMinion> getMinions() {
		return minions;
	}

	public void addMinion(AbstractMinion minion) {
		this.minions.add(minion);
		minion.getSelfImage().setLayoutY(BigBoss.BigBossGame1.HOLDER_HEIGHT / 2);
		this.getSelfImage().getChildren().add(minion.getSelfImage());
	}
	
	public void removeMinion(AbstractMinion minion) {
		this.minions.remove(minion);
		this.getSelfImage().getChildren().remove(minion.getSelfImage());
	}
	
	@Override
	public int damage(int amount, boolean physical) {
		int newAmount = amount - this.reduceNextDamageTaken;
		if (newAmount < 0) {
			newAmount = 0;
		}
		reduceNextDamageTaken = 0;
		return super.damage(newAmount, physical);
	}

	@Override
	public void reset() {
		this.getMinions().clear();
		super.reset();
	}
	
	public int getReduceNextDamageTaken() {
		return reduceNextDamageTaken;
	}
	
	public void addReduceNextDamageTaken(int amount) {
		reduceNextDamageTaken += amount;
	}

	public void setReduceNextDamageTaken(int reduceNextDamageTaken) {
		this.reduceNextDamageTaken = reduceNextDamageTaken;
	}
}
