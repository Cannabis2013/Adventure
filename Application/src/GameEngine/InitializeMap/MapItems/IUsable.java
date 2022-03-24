package GameEngine.InitializeMap.MapItems;

public interface IUsable<T> {
    String use(T obj) throws InvalidObjectException;
}
