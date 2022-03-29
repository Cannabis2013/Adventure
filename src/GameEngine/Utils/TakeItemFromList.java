package GameEngine.Utils;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;

import java.util.List;

public class TakeItemFromList {
    public Item take(List<Item> objects, String str) throws ItemNotFoundException {
        var optional = objects.stream()
                .filter(o -> o.title().equals(str))
                .findFirst();
        if(optional.isEmpty())
            throw new ItemNotFoundException();
        var obj = optional.get();
        objects.remove(obj);
        return obj;
    }
}
