package ApplicationBuilder.AssembleMapBuilder.BuildMap.MapInitialization;

import Application.BuildMap.RoomDescriptions.IDescriptionsRepository;
import Application.BuildMap.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.AssembleMapBuilder.BuildMap.BuildRooms.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateRoomDescriptions implements IUpdateRoomDescriptor<Room> {

    private IDescriptionsRepository _repository;

    public void setRepository(IDescriptionsRepository repository) {_repository = repository;}

    private String getRandomDescription(List<String> descriptions) {
        int randValue = getRandomIndex(descriptions.size());
        return takeFromList(descriptions,randValue);
    }

    private void updateRoom(List<String> descriptions, Room room){
        if(room == null)
            return;
        if(room.getDescription() != null)
            return;
        room.setDescription(getRandomDescription(descriptions));
        updateRoom(descriptions,room.getEast());
        updateRoom(descriptions,room.getSouth());
    }

    private int getRandomIndex(int bound){
        Random rand = new Random();
        int randVal = rand.nextInt(bound);
        return randVal;
    }

    private String takeFromList(List<String> list, int index) {
        String descr = list.get(index);
        list.remove(index);
        return descr;
    }

    @Override
    public void updateRecursive(Room room) {
        var repo = _repository.descriptions();
        List<String> list = new ArrayList<>(repo);
        updateRoom(list,room);
    }

    @Override
    public void update(Room room) {
        var repo = _repository.descriptions();
        var descriptions = new ArrayList<>(repo);
        room.setDescription(getRandomDescription(descriptions));
    }
}
