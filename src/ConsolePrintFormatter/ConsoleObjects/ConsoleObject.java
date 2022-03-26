package ConsolePrintFormatter.ConsoleObjects;

public class ConsoleObject {
    private final String _str;
    public ConsoleObject(String str){
        _str = str;
    }

    @Override
    public String toString() {
        return _str;
    }
}
