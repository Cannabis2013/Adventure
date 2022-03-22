package Adventure.ScreenMessages;

public class PrintRoomDetails {
    FormatMessages _formatter = new FormatMessages();

    public void print(String description, String items){
        var msg = description + "\n\n";
        if(!items.isEmpty())
            msg += """
                    Items in this room:

                    """;
        else
            msg += "There seems to be no items of value in this room";
        var formatted = _formatter.formatWhiteOnBrown(msg + items);
        System.out.println(formatted);
    }
}
