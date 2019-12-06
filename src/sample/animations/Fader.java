package sample.animations;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Fader {



    public void disappearFadeOut(Node node){
        FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1000), node);

        fadeOutTransition.setFromValue(1f);
        fadeOutTransition.setToValue(0f);
        fadeOutTransition.setCycleCount(1);
        fadeOutTransition.setAutoReverse(false);
        fadeOutTransition.play();

    }

    public void appearFadeIn(Node node){
        FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1000), node);

        fadeInTransition.setFromValue(0f);
        fadeInTransition.setToValue(1f);
        fadeInTransition.setCycleCount(1);
        fadeInTransition.setAutoReverse(false);
        fadeInTransition.play();
    }
}
