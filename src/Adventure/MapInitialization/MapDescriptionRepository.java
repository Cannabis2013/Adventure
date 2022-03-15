package Adventure.MapInitialization;

import java.util.ArrayList;
import java.util.List;

public class MapDescriptionRepository {
    List<String> descriptions = new ArrayList<>();

    public MapDescriptionRepository() {
        descriptions.add("You enter a room with a wall full of pictures of old war-heroes.");
        descriptions.add("You enter a room with moldy old food on the table.");
        descriptions.add("You look around and spot multiple bats from the ceiling starring at you");
        descriptions.add("You look around and notice a smell a pure death.");
        descriptions.add("You enter a completely dark room with no light source.");
        descriptions.add("You notice a dead body lying on the floor covered with rats.");
        descriptions.add("At the moment you enters, you notice the floor is covered in kerosine, and in front of you a man with box of matches.");
        descriptions.add("Upon entering the room you hear womanly screams behind an assumed locked door");
        descriptions.add("Whilst inspecting the room you find body-limbs and a bloody knife");
        descriptions.add("In this room you spot an old nazi mp-44 assault riffle");
        descriptions.add("Whilst inspecting, you find a laptop with IntelliJ open. The code is really bad.");
        descriptions.add("Upon entering the room you notice the lights are flickering and immediately spot a dwarf at the other side playing with the light-switch.");
    }

    public List<String> getDescriptions() {
        return descriptions;
    }
}
