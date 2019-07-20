package archives.kot;

import java.io.IOException;

class Token {
    String name_start;
    String type;
    String knid;
    String val;
    String addr;
}

public class LexicalAnalysis {
    private static String text;
    private static String[] key = {"if", "then", "else", "while", "do"};
    public LexicalAnalysis(String text){
        this.text = text;
    }

    public void Scanner(){
        System.out.println(text);
    }

    public static void main(String[] args) throws IOException {
        String text = "printf(\"Hello world!\");\n" +
                "if(a == 0) a = c + d;";
        LexicalAnalysis lexicalAnalysis = new LexicalAnalysis(text);
        lexicalAnalysis.Scanner();
    }
}
