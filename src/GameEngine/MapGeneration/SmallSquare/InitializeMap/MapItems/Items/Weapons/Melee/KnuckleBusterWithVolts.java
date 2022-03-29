package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.Melee;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;

public class KnuckleBusterWithVolts extends MeleeWeapon {
    public KnuckleBusterWithVolts() {
        super("electric knuckle buster");
        _damage = 2;
    }

    @Override
    public String sound() {
        return "klask";
    }

}
