package GameEngine.BuildMap;

import java.util.ArrayList;
import java.util.Collections;

public class AddRandomRoomDescription {
    private static int _index = 0;
    private static ArrayList<Integer> _indexes;
    private OrdinaryMapDescriptions _repository = new OrdinaryMapDescriptions();

    private void genRandIndexes(){
        var indexes = new ArrayList<Integer>();
        for (var i = 0;i < _repository.count();i++)
            indexes.add(i);
        Collections.shuffle(indexes);
        _indexes = indexes;
    }

    private int getIndex(){
        var count = _repository.count();
        if(_index >= count)
            genRandIndexes();
        return _indexes.get(_index++);
    }

    public AddRandomRoomDescription(){
        genRandIndexes();
    }

    public void add(Room room) {
        var index = getIndex();
        var description = _repository.description(index);
        room.setDescription(description);
    }
}
