package GameEngine.Player.InventoryBag;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.Utils.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Item> _inventory = new ArrayList<>();

    public void add(Item item){
        _inventory.add(item);
    }

    public void add(List<Item> items){
        _inventory.addAll(items);
    }

    public Item take(String itemTitle) throws ItemNotFoundException {
        var item = _inventory.stream()
                .filter(i -> i.title().equals(itemTitle)).findFirst();
        if(item.isPresent()){
            _inventory.removeIf(i -> i.title().equals(itemTitle));
            return item.get();
        }
        throw new ItemNotFoundException();
    }

    public Item get(String itemTitle) throws ItemNotFoundException {
        var item = _inventory.stream()
                .filter(i -> i.title().equals(itemTitle)).findFirst();
        if(item.isPresent())
            return item.get();
        throw new ItemNotFoundException();
    }

    public List<String> itemTitles(){
        return _inventory.stream().map(i -> i.presentate()).toList();
    }
}
