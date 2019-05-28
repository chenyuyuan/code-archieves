package compiler.lexer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Symbol {
    String name;
    int width = 0;
    int kind;
    String type;
    String val;
}
class Token {
    String val;
    int kind;
}
public class Lexer {
    public static int getTag(String s){
        if(s == null || s == "" || s.length() == 0) return -1;
        switch (s){
            case "if": return 256;case "else": return 257;case "then": return 258;case "while": return 259;case "do": return 260;
            case "+": return 261;case "-": return 262;case "*": return 263;case "/": return 264;
            case ">": return 265;case "<": return 266;case "=": return 267;
            case "(": return 268;case ")": return 269;
            case ";": return 270;
            case "\"": return 271;
            case "==": return 272;case ">=": return 273;case "<=": return 274;case "!=": return 275;
            case "keyword": return 276;
            case "variety": return 277;
            case "number": return 278;
            case "real": return 279;
        }
        return -1;
    }
    public ArrayList<String> getToken(){
        ArrayList<String> symbols=new ArrayList<>();
        for(Symbol symbol:symbolSet){
            symbols.add(symbol.name);
        }
        return symbols;
    }
    public static boolean isKey(String s) {
        for(String key:keys) {
            if (s.equals(key)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Symbol> symbolSet = new ArrayList<>();
    public ArrayList<Token> tokenSet = new ArrayList<>();
    private static String text;
    private static String[] keys = {"if", "then", "else", "while", "do"};
    public Lexer(String text){
        this.text = text;
    }

    public void Scanner() {
        int text_length = text.length();
        int pointer = 0;
        while (pointer < text_length) {
            if (text.charAt(pointer) == ' ' || text.charAt(pointer) == '\t') pointer++;
            else if (text.charAt(pointer) == '\n') ++pointer;
            else {
                if (Character.isLetter(text.charAt(pointer))){
                    String word = "" + text.charAt(pointer);
                    pointer++;
                    while (pointer < text_length && (Character.isLetter(text.charAt(pointer)) || Character.isDigit(text.charAt(pointer)))) {
                        word = word +text.charAt(pointer);
                        pointer++;
                    }
                    if(isKey(word)) {
                        Symbol newSymbol = new Symbol();
                        Token newToken = new Token();
                        newSymbol.type = "keyword";newSymbol.name = word;newSymbol.kind = getTag("keyword");
                        symbolSet.add(newSymbol);
                        newToken.kind = getTag("keyword");
                        tokenSet.add(newToken);
                    } else {
                        Symbol newSymbol = new Symbol();
                        Token newToken = new Token();
                        newSymbol.type = "variety";newSymbol.name = "id";newSymbol.kind = getTag("variety");
                        symbolSet.add(newSymbol);
                        newToken.kind = getTag("variety");
                        tokenSet.add(newToken);
                    }
                } else if (Character.isDigit(text.charAt(pointer))) {
                    String word = "";
                    boolean isFloat = false;
                    while (pointer < text_length && Character.isDigit(text.charAt(pointer))) {
                        word = word +text.charAt(pointer);
                        pointer++;
                        if(pointer < text_length && text.charAt(pointer) == '.') {
                            isFloat = true;
                            word = word + '.';
                            pointer++;
                        }
                    }
                    Symbol newSymbol = new Symbol();
                    Token newToken = new Token();
                    if(!isFloat) {
                        newSymbol.type = "number";newSymbol.name = "number";newSymbol.kind = getTag("number");newSymbol.val = word;
                        newToken.kind = getTag("number");
                    } else {
                        newSymbol.type = "real";newSymbol.name = "real";newSymbol.kind = getTag("real");newSymbol.val = word;
                        newToken.kind = getTag("real");
                    }
                    symbolSet.add(newSymbol);
                    tokenSet.add(newToken);
                } else {
                    switch (text.charAt(pointer)) {
                        case '&':
                            if(pointer < text_length && text.charAt(pointer) == '&') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "&&";newSymbol.name = "&&";newSymbol.kind = getTag("&&");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("&&");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "&";newSymbol.name = "&";newSymbol.kind = getTag("&");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("&");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '|':
                            if(pointer < text_length && text.charAt(pointer) == '|') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "||";newSymbol.name = "||";newSymbol.kind = getTag("||");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("||");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "|";newSymbol.name = "|";newSymbol.kind = getTag("|");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("|");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '=':
                            if(pointer < text_length && text.charAt(pointer) == '=') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "==";newSymbol.name = "==";newSymbol.kind = getTag("==");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("==");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "=";newSymbol.name = "=";newSymbol.kind = getTag("=");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("=");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '!':
                            if(pointer < text_length && text.charAt(pointer) == '=') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "!=";newSymbol.name = "!=";newSymbol.kind = getTag("!=");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("!=");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "!";newSymbol.name = "!";newSymbol.kind = getTag("!");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("!");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '<':
                            if(pointer < text_length && text.charAt(pointer) == '=') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "<=";newSymbol.name = "<=";newSymbol.kind = getTag("<=");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("<=");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "<";newSymbol.name = "<";newSymbol.kind = getTag("<");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("<");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '>':
                            if(pointer < text_length && text.charAt(pointer) == '=') {
                                pointer = pointer + 2;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = ">=";newSymbol.name = ">=";newSymbol.kind = getTag(">=");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag(">=");
                                tokenSet.add(newToken);
                            }
                            else {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = ">";newSymbol.name = ">";newSymbol.kind = getTag(">");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag(">");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '+':
                            {
                                pointer = pointer + 1;
                                Symbol newSymbol = new Symbol();
                                Token newToken = new Token();
                                newSymbol.type = "+";newSymbol.name = "+";newSymbol.kind = getTag("+");
                                symbolSet.add(newSymbol);
                                newToken.kind = getTag("+");
                                tokenSet.add(newToken);
                            }
                            break;
                        case '-': {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = "-";newSymbol.name = "-";newSymbol.kind = getTag("-");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag("-");
                            tokenSet.add(newToken);
                        }
                            break;
                        case '*': {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = "*";newSymbol.name = "*";newSymbol.kind = getTag("*");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag("*");
                            tokenSet.add(newToken);
                            break;
                        }

                        case '/': {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = "/";newSymbol.name = "/";newSymbol.kind = getTag("/");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag("/");
                            tokenSet.add(newToken);
                        }

                            break;
                        case '(': {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = "(";newSymbol.name = "(";newSymbol.kind = getTag("(");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag("(");
                            tokenSet.add(newToken);
                        }

                            break;
                        case ')': {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = ")";newSymbol.name = ")";newSymbol.kind = getTag(")");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag(")");
                            tokenSet.add(newToken);
                        }

                            break;
                        case ';':
                        {
                            pointer = pointer + 1;
                            Symbol newSymbol = new Symbol();
                            Token newToken = new Token();
                            newSymbol.type = ";";newSymbol.name = ";";newSymbol.kind = getTag(";");
                            symbolSet.add(newSymbol);
                            newToken.kind = getTag(";");
                            tokenSet.add(newToken);
                        }
                            break;
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        String text = "if ( a < b ) a = a + 1 + 2.1;";
        Lexer lexer = new Lexer(text);
        lexer.Scanner();
        for (Symbol symbol:lexer.symbolSet){
            System.out.println("(" + symbol.name + ", " + symbol.val + ")");
        }
        System.out.println(lexer.symbolSet.size());
    }
}
