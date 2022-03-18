package GameEngine.Item;

public class Key extends Item implements IUsable{
    public Key(String title) {
        super("key", title);
    }

    @Override
    public void use(Item target) {
    }
}
