package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.WrongKeyException;

public interface IUsable<T> {
    void use(T target) throws WrongKeyException;
}
