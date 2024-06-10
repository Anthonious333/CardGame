package BigBoss.Abilities;

import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.BossEnemy;

public class EmptyAbility extends AbstractAbility{

	public static int identifier = 0;
	
	public EmptyAbility(AbstractCharecter owner) {
		super("Empty " + identifier, owner);
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
