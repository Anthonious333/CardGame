package mrBasicAbilities;

import BigBoss.AbilityType;
import BigBoss.AbstractAbility;
import BigBoss.AbstractCharecter;
import BigBoss.Animations.AttackAnimation;
import mrBasicCharecter.MrBasic;
import theBossCharecter.BossEnemy;


public class ParryAbility extends AbstractAbility{

	public ParryAbility(AbstractCharecter owner) {
		super("Parry", "If the target intends to attack, dodge the next instance of physical damage and if you did, deal half your ATK back.\nCooldown 2.", AbilityType.ATTACK_PHYSICAL_DEFEND, owner);
		if (owner instanceof BossEnemy) {
			this.setAnimation(new AttackAnimation(true, .5));
		} else {
			this.setAnimation(new AttackAnimation(false, .5));
		}
	}

	@Override
	public String use(AbstractCharecter target) {
		if (((BossEnemy)target).getIntent().name().contains("ATTACK_PHYSICAL")) {
			((MrBasic) getOwner()).setDodgeAmount(-1);
			this.setCooldown(2);
			return this.getOwner().getName() + " has dodged " + target.getName() + "'s attack and dealt " + target.damage(this.getOwner().getStat("ATK") / 2, true) + " damage back!";
		}
		return target.getName() + " dose not intend to physically attack. " + this.getOwner().getName() + " did nothing.";
	}

	@Override
	public String getToolTip() {
		return super.getToolTip() + (((MrBasic) getOwner()).getDodgeAmount() != 0? 
				"\nDodging " + (((MrBasic) getOwner()).getDodgeAmount() < 0? "next damage instance" : ((MrBasic) getOwner()).getDodgeAmount()) 
						: "");
	}
	
}
