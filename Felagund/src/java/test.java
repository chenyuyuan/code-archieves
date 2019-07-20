public class test {
    public static void main(String[] args){
        for (int a = 1000;a < 10000;a++) {
            int num = a;
            int rev = 0;
            while (num != 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }
            if (rev == a * 9) {
               System.out.println(rev);
            }
        }
    }
}
