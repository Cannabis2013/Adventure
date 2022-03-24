package GameEngine.InitializeMap;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapDescriptions.AddMapDescriptions;
import GameEngine.InitializeMap.MapRestrictions.AddAccessRestrictions;
import GameEngine.InitializeMap.Teleporter.AddTeleportDevice;
import GameEngine.InitializeMap.Weapons.AddWeapons;

import java.util.List;

public class InitializeMap {
    private AddMapDescriptions _addDescriptions = new AddMapDescriptions();
    private AddAccessRestrictions _addAccessRestrictions = new AddAccessRestrictions();
    private AddTeleportDevice _addTeleport = new AddTeleportDevice();
    private AddWeapons _addWeapons = new AddWeapons();
    public void initialize(List<Room> rooms){
        _addDescriptions.add(rooms);
        _addAccessRestrictions.add(rooms);
        _addTeleport.add(rooms);
        _addWeapons.add(rooms);
    }
}
