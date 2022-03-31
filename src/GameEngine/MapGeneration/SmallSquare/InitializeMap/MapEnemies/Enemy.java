package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.Player.Character;

public class Enemy extends Character {
    protected Enemy(String title) {
        super(title);
    }

    @Override
    public void die() throws FatalBlowException {
        var weapon = _weapon;
        _weapon = null;
        _currentRoom.addItem(weapon);
        _currentRoom.demons().remove(this);
        throw new FatalBlowException();
    }
}
