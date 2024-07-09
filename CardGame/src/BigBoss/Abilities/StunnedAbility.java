package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class StunnedAbility extends AbstractAbility{

	public StunnedAbility(AbstractCharecter owner) {
		super("Stunned", "The owner is stunned (dose nothing)", AbilityType.DEBUFF, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		return this.getOwner().getName() + " is STUNNED.";
	}
	
	@Override
	public HBox getIntentImage(AbilityType a) {
		return new HBox(new ImageView(getClass().getResource("/images/StunnedSm.png").toString()));//TODO
	}
	
	@Override
	public String getIntentName() {
		return "STUNNED";
	}

}
