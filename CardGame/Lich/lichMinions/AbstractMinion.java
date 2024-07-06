package lichMinions;

import BigBoss.AbstractAbilityAnimation;
import BigBoss.AbstractCharecter;
import BigBoss.SAM;
import javafx.animation.Animation;
import javafx.scene.layout.Pane;

public abstract class AbstractMinion extends SAM{
	private String name;
	private Pane selfImage;
	private AbstractCharecter owner;
	private AbstractAbilityAnimation animation;
	private AbstractAbilityAnimation animationAtNextKeyTime = null;
	
	public AbstractMinion(String name, AbstractCharecter owner) {
		this.setName(name);
		this.setOwner(owner);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pane getSelfImage() {
		return selfImage;
	}
	public void setSelfImage(Pane selfImage) {
		this.selfImage = selfImage;
	}
	public AbstractCharecter getOwner() {
		return owner;
	}
	public void setOwner(AbstractCharecter owner) {
		this.owner = owner;
	}
	public AbstractAbilityAnimation getAnimation() {
		return animation;
	}
	public void setAnimation(AbstractAbilityAnimation animation) {
		this.animation = animation;
	}
	public AbstractAbilityAnimation atEndOfTurnAnimation() {
		return null;
	}
	public AbstractAbilityAnimation onOwnerTakeDamageAnimation() {
		return null;
	}
	
	@Override
	public String atEndOfTurn() {
		this.getSelfImage().setLayoutX(0);
		return super.atEndOfTurn();
	}
	public AbstractAbilityAnimation getAnimationAtNextKeyTime() {
		return animationAtNextKeyTime;
	}
	public void setAnimationAtNextKeyTime(AbstractAbilityAnimation animationAtNextKeyTime) {
		this.animationAtNextKeyTime = animationAtNextKeyTime;
	}
}
