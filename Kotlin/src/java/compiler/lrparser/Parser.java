package compiler.lrparser;

import compiler.lexer.Lexer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Symbol2 {
    String name;
    int width = 0;
    int kind;
    String type;
    String val;
}

class AnasisNode {
    public int kind;
    public int val;
    public List<AnasisNode> children;

    public AnasisNode() {}

    public AnasisNode(int _val,List<AnasisNode> _children) {
        val = _val;
        children = _children;
    }
}



public class Parser {
    String[] start = {"P","S","C","E","T","F"};
    String[] nonEnd = {"id",";","=","if","(",")","else","while",">","+","id","int10"};
    public int getnonEndIndex(String s){
        for(int i=0;i<nonEnd.length;++i){
            if(s.equals("int10")){
                return 11;
            } else if(s.equals(nonEnd[i])){
                return i;
            }
        }
        return -1;
    }
    public int getstartIndex(String s){
        if(s.equals("P"))return 12;
        if(s.equals("S"))return 13;
        if(s.equals("C"))return 14;
        if(s.equals("E"))return 15;
        if(s.equals("T"))return 16;
        if(s.equals("F"))return 17;
        return -1;
    }
    // 产生式
    String[] production = {"P'->P","P->S","S->id=E;","S->if(C)SelseS",
    "S->while(C)S1","S->SS","C->E1>E2","E->E+T","E->T","T->F","F->id","F->int10"};
    public String getProductionRight(int index){
        return production[index].substring(3);
    }
    public String getProductionLeft(int index){
        return production[index].substring(0,1);
    }
    int[][] analysisTable = {
            {104,  0,  0,105,  0,  0,  0,106,  0,  0,  0,  0,  1,  2,  0,  0,  0,  0},
            {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,300,  0,  0,  0,  0,  0,  0},
            {104,201,201,105,201,201,201,106,201,201,201,201,  0,  7,  0,  0,  0,  0},
            {  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {  0,108,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {  0,  0,  0,  0,109,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {  0,  0,  0,  0,110,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {104,205,205,105,205,205,205,106,205,205,205,205,  0,  7,  0,  0,  0,  0},
            {114,  0,  0,  0,  0,  0,  0,  0,  0,  0,115,  0,  0,  0, 11,  0, 12, 13},
            {114,  0,  0,  0,  0,  0,  0,  0,  0,  0,115,  0,  0,  0, 11, 16, 12, 13},
            {114,  0,  0,  0,  0,  0,  0,  0,  0,  0,115,  0,  0,  0, 11, 18, 12, 13},
            {  0,129,  0,  0,  0,  0,  0,  0,  0,119,  0,  0,  0,  0,  0,  0,  0,  0},
            {208,208,208,208,208,208,208,208,208,208,208,208,  0,  0,  0,  0,  0,  0},
            {209,209,209,209,209,209,209,209,209,209,209,209,  0,  0,  0,  0,  0,  0},
            {210,210,210,210,210,210,210,210,210,210,210,210,  0,  0,  0,  0,  0,  0},
            {211,211,211,211,211,211,211,211,211,211,211,211,  0,  0,  0,  0,  0,  0},
            {  0,  0,  0,  0,  0,120,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {  0,  0,  0,  0,  0,  0,  0,  0,121,119,  0,  0,  0,  0,  0,  0,  0,  0},
            {  0,  0,  0,  0,  0,122,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0},
            {114,  0,  0,  0,  0,  0,  0,  0,  0,  0,115,  0,  0,  0,  0,  0, 23, 13},
            {104,  0,  0,105,  0,  0,  0,106,  0,  0,  0,  0,  0, 24,  0,  0,  0,  0},//20
            {114,  0,  0,  0,  0,  0,  0,  0,  0,  0,115,  0,  0,  0, 25,  0, 12, 13},
            {104,  0,  0,105,  0,  0,  0,106,  0,  0,  0,  0,  0, 26,  0,  0,  0,  0},
            {207,207,207,207,207,207,207,207,207,207,207,207,  0,  0,  0,  0,  0,  0},
            {104,  0,  0,105,  0,  0,127,106,  0,  0,  0,  0,  0,  7,  0,  0,  0,  0},
            {206,206,206,206,206,206,206,206,206,119,206,206,  0,  0,  0,  0,  0,  0},
            {104,204,204,105,204,204,204,106,204,204,204,204,  0,  0,  0,  0,  0,  0},
            {104,  0,  0,105,  0,  0,  0,106,  0,  0,  0,  0,  0, 28,  0,  0,  0,  0},
            {104,203,203,105,203,203,203,106,203,203,203,203,  0,  7,  0,  0,  0,  0},
            {202,202,202,202,202,202,202,202,202,202,202,202,  0,  0,  0,  0,  0,  0},
    };
    private String inputBuffer;
    Parser(String inputBuffer) {
        this.inputBuffer = inputBuffer;
    }
    public void MainParser() {
        System.out.println(inputBuffer);
        Stack<Integer> state = new Stack<>();
        Stack<String> sym = new Stack<>();
        sym.push("$");
        state.push(0);
        Lexer lexer = new Lexer(inputBuffer);
        lexer.Scanner();
        ArrayList<String> inputBuffers = lexer.getToken();
        inputBuffers.add("$");
        while(true) {
            if (inputBuffers.size()==0) {
                System.out.println("分析未结束，输入符号已空");
            }
            if(state.peek() == 1 && sym.peek() == "$" && inputBuffers.get(0) == "$") {
                System.out.println("分析结束！");
                break;
            }
            else {
                int gotonumber = analysisTable[state.peek()][getnonEndIndex(inputBuffers.get(0))];
                int mov = gotonumber/100;
                int toward = gotonumber%100;
                if(mov == 1){
                    state.push(toward);
                    sym.push(inputBuffers.get(0));
                    inputBuffers.remove(0);
                } else if(mov == 2) {
                    String right = getProductionRight(toward);
                    String left = getProductionLeft(toward);
                    String out = "";
                    int p=right.length()-1;
                    int q=right.length()-1;
                    while (p>=0) {
                        String temp = sym.pop();
                        q=p;
                        if(temp.equals(right.substring(q,p))){
                            p=p-temp.length();
                        }
                        else {
                            System.out.println("规约时产生式不匹配");
                        }
                    }
                    sym.push(left);
                    int startindex = getstartIndex(left);
                    state.push(analysisTable[state.peek()][startindex]);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String text = new String();
        while(scanner.hasNext()){
            String temp = scanner.next();
            text = text + temp;
        }
        Parser lexer = new Parser(text);
        lexer.MainParser();
    }
}
