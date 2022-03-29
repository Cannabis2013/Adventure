package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Items.Item;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Door;
import GameEngine.MapGeneration.SmallSquare.Map.Rooms.Node;
import GameEngine.Player.Character;
import GameEngine.Utils.ItemNotFoundException;
import GameEngine.Utils.ObjectNotFoundException;

import java.util.List;

public interface IRoom {
    List<Character> demons();
    List<String> demonsAsString();

    String description();
    void setDescription(String str);
    Character demon();
    Character demon(String title);

    boolean isSealed();
    void setSealed(boolean sealed);

    List<IObjectEntity> roomObjects();
    void setRoomObjects(List<IObjectEntity> objects);
    IObjectEntity roomObject(String title) throws ObjectNotFoundException;

    RoomType getRoomType();

    String doorTitles();

    IMap map();

    void promote();

    void addItem(Item item);
    Item takeItem(String itemTitle) throws ItemNotFoundException;

    List<Item> items();
    List<String> itemsAsString();

    enum RoomType {NORMAL_ROOM, BOSS_ROOM, END_ROOM;}

    Door getNorth();
    Door getEast();
    Door getWest();
    Door getSouth();

    void setNorth(Node node);
    void setEast(Node node);
    void setSouth(Node node);
    void setWest(Node node);
}
