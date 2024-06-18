package BigBoss.Characters;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;
import BigBoss.Stat;
import BigBoss.Abilities.HealAbility;
import BigBoss.Abilities.PowerUpAbility;
import BigBoss.Abilities.PunchAbility;

public class BossEnemy extends AbstractCharecter{

	private AbstractAbility nextMove;
	private int level;
	
	public BossEnemy(int level) {
		super("The Boss");
		this.addStatsToList(
				new Stat("ATK", 50), 
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

	@Override
	protected Object clone() {
		return new BossEnemy(this.level);
	}

	
	
}
