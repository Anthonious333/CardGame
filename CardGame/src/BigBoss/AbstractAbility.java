package BigBoss;


public abstract class AbstractAbility {
	
	private String name;
	private AbstractCharecter owner;
	private boolean unlocked;
	private boolean equiped;
	
	public AbstractAbility(String name, AbstractCharecter owner) {
		this.setName(name);
		this.setOwner(owner);
		this.setUnlocked(false);
		this.setEquiped(false);
	}

	public abstract void use(BossEnemy target);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString () {
		return name;
	}

	public AbstractCharecter getOwner() {
		return owner;
	}

	public void setOwner(AbstractCharecter owner) {
		this.owner = owner;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
