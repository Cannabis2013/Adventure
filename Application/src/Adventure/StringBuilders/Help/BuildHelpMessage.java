package Adventure.StringBuilders.Help;

import ConsolePrintFormatter.FilledTextBox.BuildFilledBox;

import java.awt.*;

public class BuildHelpMessage {
    private String assembleMsg(){
        String msg = """
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
        return msg;
    }

    public String build(){
        var msg = assembleMsg();
        var builder = new BuildFilledBox(msg);
        builder.setBackroundColor(new Color(255, 4, 4));
        builder.setTextColor(new Color(255,255,255));
        builder.setPadding(4,2);
        builder.setMargins(0,1);
        return builder.build().toString();
    }
}
