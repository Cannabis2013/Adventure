package Adventure.CommandInterpreter.General;

import Adventure.ScreenMessages.FormatMessages;

public class PrintGeneralMessages {
    FormatMessages _formatter = new FormatMessages();

    private String buildHelpMsg(){
        return """
                General:
                    help : Print this screen
                    exit : exit game
                    look : Print room description
                
                Movement:
                    Directions: {North, east, south, west}
                    
                                    north
                                      |
                                      |
                              West----O----East
                                      |
                                      |
                                    South
                
                    Go {Direction} : Move player in given direction
                """;
    }

    public void printRoomInfo(String description, String items){
        var msg = description + "\n\n";
        var formatted = _formatter.formatRoomInfo(msg + items);
        System.out.println(formatted);
    }

    public void printInventory(String inventory){
        System.out.println(inventory);
    }

    public void printBadCommand(){
        var msg = "!!!! Bad command. Please try again. !!!!";
        var formatted = _formatter.formatNegativeResponse(msg);
        System.out.println(formatted);
    }
}
