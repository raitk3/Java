package game.game;

import game.common.BaseController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

public class GameController extends BaseController {
    public Button backToMenu;
    public Button cookie;
    public Button buyClicker;
    public Button buyCursor;

    @FXML
    private Label cursorPriceLabel;
    @FXML
    private Label clickerPriceLabel;
    @FXML
    public Label scoreText;

    private long score = 0;
    private int numberOfCursors = 1;
    private Long cursorPrice = 10L;
    private Long clickerPrice = 50L;
    private int timer = 5000;
    public boolean timelineStart = false;
    private final int cursorPriceJump = 10;
    private final int clickerPriceJump = 50;


    public void startTimeline() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(timer), e -> {
                    System.out.println("Auto click!");
                    cookieClick();
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setText(Label label, String text) {
        label.setText(text);
    }

    public void returnToFront() throws IOException {
        game.changeScene("menu");
    }

    public void cookieClick() {
        score += numberOfCursors;
        setTexts();
        System.out.println("Cookie was clicked! Score is now " + score);
    }
    // helper
    public boolean enoughScore(Long priceToCompareWith) {
        return priceToCompareWith <= score;
    }
    //buy clicker
    public void buyClicker() {
        if (enoughScore(clickerPrice)) {
            if (!timelineStart) {
                startTimeline();
                score -= clickerPrice;
                clickerPrice += clickerPriceJump;
                System.out.println("First clicker was bought!");
                timelineStart = true;
                setTexts();
            } else {
                if (timer > 1000) {
                    score -= clickerPrice;
                    clickerPrice += clickerPriceJump;
                    timer -= 100;
                    if (timer == 1000) {
                        clickerPrice = 0L;
                    }
                    setTexts();
                    System.out.println("A clicker was bought!");
                }
            }
        }
    }

    public void buyCursor() {
        if (enoughScore(cursorPrice)) {
            numberOfCursors += 1;
            score -= cursorPrice;
            cursorPrice += cursorPriceJump;
            setTexts();
            System.out.println("A cursor was bought!");
        }
    }

    public void setTexts() {
        scoreText.setText(Long.toString(score));
        clickerPriceLabel.setText(Long.toString(clickerPrice));
        cursorPriceLabel.setText(Long.toString(cursorPrice));
    }

    public void initialize() {
        setTexts();
    }
}
