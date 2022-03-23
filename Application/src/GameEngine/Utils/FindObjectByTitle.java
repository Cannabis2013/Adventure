package GameEngine.Utils;

import GameEngine.MapObjects.MapObject;

import java.util.List;

public class FindObjectByTitle {
    public MapObject find(List<MapObject> objects, String str) throws ObjectNotFoundException {
        var obj = objects.stream()
                .filter(o -> o.title().equals(str))
                .findFirst();
        if(obj.isEmpty())
            throw new ObjectNotFoundException();
        return obj.get();
    }
}
