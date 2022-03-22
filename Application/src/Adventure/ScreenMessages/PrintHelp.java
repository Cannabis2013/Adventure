package Adventure.ScreenMessages;

public class PrintHelp {

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

    public void print()
    {
        var msg = buildHelpMsg();
        var formatted = _formatter.formatHelp(msg);
        System.out.println(formatted);
    }
}
