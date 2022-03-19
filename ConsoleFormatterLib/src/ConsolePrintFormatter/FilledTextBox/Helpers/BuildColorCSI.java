package ConsolePrintFormatter.FilledTextBox.Helpers;

import java.awt.*;

public class BuildColorCSI {
    private String fgCode(Color rgb){
        var csiComp = String.format("\033[38;2;%d;%d;%dm",rgb.getRed(),rgb.getGreen(),rgb.getBlue());
        return csiComp;
    }
    private String bgCode(Color rgb){
        var csiComp = String.format("\033[48;2;%d;%d;%dm",rgb.getRed(),rgb.getGreen(),rgb.getBlue());
        return csiComp;
    }
    public String buildBg(Color color){
        var code = bgCode(color);
        return code;
    }

    public String buildFg(Color color)
    {
        var code = fgCode(color);
        return code;
    }
}
