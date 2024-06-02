package BigBoss;

public class EmptyAbility extends AbstractAbility{

	public static int identifier = 0;
	
	public EmptyAbility(AbstractCharecter owner) {
		super("Empty " + identifier, owner);
		this.setUnlocked(true);
		identifier++;
	}

	@Override
	public void use(BossEnemy target) {

	}

}
