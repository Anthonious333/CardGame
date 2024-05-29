package BigBoss;

import BigBoss.MrBasicAbilities.Punch;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class MrBasic extends AbstractCharecter{

	public MrBasic() {
		super("Mr. Basic");
		this.addStats(
				new Stat("ATK", 100), 
				new Stat("HP", 100, 0, 100)
				);
		this.addAbility(new Punch(), 0);
		this.addStatPoints(10);
		this.setPosibleAbilities();
				
		MightMod might1 = new MightMod(null, 1, .10, this);
		MightMod might2 = new MightMod(might1, 2, .25, this);
		MightMod might3 = new MightMod(might2, 3, .5, this);
		MightMod might4 = new MightMod(might3, 4, 1, this);

		 might1.setNext(might2);
		 might2.setNext(might3);
		 might3.setNext(might4);
		 
		this.setMods(might1, might2, might3, might4);
	}

	@Override
	public int getStat(String ID) {
		double mightPower = 0;
		
		if (ID.equals("ATK")) {
			for (AbstractModification m : this.getMods()) {
				if (m.getClass() == MightMod.class && m.isUnlocked()) {
					mightPower += (this.findInfo(ID).getValue() * m.getMagicNumber());
				}
			}
		}
		return super.getStat(ID) + (int)mightPower;
	}
	
	
		
}
