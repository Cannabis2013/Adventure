package GameEngine.InitializeMap.Teleporter;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Usable;
import GameEngine.MapObjects.MapObject;
import GameEngine.Player.Player;
import java.util.List;
import java.util.Random;

public class TeleportDevice extends Usable {
    private boolean _used = false;

    private String buildMessage(){
        return "Teleported to another new place. Have fun.";
    }

    @Override
    public String presentate() {
        if(_used)
            return _title + "(broken)";
        else
            return _title;
    }

    private Room getRandomRoom(List<Room> rooms){
        var rand = new Random();
        var randIndex = rand.nextInt(rooms.size());
        return rooms.get(randIndex);
    }

    private String teleport(Player obj){
        var map = obj.getCurrentMap();
        var currentRoom = obj.getCurrentRoom();
        var rooms = map.rooms();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal)
                .takeWhile(r ->r != currentRoom);
        var randomRoom = getRandomRoom(normals.toList());
        obj.setCurrentRoom(randomRoom);
        _used = true;
        return buildMessage();
    }

    public TeleportDevice() {
        super("teleportDevice", "teleporter", false);
    }

    @Override
    public String useOn(MapObject obj) throws InvalidObjectException {
        if(_used){
            return "Not working anymore";
        }
        if(!(obj instanceof Player))
            throw new InvalidObjectException();
        var msg = teleport((Player) obj);
        _used = true;
        return msg;
    }
}
