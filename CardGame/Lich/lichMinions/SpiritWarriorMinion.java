package lichMinions;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import BigBoss.Animations.JumpAnimation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import lichCharecter.Lich;
import theBossCharecter.BossEnemy;

public class SpiritWarriorMinion extends AbstractMinion{

	private AbstractCharecter target;
	
	public SpiritWarriorMinion(AbstractCharecter owner, AbstractCharecter target, int power) {
		super("Spirit Warrior", owner);
		this.setTarget(target);
		this.setSelfImage(new Pane(new ImageView(new Image(getClass().getResource("/images/SpiritWarrior.png").toString()))));
		this.setMagicNumber(power);
	}
	
	@Override
	public String atEndOfPlayerTurn(AbstractCharecter charecter, BossEnemy boss) {
		this.setAnimation(new AttackAnimation(false, .5));
		this.getSelfImage().toFront();
		this.getTarget().damage((int) this.getMagicNumber(), false);
		this.setAnimationAtNextKeyTime(this.getAnimation());
		this.setDelayAtNextKeyTime(this.getAnimation().getTotalDuration().toSeconds());
		return this.getName() + " did " + (int)this.getMagicNumber() + " damage to " + this.getTarget().getName() + ".";
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

	public AbstractCharecter getTarget() {
		return target;
	}

	public void setTarget(AbstractCharecter target) {
		this.target = target;
	}

}
