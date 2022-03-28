package GameEngine.Player;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Utils.ObjectNotFoundException;
import java.util.List;

public class FindObjectByTitle {
    public IObjectEntity find(List<IObjectEntity> objects, String str) throws ObjectNotFoundException {
        var obj = objects.stream()
                .filter(o -> o.title().equals(str))
                .findFirst();
        if(obj.isEmpty())
            throw new ObjectNotFoundException();
        return obj.get();
    }
}
