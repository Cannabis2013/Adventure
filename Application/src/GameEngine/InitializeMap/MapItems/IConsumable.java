package GameEngine.InitializeMap.MapItems;

public interface IConsumable<T> {
    String consume(T object) throws InvalidObjectException;
}
