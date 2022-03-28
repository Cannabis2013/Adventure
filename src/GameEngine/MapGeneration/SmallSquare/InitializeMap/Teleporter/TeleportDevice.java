package GameEngine.MapGeneration.SmallSquare.InitializeMap.Teleporter;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.InvalidObjectException;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Usable;
import GameEngine.Contracts.IRoom;
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
            return String.format("%s (broken)",_title);
        else
            return _title;
    }

    private IRoom getRandomRoom(List<IRoom> rooms){
        var rand = new Random();
        var randIndex = rand.nextInt(rooms.size());
        return rooms.get(randIndex);
    }

    private String teleport(Player obj){
        var map = obj.getCurrentMap();
        var currentRoom = obj.getCurrentRoom();
        var rooms = map.rooms();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.NORMAL_ROOM)
                .filter(r ->r != currentRoom).toList();
        var randomRoom = getRandomRoom(normals);
        obj.setCurrentRoom(randomRoom);
        _used = true;
        return buildMessage();
    }

    public TeleportDevice() {
        super("teleportDevice", "teleporter", false);
    }

    @Override
    public String useOn(IObjectEntity obj) throws InvalidObjectException {
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
