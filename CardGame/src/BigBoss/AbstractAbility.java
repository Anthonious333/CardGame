package BigBoss;

import BigBoss.Animations.EmptyAnimation;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class AbstractAbility extends SAM {
	
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
	private boolean canPlay = true;
	private String cantPlayMessage = "";
	
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

	public boolean canPlay() {
		if (this.isOnCooldown()) {
			return false;
		}
		return canPlay;
	}
	
	public void setCanPlay(boolean canPlay) {
		this.canPlay = canPlay;
	}

	public String getCantPlayMessage() {
		if (this.getCooldown() == -1) {
			return "\nCantrip.";
		}
		if (this.getCooldown() == -2) {
			return "\nDisabled.";
		}
		if (this.getCooldown() > 0) {
			return "\nOn Cooldown: " + this.getCooldown();
		}
		return cantPlayMessage;
	}

	public void setCantPlayMessage(String cantPlayMessage) {
		this.cantPlayMessage = cantPlayMessage;
	}
	
	//returns an image corresponding to the intent type
		public HBox getIntentImage(AbilityType a) {
			String type = a.name();
			HBox images = new HBox();
			if (type.contains("ATTACK_PHYSICAL")) {
				images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
			} else if (type.contains("ATTACK_NON_PHYSICAL")) {
				images.getChildren().add(new ImageView(getClass().getResource("/images/MagicStarSm.png").toString()));
			} else if (type.contains("DEFEND")) {
				images.getChildren().add(new ImageView(getClass().getResource("/images/BlueShieldSm.png").toString()));
			} else if (type.contains("BUFF")) {
				images.getChildren().add(new ImageView(getClass().getResource("/images/GreenArrowSm.png").toString()));
			} else if (type.contains("DEBUFF")) {
				images.getChildren().add(new ImageView(getClass().getResource("/images/PurpleArrowSm.png").toString()));
			} else if (type.contains("UNKNOWN")) {
				//TODO make acc images for this
				images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
			} else {
				images.getChildren().add(new ImageView(getClass().getResource("/images/RedFistSm.png").toString()));
			}
			return images;
		}

		public String getIntentName() {
			return this.getIntent().name();
		}
	
}
