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
	public Group getSkillTreeLayout(Button back) {
		Group group = new Group();
		
		Button btn1 = new Button(this.getMods().get(0).getName());
		Button btn2 = new Button(this.getMods().get(1).getName());
		Button btn3 = new Button(this.getMods().get(2).getName());
		Button btn4 = new Button(this.getMods().get(3).getName());

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
