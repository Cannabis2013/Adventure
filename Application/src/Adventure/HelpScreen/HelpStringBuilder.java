package Adventure.HelpScreen;

public class HelpStringBuilder {
    public String build(){
        String str = """
                General:
                    help : Print this screen
                    exit : exit game
                    look : Print room description
                
                Movement:
                    Directions: {North, east, south, west}
                
                    Go {Direction} : Move player in given direction
                """;
        return str;
    }
}
