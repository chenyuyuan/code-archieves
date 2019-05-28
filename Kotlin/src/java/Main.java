import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] ca=in.toCharArray();
        int n=ca.length;
        for(int i=0;i<ca.length;++i){
            if(ca[i]=='['||ca[i]=='{'){
                ca[i]='(';
            }
            else if(ca[i]==']'||ca[i]=='}'){
                ca[i]=')';
            }
        }
        int flag=0;
        int sum=0;
        StringBuilder sa=new StringBuilder();
        for(int i=0;i<n;++i){
            if(flag==0){
                sb.append(ca[i]);
            }
            else if(isDigit(ca[i])){
                flag=1;
                sum=sum*10+ca[i]-'0';
            }
            else if(ca[i]==')'){
                flag=0;
                sa.reverse();
                for(int j=0;j<n;++j){
                    sb.append(sa.toString());
                }
            }
            else if(ca[i]!='('){
                sa.append(ca[i]);
            }
        }
        sb.reverse();
        System.out.print(sb.toString());
    }
    private static Boolean isDigit(char c){
        if(c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9'){
            return true;
        }
        else{
            return false;
        }
    }
}