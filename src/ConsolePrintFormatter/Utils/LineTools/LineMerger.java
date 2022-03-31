package ConsolePrintFormatter.Utils.LineTools;

import java.util.List;

public class LineMerger {
    public String merge(List<String> lines){
        var linesWithSpaces = lines.stream().map(line -> line + '\n');
        var sb = new StringBuilder();
        linesWithSpaces.forEach(line ->sb.append(line));
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
}
