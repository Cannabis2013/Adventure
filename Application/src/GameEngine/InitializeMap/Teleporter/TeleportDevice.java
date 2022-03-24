package GameEngine.InitializeMap.Teleporter;

import GameEngine.BuildMap.Rooms.Room;
import GameEngine.InitializeMap.MapItems.IUsable;
import GameEngine.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.InitializeMap.MapItems.Item;
import GameEngine.MapObjects.MapObject;
import GameEngine.Player.Player;
import java.util.List;
import java.util.Random;

public class TeleportDevice extends Item implements IUsable {
    private String buildMessage(){
        return "Teleported to another new place. Have fun.";
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
        return buildMessage();
    }

    public TeleportDevice() {
        super("TeleportDevice", "Teleporter");
    }

    @Override
    public String use(MapObject obj) throws InvalidObjectException {
        if(!(obj instanceof Player))
            throw new InvalidObjectException();
        return teleport((Player) obj);
    }
}
