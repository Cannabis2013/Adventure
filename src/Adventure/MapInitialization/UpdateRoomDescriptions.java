package Adventure.MapInitialization;

import Adventure.Room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateRoomDescriptions {
    MapDescriptionRepository repository = new MapDescriptionRepository();
    MapSpecialRepository specialRepository = new MapSpecialRepository();

    private String getRandomDescription(List<String> descriptions) {
        int randValue = getRandomIndex(descriptions.size());
        String descr = takeFromList(descriptions,randValue);
        return descr;
    }

    private void updateRoom(List<String> descriptions, Room room){
        if(room == null) {
            return;
        }
        if(room.getDescription() != null) {
            return;
        }
        if (room.getName().equals("room 5")) {
            return;
        }
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
    public void update(Room room) {
        var repo = repository.getDescriptions();
        List<String> list = new ArrayList<>(repo);
        updateRoom(list,room);
    }
    public void updateSpecial(Room room){
        List<String> specialRepo = specialRepository.getSpecialDescriptions();
        room.setDescription(getRandomDescription(specialRepo));
    }
}
