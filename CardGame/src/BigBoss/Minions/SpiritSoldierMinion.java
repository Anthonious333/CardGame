package BigBoss.Minions;

import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;

public class SpiritSoldierMinion extends AbstractMinion{

	private AbstractCharecter target;
	
	public SpiritSoldierMinion(AbstractCharecter owner, AbstractCharecter target, int power) {
		super("Spirit Soldier", owner);
		this.setTarget(target);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritSoldier.png").toString()))));
		this.setMagicNumber(power);
		this.setAnimation(new AttackAnimation(false, .5));
		this.getAnimation().setSubject(getSelfImage());
	}

	@Override
	public void atEndOfPlayerTurn() {
		this.getSelfImage().toFront();
		this.getAnimation().play();
		this.getTarget().damage((int) this.getMagicNumber(), false);
	}

	public AbstractCharecter getTarget() {
		return target;
	}

	public void setTarget(AbstractCharecter target) {
		this.target = target;
	}
	
}
