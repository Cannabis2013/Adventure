package GameEngine.Player;

import GameEngine.Contracts.IObjectEntity;

public class PlayerObject implements IObjectEntity {

    @Override
    public int id() {
        return 0;
    }

    @Override
    public String title() {
        return "Player";
    }
}
