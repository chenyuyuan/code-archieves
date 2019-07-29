package spto;

public class question05 {
    // 面试题5：替换空格
    // 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入“”“”“"We are happy"，则输入"We%20are%20happy"
    public static char[] replaceSpace(char[] s, int length) {
        int spaceCount = 0;
        for(char c : s) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        if(spaceCount == 0) {
            return s;
        }
        int j = length + 2 * spaceCount - 1;
        int i = length - 1;
        while(i >= 0 && i < j) {
            if(s[i] == ' ') {
                s[j] = '0';
                s[j - 1] = '2';
                s[j - 2] = '%';
                j = j - 3;
            }
            else {
                s[j] = s[i];
                j--;
            }
            i--;
        }
        return s;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = 'W';string[1] = 'e';string[2] = ' ';
        string[3] = 'a';string[4] = 'r';string[5] = 'e';string[6] = ' ';
        string[7] = 'h';string[8] = 'a';string[9] = 'p';string[10] = 'p';string[11] = 'y';
        System.out.println(replaceSpace(string,12));
    }
}
