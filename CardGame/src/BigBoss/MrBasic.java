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
		 
		 might1.setNext(might2);
		 might2.setNext(might3);
		 might3.setNext(might4);

		
		this.setMods(might1, might2, might3, might4);
	}

	@Override
	public int getStat(String ID) {
		return super.getStat(ID) + (ID.equals("ATK")? 10 : 0);
	} //TODO fix stat as string thingy to make it show the bonus stats
		
	@Override
	public Group getSkillTreeLayout(Button back) {
		Group group = new Group();
		//TODO make say not unlockable
		Button btn1 = new Button(this.getMods().get(0).getName() + (this.getMods().get(0).isUnlocked()? "\nUnlocked" : ""));
		Button btn2 = new Button(this.getMods().get(1).getName() + (this.getMods().get(1).isUnlocked()? "\nUnlocked" : ""));
		Button btn3 = new Button(this.getMods().get(2).getName() + (this.getMods().get(2).isUnlocked()? "\nUnlocked" : ""));
		Button btn4 = new Button(this.getMods().get(3).getName() + (this.getMods().get(3).isUnlocked()? "\nUnlocked" : ""));
		
		btn1.setOnAction(event -> {
			if (!this.getMods().get(0).isUnlocked()) {
				if (this.getMods().get(0).canUnlock() && this.getStat("ATK") >= 10) {
					this.getMods().get(0).unlock();
					btn1.setText(this.getMods().get(0).getName() + "\nUnlocked");
				} else {
					btn1.setText(this.getMods().get(0).getName() + "\nCant Unlock");
				}
			}
		});
		btn2.setOnAction(event -> {
			if (!this.getMods().get(1).isUnlocked()) {
				if (this.getMods().get(1).canUnlock() && this.getStat("ATK") >= 25) {
					this.getMods().get(1).unlock();
					btn2.setText(this.getMods().get(1).getName() + "\nUnlocked");
				} else {
					btn2.setText(this.getMods().get(1).getName() + "\nCant Unlock");
				}
			}
		});
		btn3.setOnAction(event -> {
			if (!this.getMods().get(2).isUnlocked()) {
				if (this.getMods().get(2).canUnlock() && this.getStat("ATK") >= 50) {
					this.getMods().get(2).unlock();
					btn3.setText(this.getMods().get(2).getName() + "\nUnlocked");
				} else {
					btn3.setText(this.getMods().get(2).getName() + "\nCant Unlock");
				}
			}
		});
		btn4.setOnAction(event -> {
			if (!this.getMods().get(3).isUnlocked()) {
				if (this.getMods().get(3).canUnlock() && this.getStat("ATK") >= 100) {
					this.getMods().get(3).unlock();
					btn4.setText(this.getMods().get(3).getName() + "\nUnlocked");
				} else {
					btn4.setText(this.getMods().get(3).getName() + "\nCant Unlock");
				}
			}
		});
	

		Line line1 = new Line(0, 0, 0, SKILL_SIZE);
		Line line2 = new Line(0, 0, 0, SKILL_SIZE);
		Line line3 = new Line(0, 0, 0, SKILL_SIZE);

		line1.setLayoutX(BigBossGame.IMAGE_WIDTH / 2);
		line1.setLayoutY(SKILL_SIZE);
		line2.setLayoutX(BigBossGame.IMAGE_WIDTH / 2);
		line2.setLayoutY(SKILL_SIZE * 3);
		line3.setLayoutX(BigBossGame.IMAGE_WIDTH / 2);
		line3.setLayoutY(SKILL_SIZE * 5);

		btn1.setPrefSize(SKILL_SIZE, SKILL_SIZE);
		btn2.setPrefSize(SKILL_SIZE, SKILL_SIZE);
		btn3.setPrefSize(SKILL_SIZE, SKILL_SIZE);
		btn4.setPrefSize(SKILL_SIZE, SKILL_SIZE);
		
		btn1.setLayoutX((BigBossGame.IMAGE_WIDTH - SKILL_SIZE) / 2);
		btn1.setLayoutY(0);
		btn2.setLayoutX((BigBossGame.IMAGE_WIDTH - SKILL_SIZE) / 2);
		btn2.setLayoutY(SKILL_SIZE * 2);
		btn3.setLayoutX((BigBossGame.IMAGE_WIDTH - SKILL_SIZE) / 2);
		btn3.setLayoutY(SKILL_SIZE * 4);
		btn4.setLayoutX((BigBossGame.IMAGE_WIDTH - SKILL_SIZE) / 2);
		btn4.setLayoutY(SKILL_SIZE *6);
		
		group.getChildren().addAll(btn1, btn2, btn3, btn4, line1, line2, line3, back);
		return group;
	}

}
