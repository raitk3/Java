package game.front;

import game.common.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class FrontController extends BaseController {
    @FXML
    private Label title;

    @FXML
    private Button startButton;

    public void startButtonClick() throws IOException {
        System.out.println("PLAY!!!!");
        try {
            game.changeScene("game");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        System.out.println("init");
    }
}
