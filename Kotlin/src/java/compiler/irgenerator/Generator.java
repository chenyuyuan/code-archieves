package compiler.irgenerator;

import java.util.*;

class AnasisNode {
    public int kind;
    public int val;
    public LinkedList<AnasisNode> children;
    public ArrayList<Integer> trueList;
    public ArrayList<Integer> falseList;
    public ArrayList<Integer> nextList;
    public AnasisNode() {}

    public AnasisNode(int _val,LinkedList<AnasisNode> _children) {
        val = _val;
        children = _children;
    }
}

public class Generator {
    String triAddrCode = new String();


    public void MainGenerator(AnasisNode head) {
        Stack<AnasisNode> stack = new Stack<>();
        AnasisNode p = head;

        while (p != null) {
            if(p.children!=null){
                stack.push(p);
                p = p.children.get(0);
            } else {

            }


        }
    }
    public static void main(String[] args){


    }
}
