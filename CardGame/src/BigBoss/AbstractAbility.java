package BigBoss;


public abstract class AbstractAbility {
	
	private String name;
	private AbstractCharecter owner;
	private boolean unlocked;
	private boolean equiped;
	//intedded for boss and canselect
	private int roleDifficulty;
	private int roleNumber;
	private String intent;
	
	public AbstractAbility(String name, String intent, AbstractCharecter owner) {
		this.setName(name);
		this.setOwner(owner);
		this.setUnlocked(false);
		this.setEquiped(false);
		this.setRoleDifficulty(0);
		this.setRoleNumber(0);
		this.setIntent(intent);
	}

	public abstract String use(AbstractCharecter target);
	

	//to make it harder / more cinditions for the boss not meant for charecters
	public boolean canSelect () {
		if (roleNumber < roleDifficulty ) {
			roleNumber++;
			return false;
		} else {
			this.setRoleNumber(0);
			return true;
		}
	}

	
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

	public int getRoleDifficulty() {
		return roleDifficulty;
	}

	public void setRoleDifficulty(int roleDifficulty) {
		this.roleDifficulty = roleDifficulty;
	}

	public int getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(int roleNumber) {
		this.roleNumber = roleNumber;
	}

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}
}
