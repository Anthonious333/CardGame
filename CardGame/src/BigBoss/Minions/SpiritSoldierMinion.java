package BigBoss.Minions;

import BigBoss.AbstractAbilityAnimation;
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
	public String atEndOfPlayerTurn() {
		this.getSelfImage().toFront();
		this.getTarget().damage((int) this.getMagicNumber(), false);
		this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
		return this.getName() + " did " + (int)this.getMagicNumber() + " damage to " + this.getTarget().getName() + ".";
	}

	@Override
	public AbstractAbilityAnimation atEndOfTurnAnimation() {
		return this.getAnimation();
	}
	
	public AbstractCharecter getTarget() {
		return target;
	}

	public void setTarget(AbstractCharecter target) {
		this.target = target;
	}
	
}
