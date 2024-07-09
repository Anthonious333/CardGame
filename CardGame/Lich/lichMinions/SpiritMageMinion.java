package lichMinions;

import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;
import BigBoss.Stat;
import BigBoss.Animations.GustAnimation;
import BigBoss.Animations.InfernoAnimation;
import BigBoss.Animations.LightningAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import theBossCharecter.BossEnemy;

public class SpiritMageMinion extends AbstractMinion{

	private AbstractCharecter target;

	
	public SpiritMageMinion(AbstractCharecter owner, AbstractCharecter target) {
		super("Spirit Mage", owner);
		this.setTarget(target);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritMage.png").toString()))));
	}
	
	@Override
	public String atEndOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		this.getSelfImage().toFront();
		int chance = BigBossGame1.randomNumber(1, 10);
		if (chance <= 1) {
			this.setAnimation(new InfernoAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getOwner().getName() + " cast INFERNO, dealing " + this.getTarget().damage(20, false) + " damage and applying " + this.getTarget().addStat("BURNING", 10, true) + " BURNING to " + this.getTarget().getName();
		} else if (chance <= 4) {
			this.setAnimation(new LightningAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getOwner().getName() + " cast LIGHTNING, applying " + this.getTarget().addStat("STUN", 1, true) + " STUN to " + this.getTarget().getName(); 
		} else {
			this.setAnimation(new GustAnimation());
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getOwner().getName() + " cast GUST, dealing " + this.getTarget().damage(10, false) + " damage to " + this.getTarget().getName();
		}
	}

	public AbstractCharecter getTarget() {
		return target;
	}

	public void setTarget(AbstractCharecter target) {
		this.target = target;
	}

}
