package BigBoss;

import BigBoss.MrBasicAbilities.Punch;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class MrBasic extends AbstractCharecter{

	public MrBasic() {
		super("Mr. Basic");
		this.addStats(
				new Stat("ATK", 5), 
				new Stat("HP", 100, 0, 100)
				);
		this.addAbility(new Punch(), 0);
		
		this.setPosibleAbilities();
				
		Modification might1 = new Modification("Might 1", null);
		Modification might2 = new Modification("Might 2", might1);
		Modification might3 = new Modification("Might 3", might2);
		Modification might4 = new Modification("Might 4", might3);
		Modification might5 = new Modification("Might 5", might3);
		Modification might6 = new Modification("Might 6", might4);
		Modification might7 = new Modification("Might 7", might4);
		Modification might8 = new Modification("Might 8", might5);
		Modification might9 = new Modification("Might 9", might5);
		Modification might61 = new Modification("Might 8", might6);
		Modification might62= new Modification("Might 9", might6);
		Modification might71= new Modification("Might 8", might7);
		Modification might72= new Modification("Might 9", might7);
		Modification might81= new Modification("Might 8", might8);
		Modification might82= new Modification("Might 9", might8);
		Modification might91= new Modification("Might 8", might9);
		Modification might92= new Modification("Might 9", might9);
		 
		 might1.setNext(might2);
		 might2.setNext(might3);
		 might3.setNext(might4, might5);
		 might4.setNext(might6, might7);
		 might5.setNext(might8, might9);
		 might6.setNext(might61, might62);
		 might7.setNext(might71, might72);
		 might8.setNext(might81, might82);
		 might9.setNext(might91, might92);
		 


		
		this.setMods(might1, might2, might3, might4, might5, might6, might7, might8, might9, might61, might62, might71, might72, might81, might82,might91, might92);
	}

	@Override
	public int getStat(String ID) {
		return super.getStat(ID) + (ID.equals("ATK")? 10 : 0);
	} //TODO fix stat as string thingy to make it show the bonus stats
		
}
