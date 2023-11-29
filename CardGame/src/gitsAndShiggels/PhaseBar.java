package gitsAndShiggels;

import java.util.Iterator;

import javafx.scene.control.Button;

public class PhaseBar {

	Button 
	startTurnPhase = new Button("Start Turn Button"), 
	drawStep = new Button("Draw Phase"), 
	regenerationPhase = new Button("Regeneration Phase"), 
	actionStep = new Button("Action Step"), 
	endTurnPhase = new Button("End Turn Phase");
	
	//TODO make some way for cards to realize that the phase has changed, 
	Button [] phaseBar = {startTurnPhase, drawStep, regenerationPhase, actionStep, endTurnPhase};
	
	
	
}
