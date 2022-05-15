package day2;

/**
 * Solution509
 *
 * @author alexpetertyler
 * @since 2022/5/15
 */
public class Solution509 {
    private final int[] demo = new int[2000 + 1];
    private final int[] demo2 = new int[2];

    public int fib(int n) {
//        return calc(n);
        return calc2(n);
    }

    private int calc(int n) {
        if (n == 0 || n == 1) return n;
        if (demo[n] != 0) return demo[n];
        int i = calc(n - 1) + calc(n - 2);
        demo[n] = i;
        return i;
    }

    //LeetCode中，calc2内存消耗高于calc1 0.5MB，但calc2开辟了更小的数组空间
    private int calc2(int n) {
        if (n == 0 || n == 1) return n;
        demo2[1] = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = demo2[0] + demo2[1];
            demo2[0] = demo2[1];
            demo2[1] = temp;
        }
        return demo2[1];
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.calc2(2000));
        long end = System.currentTimeMillis();
        System.out.printf("calc用时：%s", end - start);
    }
}
