package lichMisc;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class SortOfSecTrans {

	private ArrayList<Animation> animations = new ArrayList<Animation>();
	
	public SortOfSecTrans(Animation...animations ) {
		for (Animation a : animations) {
			this.animations.add(a);
		}
	}
	
	public void play() {
		if (!animations.isEmpty()) {
		TranslateTransition starter = new TranslateTransition(Duration.ZERO);
		starter.setOnFinished(event -> animations.get(0).play());
		TranslateTransition ender = new TranslateTransition(animations.get(0).getTotalDuration(), new Rectangle());
		ender.setOnFinished(event -> {
			animations.get(0).stop();
			animations.remove(0);
			play();
		});
		ParallelTransition parTrans = new ParallelTransition(starter, ender);
		parTrans.play();
		}
	}
	
	public void add(Animation a) {
		animations.add(a);
	}
}
