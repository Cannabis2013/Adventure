package GameEngine.InitializeMap.MapRestrictions;

import GameEngine.BuildMap.Rooms.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class AddAccessRestrictions {
    private MapAccessRestrictions _restrictMap = new MapAccessRestrictions();

    private List<Integer> randomIndexes(int bound){
        var indexes = IntStream.range(0,bound - 1).boxed().toList();
        var l = new ArrayList<Integer>(indexes);
        Collections.shuffle(l);
        return l;
    }

    private void addKeys(List<Room> rooms, List<Key> keys){
        var randIndexes = randomIndexes(rooms.size());
        var i = 0;
        var ite = keys.listIterator();
        while (ite.hasNext()){
            var key = ite.next();
            if(i >= randIndexes.size()){
                randIndexes = randomIndexes(rooms.size());
                i = 0;
            }
            var index = randIndexes.get(i++);
            rooms.get(index).addItem(key);
        }
    }

    public void add(List<Room> rooms){
        var keys = _restrictMap.restrict(rooms);
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == Room.RoomType.Normal).toList();
        addKeys(normals,keys);
    }
}
