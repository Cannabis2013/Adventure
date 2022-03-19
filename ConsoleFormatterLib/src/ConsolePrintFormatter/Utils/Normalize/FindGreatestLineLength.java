package ConsolePrintFormatter.Utils.Normalize;

import java.util.List;

public final class FindGreatestLineLength {
    public int greatest(List<String> lines){
        if(lines.size() == 0)
            return 0;
        var l = lines.stream().reduce((line, container) ->
            container = line.length() > container.length() ? line : container).get();
        return l.length();
    }
}
