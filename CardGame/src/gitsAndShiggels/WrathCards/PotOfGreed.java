package gitsAndShiggels.WrathCards;

import gitsAndShiggels.AbstractActionCard;
import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.Speeds;

public class PotOfGreed extends AbstractActionCard{

	public PotOfGreed() {
		super("Pot Of Greed", 1, "Draw 2 cards", Speeds.FAST, 1, "NONE", Aspects.MEEK);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		this.getPlayer().draw(2);
	}

}
