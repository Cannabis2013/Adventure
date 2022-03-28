package GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems;

import GameEngine.MapGeneration.SmallSquare.Models.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public abstract class RandomRoomsPopulator {
    protected List<Integer> randomIndexes(int bound){
        var indexes = IntStream.range(0,bound - 1).boxed().toList();
        var l = new ArrayList<Integer>(indexes);
        Collections.shuffle(l);
        return l;
    }

    protected void addItems(List<Room> rooms, List<Item> items){
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

    abstract public void add(List<Room> rooms);
}
