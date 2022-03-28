package GameEngine.Contracts;

import GameEngine.MapGeneration.SmallSquare.Models.Node;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.LivingObjects.Demon;
import GameEngine.MapGeneration.SmallSquare.InitializeMap.MapItems.Item;
import GameEngine.Utils.ItemNotFoundException;
import java.util.List;

public interface IRoom {
    List<Demon> demons();
    List<String> demonsAsString();

    String description();
    void setDescription(String str);

    boolean isSealed();
    void setSealed(boolean sealed);

    List<IObjectEntity> roomObjects();
    void setRoomObjects(List<IObjectEntity> objects);

    RoomType getRoomType();

    String doorTitles();

    IMap map();

    void promote();

    void addItem(Item item);
    Item takeItem(String itemTitle) throws ItemNotFoundException;

    List<Item> items();
    List<String> itemsAsString();

    enum RoomType {NORMAL_ROOM, BOSS_ROOM, END_ROOM;}

    IDoor getNorth();
    IDoor getEast();
    IDoor getWest();
    IDoor getSouth();

    void setNorth(Node node);
    void setEast(Node node);
    void setSouth(Node node);
    void setWest(Node node);
}
