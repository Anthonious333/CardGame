package lichMinions;

import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;
import BigBoss.Stat;
import BigBoss.Animations.InfernoAnimation;
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
	
	@Override
	public String atEndOfPlayerTurn() {
		this.getSelfImage().toFront();
		int chance = BigBossGame1.randomNumber(1, 10);
		if (true) {
			this.setAnimation(new InfernoAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			this.getTarget().damage(20, false);
			if (this.getTarget().hasStat("BURNING")) {
				this.getTarget().addStat("BURNING", 10);
			} else {
				this.getTarget().addStatsToList(new Stat("BURNING", 10));
			}
			return this.getOwner().getName() + " cast INFERNO, dealing " + 20 + " damage and applying " + 10 + " BURNING to " + this.getTarget().getName(); //inferno
		} else if (chance <= 3) {
			//lighning
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
