package BigBoss.Abilities;

import BigBoss.Characters.MrBasic;
import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BigBossGame1;

public class AvaidAbility extends AbstractAbility{

	public AvaidAbility( AbstractCharecter owner) {
		super("Avaid", "50% chance to doge the next instance of damage.", AbilityType.DEFEND, owner);
	}

	@Override
	public String use(AbstractCharecter target) {
		if (BigBossGame1.randomNumber(0,1) == 0) {
			((MrBasic) getOwner()).setDodgeAmount(-1);
			return "The ability succeded";
		} else {
			return "The ability failed";			
		}
		
	}
	
	@Override
	public String getToolTip() {
		return super.getToolTip() + (((MrBasic) getOwner()).getDodgeAmount() != 0? 
				"\nDodging " + (((MrBasic) getOwner()).getDodgeAmount() < 0? "next damage instance" : ((MrBasic) getOwner()).getDodgeAmount()) 
						: "");
	}

}
