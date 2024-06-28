package BigBoss.Characters;

import java.util.ArrayList;

import BigBoss.AbstractCharecter;
import BigBoss.Stat;
import BigBoss.Minions.*;
import javafx.animation.SequentialTransition;
import BigBoss.Abilities.*;


public class Lich extends AbstractCharecter{

	private int startingSoulValue;
	private ArrayList<AbstractMinion> minions = new  ArrayList<AbstractMinion>();
	
	public Lich() {
		super("Lich");
		this.addStatsToList(
				new Stat("ATK", 10), 
				new Stat("HP", "Dont let it drop!", 35, 0, 35, true),
				new Stat("SOULS", "Whenever YOU(not your minions) damage the target gain half that many souls", 0)
				);
		AbstractLichAbility SummonSpiritSoldierAbility = new SummonSpiritSoldierAbility(this);
		this.setPosibleAbilities(
				SummonSpiritSoldierAbility
				);
		
		this.equipAbility(SummonSpiritSoldierAbility, 0);

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
			if (!m.atEndOfTurnAnimation().equals(null)) {
				secTrans.getChildren().add(m.atEndOfTurnAnimation());
			}
			this.addDelayAtNextKeyTime(m.getDelayAtNextKeyTime());
		}
		secTrans.play();
		return ret;
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
		this.getSelfImage().getChildren().add(minion.getSelfImage());
	}
	
	public void removeMinion(AbstractMinion minion) {
		this.minions.remove(minion);
		this.getSelfImage().getChildren().remove(minion.getSelfImage());
	}
}
