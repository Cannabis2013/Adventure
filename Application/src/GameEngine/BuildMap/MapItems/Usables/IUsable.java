package GameEngine.BuildMap.MapItems.Usables;

import GameEngine.BuildMap.MapItems.Item;

public interface IUsable<T> {
    void use(T target);
}
