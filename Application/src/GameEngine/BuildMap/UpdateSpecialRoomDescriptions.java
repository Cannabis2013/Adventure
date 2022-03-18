package GameEngine.BuildMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UpdateSpecialRoomDescriptions {
    private SpecialMapDescriptions _repository = new SpecialMapDescriptions();

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

    public void updateRecursive(Room room) {
        var repo = _repository.descriptions();
        List<String> list = new ArrayList<>(repo);
        updateRoom(list,room);
    }

    public void update(Room room) {
        var repo = _repository.descriptions();
        var descriptions = new ArrayList<>(repo);
        room.setDescription(getRandomDescription(descriptions));
    }
}
