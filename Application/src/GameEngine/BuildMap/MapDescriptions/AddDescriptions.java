package GameEngine.BuildMap.MapDescriptions;

import GameEngine.BuildMap.Rooms.Room;

import java.util.ArrayList;
import java.util.Collections;

public class AddDescriptions {
    private final ArrayList<String> _normalDescriptions;
    private final ArrayList<String> _specialDescriptions;
    private ArrayList<Integer> _normalIndexes;
    private ArrayList<Integer> _specialIndexes;

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

    private int getSpecialIndex(){
        var count = _specialDescriptions.size();
        if(_specialIndex >= count){
            genRandIndexes(count);
            _specialIndex = 0;
        }
        return _specialIndexes.get(_specialIndex++);
    }

    private void _add(Room room){
        var description = "No description available";
        if(room.getType() == Room.Type.Normal)
            description = _normalDescriptions.get(getNormalIndex());
        else if(room.getType() == Room.Type.Special)
            description = _specialDescriptions.get(getSpecialIndex());
        room.setDescription(description);
    }

    public void add(ArrayList<Room> rooms){
        rooms.forEach(r -> _add(r));
    }

    public AddDescriptions(){
        var normalRepo = new NormalMapDescriptions();
        var specialRepo = new SpecialMapDescriptions();

        _normalDescriptions = normalRepo.descriptions();
        _specialDescriptions = specialRepo.descriptions();

        _normalIndexes = genRandIndexes(normalRepo.count());
        _specialIndexes = genRandIndexes(specialRepo.count());
    }
}
