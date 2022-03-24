package GameEngine.InitializeMap;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.InitializeMap.MapRestrictions.AddAccessRestrictions;
import GameEngine.InitializeMap.Teleporter.AddTeleportDevice;

import java.util.List;

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private AddAccessRestrictions _addAccessRestrictions = new AddAccessRestrictions();
    private AddTeleportDevice _addTeleport = new AddTeleportDevice();

    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        _addAccessRestrictions.add(rooms);
        _addTeleport.add(rooms);
    }
}
