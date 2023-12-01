package gitsAndShiggels.WrathCards;

import java.util.ArrayList;

import gitsAndShiggels.AbstractCard;
import gitsAndShiggels.AbstractIdealCard;
import gitsAndShiggels.CardGameEnums.Aspects;
import javafx.scene.control.Button;

public class Gorg extends AbstractIdealCard{

	public Gorg() {
		super("Gorg", 0, "", "Troll", 2, 4, Aspects.WRATH);
	}

	@Override
	public void play() {
		System.out.print("play gorg");
	}
	
}
