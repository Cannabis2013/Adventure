package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapEnemies;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Ranged.AK47;
import GameEngine.MapGeneration.SmallSquare.Map.MapObject;

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
    public String attack(IObjectEntity object) throws InvalidObjectException, FatalBlowException {
        return String.format("%d",_equippedWeapon.attack(object));
    }
}
