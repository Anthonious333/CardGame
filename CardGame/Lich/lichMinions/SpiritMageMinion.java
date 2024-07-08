package lichMinions;

import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;
import BigBoss.Stat;
import BigBoss.Animations.InfernoAnimation;
import BigBoss.Animations.LightningAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SpiritMageMinion extends AbstractMinion{

	private AbstractCharecter target;

	
	public SpiritMageMinion(AbstractCharecter owner, AbstractCharecter target) {
		super("Spirit Mage", owner);
		this.setTarget(target);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritSoldier.png").toString())))); //TODO
	}
	
	@SuppressWarnings({ "unused"})
	@Override
	public String atEndOfPlayerTurn() {
		this.getSelfImage().toFront();
		int chance = BigBossGame1.randomNumber(1, 10);
		if (false) {
			this.setAnimation(new InfernoAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getOwner().getName() + " cast INFERNO, dealing " + this.getTarget().damage(20, false) + " damage and applying " + this.getTarget().addStat("BURNING", 10) + " BURNING to " + this.getTarget().getName();
		} else if (true) {
			this.setAnimation(new LightningAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getOwner().getName() + " cast LIGHTNING, applying " + this.getTarget().addStat("STUN", 2) + " STUN to " + this.getTarget().getName(); 
		} else {
			//gust
		}
		return super.atEndOfPlayerTurn();
	}

	public AbstractCharecter getTarget() {
		return target;
	}

	public void setTarget(AbstractCharecter target) {
		this.target = target;
	}

}
