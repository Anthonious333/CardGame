package gitsAndShiggels;

import gitsAndShiggels.CardGameEnums.Phases;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class PhaseBar extends GridPane{

	Phase 
	startTurnPhase = new Phase("Start Turn Phase"), 
	drawStep = new Phase("Draw Phase"), 
	regenerationPhase = new Phase("Regeneration Phase"), 
	actionStep = new Phase("Action Step"), 
	endTurnPhase = new Phase("End Turn Phase");
	int currentPhase = 4;
	
	Phase [] phaseBar = {startTurnPhase, drawStep, regenerationPhase, actionStep, endTurnPhase};
	
	public PhaseBar() {
		this.setHgap(15);
		this.add(startTurnPhase, 0, 0);
		this.add(drawStep, 1, 0);
		this.add(regenerationPhase, 2, 0);
		this.add(actionStep, 3, 0);
		this.add(endTurnPhase, 4, 0);
		nextPhase();
	}

	public Phases nextPhase() {
		if (currentPhase < phaseBar.length - 1) {
			phaseBar[currentPhase].setOff();
			currentPhase++;
			phaseBar[currentPhase].setOn();
		} else {
			phaseBar[currentPhase].setOff();
			currentPhase = 0;
			phaseBar[currentPhase].setOn();
		}
		switch(currentPhase) {
		case 0:
			return Phases.STARTTURNPHASE;
		case 1:
			return Phases.DRAWSTEP;
		case 2: 
			return Phases.REGENERATIONPHASE;
		case 3: 
			return Phases.ACTIONSTEP;
		default:
			return Phases.ENDTURNPHASE;
		}
	}
	
}
