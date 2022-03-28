package GameEngine.Player;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.MeleeWeapon;

public class KnuckleBusterWithVolts extends MeleeWeapon {
    public KnuckleBusterWithVolts() {
        super("knuckle buster", "electric knuckle buster");
        _damage = 2;
    }

    @Override
    public int attack(IObjectEntity targetObject) throws FatalBlowException, InvalidObjectException {
        if(targetObject == null)
            return 0;
        if(targetObject instanceof IInflictable)
            return ((IInflictable) targetObject).inflict(1);
        else
            throw new InvalidObjectException();
    }

    @Override
    public String sound() {
        return "klask";
    }

}
