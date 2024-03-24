package leetcode;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int m = A.length, n = B.length;
        int k = (m + n) / 2;
        if ((m + n) % 2 != 0) {
            return solve(A, B, k, 0, m - 1, 0, n - 1);
        } else {
            return (solve(A, B, k, 0, m - 1, 0, n - 1) + solve(A, B, k - 1, 0, m - 1, 0, n - 1)) / 2.0;
        }
    }

    public double solve(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        if (aStart > aEnd) {
            return B[k - aStart];
        } else if (bStart > bEnd) {
            return A[k - bStart];
        }

        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex];
        int bValue = B[bIndex];
        if (aIndex + bIndex < k) {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return solve(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        } else {
            if (aValue > bValue) {
                return solve(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return solve(A, B, k, aStart, aEnd, bStart, bIndex - 1);
            }
        }


    }


    public static void main(String[] args) {
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{4, 5, 6}, new int[]{1, 2, 3, 7, 8, 9}));
//        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 7, 9}, new int[]{2, 3, 4, 5}));
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3, 4, 7}, new int[]{2, 5, 6, 8, 9}));


    }
}
