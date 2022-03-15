package Adventure.Room;

import java.util.UUID;

public class Room {
    public int id;
    public String name;
    public String description;
    public Room north = null;
    public Room east = null;
    public Room south = null;
    public Room west = null;
}
