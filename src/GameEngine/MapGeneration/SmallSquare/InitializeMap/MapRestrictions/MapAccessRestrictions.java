package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.Contracts.IRoom;

import java.util.List;

public class MapAccessRestrictions {

    private void lockRoom(Room room, int keyID){
        if(room.getNorth() != null)
            room.getNorth().lock(keyID);
        else if(room.getEast() != null)
            room.getEast().lock(keyID);
        else if(room.getSouth() != null)
            room.getSouth().lock(keyID);
        else if(room.getWest() != null)
            room.getWest().lock(keyID);
        else
            throw new IllegalStateException("Room not connected");
    }

    private List<RedKey> lockSpecialRooms(List<Room> rooms){

        var keys = rooms.stream()
                .map(r -> {
                   var key = new RedKey("red key");
                   lockRoom(r,key.id());
                   r.setSealed(true);
                   return key;
                }).toList();
        return keys;

    }

    public List<RedKey> restrict(List<Room> rooms){
        var specials = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.BOSS_ROOM)
                .toList();
        var keys = lockSpecialRooms(specials);
        return keys;
    }
}
