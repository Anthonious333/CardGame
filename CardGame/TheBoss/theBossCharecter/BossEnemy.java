package theBossCharecter;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;
import BigBoss.Stat;
import BigBoss.Abilities.*;
import theBossAbilities.HealAbility;
import theBossAbilities.PowerUpAbility;
import theBossAbilities.PunchAbility;

public class BossEnemy extends AbstractCharecter{

	private AbstractAbility nextMove;
	private int level;
	private boolean cantrip = false;
	
	public BossEnemy(int level) {
		super("The Boss");
		this.addStatsToList(
				new Stat("ATK", 1), 
				new Stat("HP", 100, 0, 100, true)
				);
		for (Stat s : this.getStats()) {
			s.setValue((int) (s.getValue() * Math.pow(2, level)));
		}
		this.level = level;
		this.setPosibleAbilities(new PunchAbility(this), new HealAbility(this, 10), new PowerUpAbility(this, 10));
		for (AbstractAbility a : getPosibleAbilities()) {
			a.setUnlocked(true);
		}
		choseNestMove();
	}
	
	public String play(AbstractCharecter player) {
		if (cantrip) {
			cantrip = !cantrip;
			return new CantripAbility(this).use(player);
		}
		String ret = nextMove.use(player);
		choseNestMove();
		return ret;			
	}

	public AbilityType getIntent() {
		return this.getNextMove().getIntent();
	}
	
	public void choseNestMove () {
		boolean deciding;
		do {
			int i = BigBossGame1.randomNumber(0, getPosibleAbilities().size() - 1);
			
			if (this.getPosibleAbilities().get(i).canSelect() ) {
				deciding = false;
				nextMove = this.getPosibleAbilities().get(i);
			} else {
				deciding = true;				
			}
			
		} while(deciding);
			
	}
	

	public AbstractAbility getNextMove() {
		return nextMove;
	}

	public void setNextMove(AbstractAbility nextMove) {
		this.nextMove = nextMove;
	}
	
	public void cantrip(AbstractAbility source) {
		source.setCooldown(-1);
		this.cantrip = true;
	}
	
	@Override
	protected Object clone() {
		return new BossEnemy(this.level);
	}

	public String getIntentName() {
		return this.getNextMove().getIntentName();
	}

	
	
}
