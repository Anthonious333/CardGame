package lichMinions;

import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import theBossCharecter.BossEnemy;

public class SpiritCollectorMinion extends AbstractMinion{

	public SpiritCollectorMinion(AbstractCharecter owner) {
		super("Spirit Collector", owner);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritCollector.png").toString()))));
		this.setMagicNumber(0);
		this.setAnimation(new AttackAnimation(false, .5));
	}
	
	@Override
	public String atEndOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		this.getSelfImage().toFront();
		this.setMagicNumber(this.getMagicNumber() + 1);
		this.setAnimationAtNextKeyTime(this.getAnimation());
		this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
		return this.getName() + " Collected " + this.getOwner().addStat("SOULS", (int)this.getMagicNumber()) + " souls.";
	}

}
