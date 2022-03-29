package GameEngine.MapGeneration.SmallSquare.Map.Rooms;

import GameEngine.Contracts.IObjectEntity;
import GameEngine.Contracts.IRoom;

public abstract class Node implements IRoom, IObjectEntity {
    private Door north, east,south,west;
    private static int _id = 0;
    private final String _title;

    @Override
    public int id() {
        return _id;
    }

    @Override
    public String title(){return _title;}

    public Node(String title) {
        _id++;
        _title = String.format("%s %d",title,_id);
    }
    public Door getNorth() {return north;}
    public Door getEast() {return east;}
    public Door getWest() {return west;}
    public Door getSouth() {return south;}

    public void setNorth(Node node) {
        var door = new Door(this,node);
        this.north = door;
        node.south = door;
    }

    public void setEast(Node node) {
        var door = new Door(this,node);
        this.east = door;
        node.west = door;
    }

    public void setSouth(Node node) {
        var door = new Door(this,node);
        this.south = door;
        node.north = door;
    }

    public void setWest(Node node) {
        var door = new Door(this,node);
        this.west = door;
        node.east = door;
    }

    public void disconnect() {
        if(this.north != null)
            north.other(this).south = null;
        if(east != null)
            east.other(this).west = null;
        if(south != null)
            south.other(this).north = null;
        if(west != null)
            west.other(this).east = null;
        north = null;
        east = null;
        south = null;
        west = null;
    }
}
