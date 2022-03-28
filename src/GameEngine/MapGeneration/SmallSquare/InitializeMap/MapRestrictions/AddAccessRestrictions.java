package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapRestrictions;

import GameEngine.Contracts.IRoom;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.Map.Room;
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

    private void addItems(List<Room> rooms, List<Item> items){
        var randIndexes = randomIndexes(rooms.size());
        var i = 0;
        var ite = items.listIterator();
        while (ite.hasNext()){
            var item = ite.next();
            if(i >= randIndexes.size()){
                randIndexes = randomIndexes(rooms.size());
                i = 0;
            }
            var index = randIndexes.get(i++);
            rooms.get(index).addItem(item);
        }
    }

    public void add(List<Room> rooms){
        var keys = _restrictMap.restrict(rooms)
                .stream().map(k -> (Item) k).toList();
        var normals = rooms.stream()
                .filter(r -> r.getRoomType() == IRoom.RoomType.NORMAL_ROOM).toList();
        addItems(normals,keys);
    }
}
