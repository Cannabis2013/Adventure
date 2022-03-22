package GameEngine.Utils;

import GameEngine.InitializeMap.MapItems.Item;
import java.util.List;
import java.util.Optional;

public class GetItemFromList {
    public Item findByTitle(List<Item> items, String title) throws ItemNotFoundException {
        Optional<Item> optional = items.stream()
                .filter(i -> i.getShortTitle().equalsIgnoreCase(title) ||
                             i.getTitle().equalsIgnoreCase(title)).findFirst();
        if(optional.isEmpty())
            throw new ItemNotFoundException();
        return optional.get();
    }
}
