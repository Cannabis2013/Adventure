package Application.BuildMap.RoomDescriptions;

public interface IUpdateRoomDescriptor<T> {
    void update(T t, IDescriptionsRepository repository, boolean recursive);
}
