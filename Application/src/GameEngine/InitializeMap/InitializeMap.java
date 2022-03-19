package GameEngine.InitializeMap;

import GameEngine.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.InitializeMap.MapItems.AddMapKeys;
import GameEngine.InitializeMap.MapRestrictions.MapAccessRestrictions;
import GameEngine.BuildMap.Rooms.Room;
import java.util.List;

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private MapAccessRestrictions _restrictMap = new MapAccessRestrictions();
    private AddMapKeys _addKeys = new AddMapKeys();

    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        var keys = _restrictMap.restrict(rooms);
        _addKeys.add(rooms,keys);
    }
}
