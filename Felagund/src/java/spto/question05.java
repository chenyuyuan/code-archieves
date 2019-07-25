package spto;

public class question05 {
    // 面试题5：替换空格
    // 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入“”“”“"We are happy"，则输入"We%20are%20happy"
    public static String replaceSpace(String s) {
        int spaceCount = 0;
        for(char c : s.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        if(spaceCount == 0) {
            return s;
        }
        char[] newStringCharArray = new char[s.length() + 2 * spaceCount];
        int j = s.length() + 2 * spaceCount - 1;
        int i = s.length() - 1;
        while(i >= 0) {
            if(s.charAt(i) == ' ') {
                newStringCharArray[j] = '0';
                newStringCharArray[j - 1] = '2';
                newStringCharArray[j - 2] = '%';
                j = j - 3;
            }
            else {
                newStringCharArray[j] = s.charAt(i);
                j--;
            }
            i--;
        }
        return new String(newStringCharArray);
    }

    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceSpace(str));
    }
}
