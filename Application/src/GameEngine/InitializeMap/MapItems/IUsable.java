package GameEngine.InitializeMap.MapItems;

import GameEngine.MapObjects.MapObject;

public interface IUsable {
    String use(MapObject obj) throws InvalidObjectException;
}
