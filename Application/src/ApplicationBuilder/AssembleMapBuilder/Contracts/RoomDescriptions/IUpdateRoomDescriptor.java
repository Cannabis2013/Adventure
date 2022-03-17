package ApplicationBuilder.AssembleMapBuilder.Contracts.RoomDescriptions;

public interface IUpdateRoomDescriptor<T> {
    void updateRecursive(T t);
    void update(T t);
}
