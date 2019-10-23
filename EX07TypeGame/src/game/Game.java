package game;

import game.common.BaseController;
import game.front.FrontController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("front/front.fxml"));
        Parent root = loader.load();
        FrontController controller = loader.getController();
        controller.setGame(this);
        Scene scene = new Scene(root,600, 400);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;

        scene.getStylesheets().add(getClass().getResource("style.css").toString());
    }

    public void changeScene(String mode) throws IOException {
        String fxmlPath = "";
        if (mode.equals("game")) {
            fxmlPath = "game/game.fxml";
        }
        if (mode.equals("menu")) {
            fxmlPath = "front/front.fxml";
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            BaseController controller = loader.getController();
            controller.setGame(this);
            Scene scene = new Scene(root,600, 400);
            stage.setScene(scene);
    }
    public static void main(String[] args) {
        launch(args);
        // Random comment...
    }
}
