package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.FatalBlowException;

public interface IInflictable {
    int inflict(int damage) throws FatalBlowException;
}
