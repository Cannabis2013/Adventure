package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.BuildWeapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;

public class Imp extends Demon {


    public Imp(IRoom currentRoom) {
        super("Imp", currentRoom);
        _health = 50;
        _equippedWeapon = new AK47();
    }

    @Override
    public int inflict(int damage) throws FatalBlowException {
        takeHealth(damage);
        return damage;
    }

    @Override
    public String attack(MapObject object) throws InvalidObjectException, FatalBlowException {
        return _equippedWeapon.attack(object);
    }
}
