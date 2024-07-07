package lichCharecter;

import java.util.ArrayList;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.AbstractCharecter;
import BigBoss.Stat;
import javafx.animation.SequentialTransition;
import lichAbilities.SummonSpiritFamiliarAbility;
import lichAbilities.SummonSpiritSheildmenAbility;
import lichAbilities.SummonSpiritSoldierAbility;
import lichAbilities.SummonSpiritWarriorAbility;
import lichMinions.*;
import lichMisc.AbstractLichAbility;
import BigBoss.Abilities.*;


public class Lich extends AbstractCharecter{

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

		
		this.setPosibleAbilities(
				SummonSpiritSoldierAbility,
				SummonSpiritShelidmenAbility,
				SummonSpiritWarriorAbility,
				new SummonSpiritFamiliarAbility(this)
				);
		
		this.equipAbility(SummonSpiritSoldierAbility, 0);
		this.equipAbility(SummonSpiritShelidmenAbility, 1);
		this.equipAbility(SummonSpiritWarriorAbility, 2);

		this.addRollTokens(100);
		this.addStatPoints(10000);
	}

	@Override
	public ArrayList<String> atStartOfCombat() {
		startingSoulValue = this.findStat("SOULS").getValue();
		return super.atStartOfCombat();
	}
	
	@Override
	public ArrayList<String> atEndOfCombat() {
		this.findStat("SOULS").setValue(startingSoulValue);
		return super.atEndOfCombat();
	}
	
	@Override
	public ArrayList<String> atEndOfPlayerTurn() {
		ArrayList<String> ret = super.atEndOfPlayerTurn();
		SequentialTransition secTrans = new SequentialTransition();
		for (AbstractMinion m : this.minions) {
			String string = m.atEndOfPlayerTurn();
			if (!string.equals("")) {
				ret.add(string);
			}
			if (m.getAnimationAtNextKeyTime() != null) {
				secTrans.getChildren().add(m.getAnimationAtNextKeyTime());
				m.setAnimationAtNextKeyTime(null);
			}
			
			this.addDelayAtNextKeyTime(m.getDelayAtNextKeyTime());
		}
		secTrans.play();
		return ret;
	}
	
	@Override
	public void onOwnerTakeDamage(int amount, boolean physical) {
		ArrayList<String> ret = this.getTextAtNextKeyTime();
		SequentialTransition secTrans = new SequentialTransition();
		for (AbstractMinion m : this.minions) {
			String string = m.onOwnerTakeDamage(amount, physical);
			if (!string.equals("")) {
				ret.add(string);
			}
			if (m.getAnimationAtNextKeyTime() != null) {
				secTrans.getChildren().add(m.getAnimationAtNextKeyTime());
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
