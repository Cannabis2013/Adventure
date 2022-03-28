package GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects;

import GameEngine.Contracts.IInflictable;
import GameEngine.MapGeneration.SmallSquare.Models.MapObject;

public abstract class Demon extends MapObject implements IInflictable {
    public Demon(String title) {
        super(title);
    }

    protected int _health = 100;

    public int getHealth() {
        return _health;
    }

    public void addHealth(int num) {
        if(_health < 100)
            _health += num;
    }

    public void takeHealth(int value) throws FatalBlowException {
        _health -= value;
        if(_health <= 0)
            throw new FatalBlowException();
    }

    public abstract String attack(MapObject object);
}
