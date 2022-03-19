package GameEngine.InitializeMap.MapDescriptions;

import java.util.ArrayList;

public class NormalMapDescriptions {
    private ArrayList<String> _descriptions = new ArrayList<>();

    public NormalMapDescriptions() {
        _descriptions.add("""
                The room is decorated with pictures of what looks like old nazi NSDAP party members. 
                
                You know, nazi pigs like Goebbels, Himmler, Borgman, and Paludan.
                
                YOu notice a locker with a combinatorial lock. Maybe try 123. These pigs weren't to clever at all.
                """);
        _descriptions.add("You enter a room with moldy old food on the table.");
        _descriptions.add("You look around and spot multiple bats from the ceiling starring at you");
        _descriptions.add("""
                You look around and notice a smell of pure death.
                
                Maybe you forgot deo, brush your teeths, or even worse, John Mogensen is in the room with you.
                
                But suddenly, you spot a pair of legs sticking out beneath of a table placed at the opposite left corner.
                
                You have to be carefull here. If it happens to be John Mogensen, you have to immediately equip that
                gas mask placed on the table. You won't survive long without.
                """);
        _descriptions.add("You enter a completely dark room with no light source.");
        _descriptions.add("You notice a dead body lying on the floor covered with rats.");
        _descriptions.add("""
                At the moment you enters, you notice the floor is covered in kerosine, 
                and in front of you, a man with a box of matches in his right hand.
                """);
        _descriptions.add("Upon entering the room you hear womanly screams behind an assumed locked door");
        _descriptions.add("Whilst inspecting the room you find body-limbs and a bloody knife");
        _descriptions.add("In this room you spot an old nazi mp-44 assault riffle");
        _descriptions.add("""
                On your right, there is a wooden table with some furniture around.
                You notice a Lenovo Thinkpad X1 Carbon placed on the table with IntelliJ open. The code seems really bad.
                """);
        _descriptions.add("""
                A book shelf on the right full of books, and to the left, a kitchen with oven, cutlery and pans. 
                Nothing wierd about that, except that the lights are flickering. To your surprise, you spot a dwarf 
                at the end of the room playing with the light-switch.
                """);
    }

    public ArrayList<String> descriptions(){
        return _descriptions;
    }

    public int count(){
        return _descriptions.size();
    }
}
