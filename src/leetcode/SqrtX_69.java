package leetcode;

public class SqrtX_69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                left = (int) mid+1;
            } else {
                right =(int)  mid-1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX_69().mySqrt(777));
        System.out.println(new SqrtX_69().mySqrt(2147395599));
        System.out.println(new SqrtX_69().mySqrt(1));
        System.out.println(new SqrtX_69().mySqrt(2));
        System.out.println(new SqrtX_69().mySqrt(6));
        System.out.println(new SqrtX_69().mySqrt(8));
        System.out.println(new SqrtX_69().mySqrt(5));


    }
}
