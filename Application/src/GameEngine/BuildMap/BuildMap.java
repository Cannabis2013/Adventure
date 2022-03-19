package GameEngine.BuildMap;

public class BuildMap {
    private BuildRooms _buildRooms = new BuildRooms();
    private ConnectSquared _connectRooms = new ConnectSquared();
    private AddDescriptions _addDescriptions = new AddDescriptions();
    public Room build(){
        var rooms = _buildRooms.build(9);
        _connectRooms.connect(rooms);
        _addDescriptions.add(rooms);
        return rooms.get(0);
    }
}
