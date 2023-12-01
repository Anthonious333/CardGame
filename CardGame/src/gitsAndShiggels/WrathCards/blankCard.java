package gitsAndShiggels.WrathCards;

import gitsAndShiggels.AbstractActionCard;
import gitsAndShiggels.CardGameEnums.Aspects;
import gitsAndShiggels.CardGameEnums.Speeds;

public class blankCard extends AbstractActionCard{

	public blankCard() {
		super("Blank", 0, "Dose nothing", Speeds.SLOW, 1, "none", Aspects.WRATH);
	}

	@Override
	public void play() {
		System.out.print("blank card play ");
		
	}

}
