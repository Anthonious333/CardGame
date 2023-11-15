package gitsAndShiggels.WrathCards;

import java.util.ArrayList;

import gitsAndShiggels.AbstractCard;
import gitsAndShiggels.Aspects;

public class Gorg extends AbstractCard{

	public Gorg(ArrayList<AbstractCard> location) {
		super("Gorg", 0, "Troll", "", 2, 4, location, Aspects.WRATH);
	}
}
