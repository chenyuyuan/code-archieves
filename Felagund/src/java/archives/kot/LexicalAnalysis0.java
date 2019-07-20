package archives.kot;


import java.io.*;

// 标识符: if else while then do
// 运算符: +| - |* |/ |>| < | = | ( | ) | ; | ‘ | == | >= |<= | !=
// number, letter
// 分隔符:
//
public class LexicalAnalysis0 {
    private static String text;
    private static String[] key = {"if", "then", "else", "while", "do"};
    public LexicalAnalysis0(String text){
        this.text = text;
    }
    public static void Scanner() {
        int i = 0, n = text.length() - 1;
        char[] textc = text.toCharArray();
        while (i < n) {
            char c = text.charAt(i);
            if (c == ' ' || c == '\n' || c == '\t' || c == '\r') {
                i++;
            }
            else if(Character.isDigit(c)){

            }
            else if(Character.isLetter(c)){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while(true) {
                    if (Character.isLetterOrDigit(textc[i + 1])) {
                        sb.append(textc[i + 1]);
                        ++i;
                    }
                    else {
                        String s = sb.toString();
                        if(isKey(s)) {

                        }

                        continue;
                    }
                }
            }
        }

    }

    private static boolean isKey(String s){
        for(String k : key){
            if(s.equals(k)){
                return true;
            }
        }
        return false;
    }
    public static String readFile(String filename) throws IOException {
        File file = new File(filename);
        InputStream is = null;
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            is = new FileInputStream(file);
            reader = new InputStreamReader(is);
            bufferedReader = new BufferedReader(reader);
            String text = "";
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                text = text + line + '\n';
            }
            return text;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (null != bufferedReader)
                    bufferedReader.close();
                if (null != reader)
                    reader.close();
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filename;
    }


    public static void main(String[] args) throws IOException {
        String pathname = "C:\\Users\\Cyuyuan\\Desktop\\test0.txt";
        String text = readFile(pathname);
        System.out.println("Hello World!");
        //Scanner();
    }
}
