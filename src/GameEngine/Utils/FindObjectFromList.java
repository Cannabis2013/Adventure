package GameEngine.Utils;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import java.util.List;

public class FindObjectFromList {
    public IObjectEntity findObjectByTitle(List<IObjectEntity> objects, String str) throws ObjectNotFoundException {
        var obj = objects.stream()
                .filter(o -> o.title().equals(str))
                .findFirst();
        if(obj.isEmpty())
            throw new ObjectNotFoundException();
        return obj.get();
    }

    public Item findItemByTitle(List<Item> objects, String str) throws ItemNotFoundException {
        var obj = objects.stream()
                .filter(o -> o.title().equals(str))
                .findFirst();
        if(obj.isEmpty())
            throw new ItemNotFoundException();
        return obj.get();
    }
}
