package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.WrongKeyException;

public interface IKey<T> {
    void use(T target) throws WrongKeyException;
}
