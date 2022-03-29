package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.Teleporter;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Usables.IUsable;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Weapons.InvalidObjectException;
import GameEngine.Player.Player;

import java.util.List;
import java.util.Random;

public class TeleportDevice extends Item implements IUsable {
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
        var currentRoom = obj.currentRoom();
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
        super("teleporter");
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
