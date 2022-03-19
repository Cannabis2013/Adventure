package GameEngine.BuildMap;

public class BuildMap {
    private BuildRooms _buildRooms = new BuildRooms();
    private UpdateSpecialRoomDescriptions _updateSpecialRoomDescriptions = new UpdateSpecialRoomDescriptions();
    SpecialEncircledQuadratic _connectRooms = new SpecialEncircledQuadratic();

    public Room build(){
        var normalRooms = _buildRooms.buildNormals(8);
        var specialRooms = _buildRooms.buildSpecials(1);
        var firstRoom = _connectRooms.connect(normalRooms,specialRooms);
        return firstRoom;
    }
}
