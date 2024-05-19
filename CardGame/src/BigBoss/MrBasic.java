package BigBoss;

import BigBoss.MrBasicAbilities.Punch;

public class MrBasic extends AbstractCharecter{

	public MrBasic() {
		super("Mr. Basic");
		this.addStats(
				new Stat("ATK", 5), 
				new Stat("HP", 100, 0, 100)
				);
		this.addAbility(new Punch(), 0);
	}

}
