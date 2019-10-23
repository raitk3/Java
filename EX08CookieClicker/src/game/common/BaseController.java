package game.common;

import game.Game;

public abstract class BaseController {
    protected Game game;
    public void setGame(Game game) {
        this.game = game;
    }
}
