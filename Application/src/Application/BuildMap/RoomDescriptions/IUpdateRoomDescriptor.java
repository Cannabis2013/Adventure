package Application.BuildMap.RoomDescriptions;

public interface IUpdateRoomDescriptor<T> {
    void updateRecursive(T t);
    void update(T t);
}
