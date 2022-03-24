package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.Room;

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

    private List<Key> lockSpecialRooms(List<Room> rooms){

        var keys = rooms.stream()
                .map(r -> {
                   var key = new Key("Red key");
                   lockRoom(r,key.getID());
                   r.setSealed(true);
                   return key;
                }).toList();
        return keys;

    }

    public List<Key> restrict(List<Room> rooms){
        var specials = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Special).toList();
        var keys = lockSpecialRooms(specials);
        return keys;
    }
}
