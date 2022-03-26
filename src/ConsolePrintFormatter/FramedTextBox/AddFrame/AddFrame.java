package ConsolePrintFormatter.FramedTextBox.AddFrame;

public class AddFrame {
    private String _frameCode = (char) 27 + "[51m";
    private String _reset = (char) 27 + "[m";
    public String add(String str){
        return _frameCode + str + _reset;
    }
}
