package ConsolePrintFormatter.Utils.Normalize;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class NormalizeStringLines {
    private FindGreatestLineLength _findGreatestLength = new FindGreatestLineLength();

    private String addSpaces(String line, int count){
        var str = line;
        for (var i = 0;i < count;i++)
            str += " ";
        return str;
    }

    private String trimLine(String line, int count){
        if(line.length() < count)
            return "";
        return line.substring(0,count);
    }

    private String _normalizeLine(String line, int desiredLength){
        var diff = desiredLength - line.length();
        if(diff >= 0)
            return addSpaces(line,diff);
        return trimLine(line,diff*(-1));
    }

    private List<String> _normalize(List<String> lines, int greatestLength){

        var normalizedLines = lines.stream().map(l -> _normalizeLine(l,greatestLength));
        return normalizedLines.collect(Collectors.toCollection(ArrayList::new));
    }
    public List<String> normalize(List<String> lines){
        var greatestLength = _findGreatestLength.greatest(lines);
        return _normalize(lines,greatestLength);
    }

    public List<String> normalize(List<String> lines, int length){
        return _normalize(lines,length);
    }
}
