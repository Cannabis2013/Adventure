package Adventure.ScreenMessages;

import java.util.List;

public class PrintRoomDetails {
    FormatMessages _formatter = new FormatMessages();

    public void print(String description, List<String> itemTitles, String doorTitles){
        var msg = description + "\n\n";
        if(itemTitles.isEmpty())
            msg += "There seems to be no items of value in this room";
        else
            msg += "Items in this room:";
        msg += "\n";
        msg += itemTitles.stream().reduce("",(str,title) -> str + title + "\n");
        msg += "\n";
        msg += "Access details:";
        msg += "\n";
        msg += doorTitles;
        var formatted = _formatter.formatWhiteOnBrownLoose(msg);
        System.out.println(formatted);
    }
}
