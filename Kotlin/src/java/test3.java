import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] tab = new int[2 * n - 1][2 * n - 1];
        int max = (2 * n - 1) * (2 * n - 1);
        int a = 0, b = 0;
        int flag = 1;
        for (int i = max;i > 0;--i) {
            tab[a][b] = i;
            if(flag == 1) {
                if (a == 2 * n - 1){
                    flag = 2;
                    b++;
                }
                else if (a < 2 * n - 1){
                    if(tab[a + 1][b] != 0){
                        flag = 2;
                        b++;
                    }
                    else {
                        a++;
                    }
                }
            }
            if(flag == 2) {
                if (b == 2 * n - 1){
                    flag = 3;
                    a--;
                }
                else if (b < 2 * n - 1){
                    if(tab[a][b + 1] != 0){
                        flag = 3;
                        a--;
                    }
                    else {
                        b++;
                    }
                }
            }
            if(flag == 3) {
                if (a == 2 * n - 1){
                    flag = 4;
                    b--;
                }
                else if (a < 2 * n - 1){
                    if(tab[a - 1][b] != 0){
                        flag = 4;
                        b--;
                    }
                    else {
                        a--;
                    }
                }
            }
            if(flag == 4) {
                if (b == 2 * n - 1){
                    flag = 1;
                    a++;
                }
                else if (b < 2 * n - 1){
                    if(tab[a - 1][b] != 0){
                        flag = 1;
                        a++;
                    }
                    else {
                        b--;
                    }
                }
            }
        }
        for (int i = 0;i < 2 * n - 1;++i) {
            for (int j = 0;j < 2 * n - 1;++j){
                System.out.print(tab[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
