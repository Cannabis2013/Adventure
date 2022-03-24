package GameEngine.InitializeMap.LivingObjects;

import GameEngine.MapObjects.MapObject;

public abstract class Organism extends MapObject {
    protected int _health = 100;

    public int getHealth() {
        return _health;
    }

    public void addHealth(int num) {
        if(_health < 100)
            _health += num;
    }

    public abstract int takeHealth(int num) throws FatalBlowException;
}
