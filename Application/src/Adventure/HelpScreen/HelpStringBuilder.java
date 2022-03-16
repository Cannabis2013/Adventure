package Adventure.HelpScreen;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

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
        var builder = new BuildFilledBox(str);
        builder.setBackroundColor(new Color(255, 4, 4));
        builder.setTextColor(new Color(255,255,255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }
}
