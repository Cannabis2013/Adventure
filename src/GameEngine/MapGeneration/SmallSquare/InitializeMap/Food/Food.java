package GameEngine.MapGeneration.SmallSquare.InitializeMap.Food;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Human;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Consumable;

public class Food extends Consumable {
    private int hp_change;
    public Food(String title, int hp) {
        super("Food", title);
        hp_change = hp;
    }

    public String consume(Human human) {
        human.addHealth(hp_change);
        return title() + " " + hp_change + "hp";
    }
}
