package GameEngine.Player;

import GameEngine.Contracts.IInflictable;
import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.Weapons.MeleeWeapon;

public class KnuckleBusterWithVolts extends MeleeWeapon {
    public KnuckleBusterWithVolts() {
        super("knuckle buster", "electric knuckle buster");
    }

    @Override
    public String attack(IObjectEntity targetObject) throws FatalBlowException {
        if(targetObject == null)
            return "zzzh";
        if(targetObject instanceof IInflictable)
            ((IInflictable) targetObject).inflict(1);
        return "KAAPOW!!!";
    }
}
