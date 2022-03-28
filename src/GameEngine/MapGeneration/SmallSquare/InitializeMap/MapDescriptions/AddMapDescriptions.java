package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapDescriptions;

import GameEngine.MapGeneration.SmallSquare.Models.Room;
import GameEngine.Contracts.IRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddMapDescriptions {
    private final ArrayList<String> _normalDescriptions;
    private final SpecialMapDescriptions _specialRepo = new SpecialMapDescriptions();
    private ArrayList<Integer> _normalIndexes;

    private int _normalIndex = 0;
    private int _specialIndex = 0;

    private ArrayList<Integer> genRandIndexes(int count){
        var indexes = new ArrayList<Integer>();
        for (var i = 0;i < count;i++)
            indexes.add(i);
        Collections.shuffle(indexes);
        return indexes;
    }

    private int getNormalIndex(){
        var count = _normalDescriptions.size();
        if(_normalIndex >= count){
            genRandIndexes(count);
            _normalIndex = 0;
        }
        return _normalIndexes.get(_normalIndex++);
    }

    private void setRegularRoomsDescription(List<Room> rooms){
        rooms.forEach(r -> {
            if(r.getRoomType() == IRoom.RoomType.NORMAL_ROOM){
                var description = "No description available";
                description = _normalDescriptions.get(getNormalIndex());
                r.setDescription(description);
            }
        });
    }

    private void setBossRoomDescription(List<Room> rooms){
        var bossRoom = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.BOSS_ROOM)
                .findFirst().get();
        bossRoom.setDescription(_specialRepo.bossRoomDescription());
    }

    public void add(List<Room> rooms){
        setRegularRoomsDescription(rooms);
        setBossRoomDescription(rooms);
    }

    public AddMapDescriptions(){
        var normalRepo = new NormalMapDescriptions();
        _normalDescriptions = normalRepo.descriptions();
        _normalIndexes = genRandIndexes(normalRepo.count());
    }
}
