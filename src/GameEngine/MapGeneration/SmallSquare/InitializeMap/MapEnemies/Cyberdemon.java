package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.RocketLauncher;

public class Cyberdemon extends Demon {
    public Cyberdemon(IRoom currentRoom) {
        super("Cyberdemon",currentRoom);
        _equippedWeapon = new RocketLauncher();
        _health = 30;
    }


    @Override
    public String attack(IObjectEntity object) {
        return null;
    }

    @Override
    public int inflict(int damage) throws FatalBlowException {
        takeHealth(damage);
        return damage;
    }
}
