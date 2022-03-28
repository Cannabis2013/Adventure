package GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;

public abstract class MeleeWeapon extends Weapon {

    public MeleeWeapon(String shortTitle, String title) {
        super(shortTitle, title);
    }

    @Override
    public String attack(IObjectEntity target) throws FatalBlowException, InvalidObjectException {
        return null;
    }

    @Override
    public String presentate() {
        return String.format("%s (Damage: %d)", _title, _damage);
    }
}
