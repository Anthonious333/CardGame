package lichMinions;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.JumpAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import lichCharecter.Lich;

public class SpiritSheildmenMinion extends AbstractMinion {

	public SpiritSheildmenMinion(AbstractCharecter owner, int power) {
		super("Spirit Sheildmen", owner);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritSheildsmen.png").toString()))));
		this.setMagicNumber(power);
		this.setAnimation(new JumpAnimation(6, .5));
	}
	@Override
	public String onOwnerTakeDamage(int amount, boolean physical) {
		if (physical) {
			this.setAnimation(new JumpAnimation(6, .5));
			((Lich)this.getOwner()).addReduceNextDamageTaken((int) this.getMagicNumber());
			int amountBlocked = ((Lich)this.getOwner()).reducePreReducedDamage((int) this.getMagicNumber());
			this.getSelfImage().toFront();
			this.setAnimationAtNextKeyTime(this.getAnimation());
			this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
			return this.getName() + " blocked " + amountBlocked + " damage.";
		}
		return "";
	}

	@Override
	public AbstractAbilityAnimation onOwnerTakeDamageAnimation() {
		return this.getAnimation();
	}
}
