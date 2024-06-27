package BigBoss;

import BigBoss.Animations.EmptyAnimation;

public abstract class AbstractAbility extends SAM{
	
	private String name;
	private AbstractCharecter owner;
	private boolean unlocked;
	private boolean equiped;
	private int cooldown;
	private int equipIndex;
	private AbstractAbilityAnimation animation;
	//intedded for boss and canselect
	private int roleDifficulty;
	private int roleNumber;
	private AbilityType intent;
	
	public AbstractAbility(String name, String toolTip, AbilityType intent, AbstractCharecter owner) {
		this.setName(name);
		this.setOwner(owner);
		this.setUnlocked(false);
		this.setEquiped(false);
		this.setRoleDifficulty(0);
		this.setRoleNumber(0);
		this.setIntent(intent);
		this.setToolTip(toolTip);
		this.setCooldown(0);
		this.setEquipIndex(-1);
		this.setAnimation(new EmptyAnimation());
	}

	public AbstractAbility(String name, AbilityType intent, AbstractCharecter owner) {
		this(name, "NONE", intent, owner);
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

	public AbilityType getIntent() {
		return intent;
	}

	public void setIntent(AbilityType intent) {
		this.intent = intent;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	
	public void reduceCooldown(int i) {
		if (this.getCooldown() > -2 && this.isOnCooldown()) {
			this.setCooldown(Math.abs(this.getCooldown()) - i);			
		}
	}
	
	public boolean isOnCooldown () {
		if (cooldown != 0) {
			return true;
		}
		return false;
	}

	public int getEquipIndex() {
		return equipIndex;
	}

	public void setEquipIndex(int equipIndex) {
		this.equipIndex = equipIndex;
	}

	public AbstractAbilityAnimation getAnimation() {
		return animation;
	}

	public void setAnimation(AbstractAbilityAnimation animation) {
		this.animation = animation;
	}
	
}
