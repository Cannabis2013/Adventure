package ApplicationBuilder.BuildMap.MapInitialization;

import Application.BuildMap.RoomDescriptions.IDescriptionsRepository;
import Application.BuildMap.RoomDescriptions.IUpdateRoomDescriptor;
import ApplicationBuilder.BuildMap.BuildRooms.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateRoomDescriptions implements IUpdateRoomDescriptor<Room> {

    private String getRandomDescription(List<String> descriptions) {
        int randValue = getRandomIndex(descriptions.size());
        return takeFromList(descriptions,randValue);
    }

    private void updateRoom(List<String> descriptions, Room room, boolean recursive){
        if(room == null)
            return;
        if(room.getDescription() != null)
            return;
        room.setDescription(getRandomDescription(descriptions));
        if(!recursive)
            return;
        updateRoom(descriptions,room.getEast(),true);
        updateRoom(descriptions,room.getSouth(),true);
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
    public void update(Room room, IDescriptionsRepository repository, boolean recursive) {
        var repo = repository.descriptions();
        List<String> list = new ArrayList<>(repo);
        updateRoom(list,room,recursive);
    }
}
