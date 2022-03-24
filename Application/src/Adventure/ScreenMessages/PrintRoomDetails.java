package Adventure.ScreenMessages;

public class PrintRoomDetails {
    FormatMessages _formatter = new FormatMessages();

    public void print(String description, String items, String doorTitles){
        var msg = description + "\n\n";
        if(items.isEmpty())
            msg += "There seems to be no items of value in this room";
        else
            msg += "Items in this room:";
        msg += "\n";
        msg += items;
        msg += "\n";
        msg += "Access details:";
        msg += "\n";
        msg += doorTitles;
        var formatted = _formatter.formatWhiteOnBrown(msg);
        System.out.println(formatted);
    }
}
