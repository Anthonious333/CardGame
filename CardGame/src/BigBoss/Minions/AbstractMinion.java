package BigBoss.Minions;

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
}
