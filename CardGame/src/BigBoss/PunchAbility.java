package BigBoss;

public class PunchAbility extends AbstractAbility{

	public PunchAbility(AbstractCharecter owner) {
		super("Punch", owner);
	}

	@Override
	public void use(BossEnemy target) {
		target.damage(this.getOwner().getStat("ATK"));
	}

	
}
