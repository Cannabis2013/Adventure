package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged.RocketLauncher;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;

public class Cyberdemon extends Demon {
    public Cyberdemon(IRoom currentRoom) {
        super("Cyberdemon",currentRoom);
        _equippedWeapon = new RocketLauncher();
    }


    @Override
    public String attack(MapObject object) {
        return null;
    }

    @Override
    public int inflict(int damage) throws FatalBlowException {
        takeHealth(damage);
        return damage;
    }
}
