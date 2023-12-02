package gitsAndShiggels.WrathCards;

import gitsAndShiggels.AbstractActionCard;
import gitsAndShiggels.AbstractIdealCard;
import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.Speeds;

public class SakeOfLife extends AbstractActionCard{

	public final static int DAMAGE = 5;
	public final static int DRAW = 1;
	
	public SakeOfLife() {
		super("SakeOfLife", 1, "Deal " + DAMAGE + " damage to your ideal and draw " + DRAW + " card.", Speeds.SLOW, 1, "NONE", Aspects.WRATH);
	}

	@Override
	public void play() {
		((AbstractIdealCard) this.getPlayer().getIdeal().get(0)).takeDamage(DAMAGE);
		this.getPlayer().draw(DRAW);
	}

}
