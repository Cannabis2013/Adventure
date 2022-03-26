package Adventure.ScreenMessages;

public class PrintHelp {

    FormatMessages _formatter = new FormatMessages();

    private String buildHelpMsg(){
        return """
                General:
                    help    : Print this screen
                    exit    : exit game
                    look    : Print room description
                    health  : Print your current health
                
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
        var formatted = _formatter.formatWhiteOnRedLoose(msg);
        System.out.println(formatted);
    }
}
