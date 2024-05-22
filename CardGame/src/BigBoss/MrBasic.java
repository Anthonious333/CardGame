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

		Line line1 = new Line(0, 0, 0, 100);
		Line line2 = new Line(0, 0, 0, 100);
		Line line3 = new Line(0, 0, 0, 100);

		line1.setLayoutX(100);
		line1.setLayoutY(100);
		line2.setLayoutX(100);
		line2.setLayoutY(300);
		line3.setLayoutX(100);
		line3.setLayoutY(500);

		back.setPrefSize(25, 50);
		btn1.setPrefSize(100, 100);
		btn2.setPrefSize(100, 100);
		btn3.setPrefSize(100, 100);
		btn4.setPrefSize(100, 100);
		
		btn1.setLayoutX(50);
		btn1.setLayoutY(0);
		btn2.setLayoutX(50);
		btn2.setLayoutY(200);
		btn3.setLayoutX(50);
		btn3.setLayoutY(400);
		btn4.setLayoutX(50);
		btn4.setLayoutY(600);
		
		group.getChildren().addAll(btn1, btn2, btn3, btn4, line1, line2, line3, back);
		return group;
	}

}
