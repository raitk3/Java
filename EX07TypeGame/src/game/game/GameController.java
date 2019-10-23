package game.game;

import game.common.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameController extends BaseController {
    public Button backToMenu;
    private List<String> alphabet = new ArrayList<>();
    private int score;
    @FXML
    private Label label1;
    private String letter1;
    @FXML
    private Label label2;
    private String letter2;
    @FXML
    private Label label3;
    private String letter3;
    @FXML
    public Label scoreText;
    public Random random = new Random();
    public void setText(Label label, String text) {
        label.setText(text);
    }
    public void returnToFront() throws IOException {
        game.changeScene("menu");
    }
    private void generateAlphabet() {
        String[] alphabetLetters = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        this.alphabet.addAll(Arrays.asList(alphabetLetters));

    }
    public void removeLetter(Label label, String letter) {
        setText(label, "");
        letter = null;
        checkLetters();
    }
    public void setNewLetter(Label label, String letter) {
        if (this.alphabet.size() == 0) generateAlphabet();
        int randomInt = random.nextInt(this.alphabet.size());
        letter = alphabet.get(randomInt);
        setText(label, letter);
        this.alphabet.remove(randomInt);
    }
    public void checkLetters() {
        if (letter1 == null) setNewLetter(label1, letter1);
        if (letter2 == null) setNewLetter(label2, letter2);
        if (letter3 == null) setNewLetter(label3, letter3);
    }
    public void initialize() {
        score = 0;
        generateAlphabet();
        checkLetters();
        scoreText.setText(Integer.toString(score));
    }
}
