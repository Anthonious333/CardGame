package BigBoss.Animations;

import BigBoss.BigBossGame1;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ReviveAnimation extends JumpAnimation{

	Rectangle goldenBox = new Rectangle(BigBossGame1.HOLDER_WIDTH, BigBossGame1.HOLDER_HEIGHT);
	Label reviveText = new Label("REVIVE");
	AnchorPane goldenEffect = new AnchorPane(goldenBox, reviveText);
	FadeTransition fade = new FadeTransition(Duration.seconds(.5), goldenBox);
	TranslateTransition move = new TranslateTransition(Duration.seconds(1), goldenEffect);

	
	public ReviveAnimation(Pane subject) {
		super(5, 1);
		this.setSubject(subject);
		fade.setAutoReverse(true);
		fade.setFromValue(0.0);
		fade.setToValue(0.5);
		goldenBox.setFill(Color.GOLD);
		reviveText.setFont(Font.font(BigBossGame1.FONT, BigBossGame1.MENU_FONT_SIZE));
		reviveText.setTextFill(Color.BLACK);
		AnchorPane.setTopAnchor(reviveText, BigBossGame1.HOLDER_HEIGHT / 2.0);
		AnchorPane.setLeftAnchor(reviveText, BigBossGame1.HOLDER_WIDTH / 3.0);

		this.setOnFinished(event -> this.getSubject().getChildren().remove(goldenEffect));
	}
	
	
	@Override
	public void play() {
		super.play();
		this.getSubject().getChildren().add(goldenEffect);
		goldenEffect.setLayoutX((this.getSubject().getChildren().get(0).getLayoutX()));
		goldenEffect.setLayoutY((this.getSubject().getChildren().get(0).getLayoutY()));
		move.setFromY((this.getSubject().getChildren().get(0).getLayoutY()));
		move.setToY((this.getSubject().getChildren().get(0).getLayoutY()) - 100);
		fade.play();
		move.play();
	}
	
	@Override
	protected void interpolate(double frac) {
		super.interpolate(frac);
		
	}
}
