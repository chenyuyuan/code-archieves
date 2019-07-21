package spto;

import java.util.ArrayList;

// 面试题3： 数组中重复的数字
public class question03 {
    //
    private static ArrayList<Integer> duplicate(int[] numbers) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            System.out.print("is null");
            return null;
        }
        for (int i = 0;i < numbers.length;++i) {
            if(numbers[i] < 0 || numbers[i] > numbers.length) {
                System.out.print("get over");
                return null;
            }
        }
        for (int i = 0;i < numbers.length;++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    if(!ans.contains(numbers[i]))
                        ans.add(numbers[i]);
                    break;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] list = {2, 3, 1, 0, 2, 5, 3,1,1};
        ArrayList<Integer> al = duplicate(list);
        for (int i : al) {
            System.out.print(i+ " ");
        }
    }
}
