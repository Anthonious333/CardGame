package BigBoss;

public class EmptyAbility extends AbstractAbility{

	public EmptyAbility(AbstractCharecter owner) {
		super("Empty", owner);
		this.setUnlocked(true);
	}

	@Override
	public void use(BossEnemy target) {

	}

}
