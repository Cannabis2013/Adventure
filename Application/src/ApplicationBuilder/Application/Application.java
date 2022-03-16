package ApplicationBuilder.Application;

public class Application extends AbstractApplication  {

    public void init(){
        _currentRoom = _buildMap.build();
    }

    @Override
    public void traverseTo(String orientation) throws IllegalArgumentException, IllegalStateException {
        _currentRoom = _traverseTo.traverse(orientation,_currentRoom);
    }

    @Override
    public String roomDescription() {
        return _currentRoom.getDescription();
    }
}
