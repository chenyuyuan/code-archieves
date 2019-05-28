package al;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int res=0;

        Set setJ=new HashSet();
        for(char j: J.toCharArray()) setJ.add(j);
        for(char s: S.toCharArray()) if(setJ.contains(s))res++;
        return res;
    }
    public Boolean F(String strs){
        String ss=strs.toLowerCase();
        char[] ca=ss.toCharArray();
        int start=0;
        int end=ca.length-1;
        while(start<end){
            if(!Character.isLetter(ca[start])){
                start++;
                continue;
            }
            else if(!Character.isLetter(ca[end])){
                end--;
                continue;
            }
            else if(ca[start]==ca[end]){
                start++;
                end--;
                continue;
            }
            else if(ca[start]!=ca[end]){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        String s="A man,a plan,a canal:Panama";
        Solution solution=new Solution();
        System.out.print(solution.F(s));
    }
}
