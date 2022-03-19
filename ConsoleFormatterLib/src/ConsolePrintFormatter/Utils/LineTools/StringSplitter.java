package ConsolePrintFormatter.Utils.LineTools;

import java.util.ArrayList;
import java.util.List;

public final class StringSplitter {
    int _length = 0;
    int _currentIndex = 0;
    List<String> _lines = new ArrayList<>();
    String _str;

    private boolean updateString(int indexOfSpace){
        try {
            _str = _str.substring(indexOfSpace + 1);
            return true;
        } catch (IndexOutOfBoundsException  e){
            return false;
        }
    }

    private boolean evaluateLineLength(int indexOfSpace){
        var indexOfLastCharacter = indexOfSpace - 1;
        String line;
        if(indexOfLastCharacter < 0)
            line = " ";
        else
            line = _str.substring(0,indexOfLastCharacter + 1);
        _lines.add(line);
        if(line.length() > _length)
            _length = line.length();
        return updateString(indexOfSpace);
    }

    public List<String> split(String str){
        _str = str;
        boolean hasNext = true;
        while (hasNext){
            var indexOfNewLine = _str.indexOf('\n');
            if(indexOfNewLine != -1)
                hasNext = evaluateLineLength(indexOfNewLine);
            else
                hasNext = false;
        }
        if(!_str.isEmpty())
            _lines.add(_str);
        if(_lines.isEmpty())
            _lines.add(str);
        return _lines;
    }
}
