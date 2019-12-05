package sample.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shaker {
    private TranslateTransition translateTransition;
    private TranslateTransition translatesecondTransition;

    public Shaker(Node node) {
        translateTransition =  new TranslateTransition(Duration.millis(50), node);
        translateTransition.setFromX(0f);
        translateTransition.setByX(10f);
        translateTransition.setCycleCount(5);
        translateTransition.setAutoReverse(true);
    }
    public void shake(){
        translateTransition.playFromStart();
    }

    public Shaker(Node node, Node node1) {
        translateTransition =  new TranslateTransition(Duration.millis(50), node);
        translateTransition.setFromX(0f);
        translateTransition.setByX(10f);
        translateTransition.setCycleCount(5);
        translateTransition.setAutoReverse(true);


        translatesecondTransition =  new TranslateTransition(Duration.millis(50), node1);
        translatesecondTransition.setFromX(0f);
        translatesecondTransition.setByX(10f);
        translatesecondTransition.setCycleCount(5);
        translatesecondTransition.setAutoReverse(true);

    }
    public void shakeBoth(){
        translateTransition.playFromStart();
        translatesecondTransition.playFromStart();
    }
}
