package BigBoss.Abilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Characters.BossEnemy;

public class EmptyAbility extends AbstractAbility{

	public static int identifier = 0;
	
	public EmptyAbility(AbstractCharecter owner) {
		super("Empty " + identifier, AbilityType.UNKNOWN,  owner);
		identifier++;
	}

	@Override
	public String use(AbstractCharecter target) {
		return "Nothing happened";
	}
	
	@Override
	public boolean canSelect() {
		return false;
	}

}
