package sort;

public class RadixSort {
    public static void main(String[] args) {
        final int[] nums = {8, 26, 23, 11, 27, 501, 2, 34, 56, 253};
        int[] temp = new int[nums.length];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i - 1], nums[i]);
        }
        radixSort(nums, nums.length, max);
    }

    private static void radixSort(int[] nums, int length, int max) {
        for (int i = 1; (max / i) > 0; i = i * 10) {
            countSort(nums, length, i);
        }
    }

    private static void countSort(int[] nums, int length, int digit) {
        int[] temp = new int[length];
        int[] cnt = new int[length];

        System.out.println("\n\n" + digit + "의 자리 정렬 전 값");
        for (int i = 0; i < length; i++) {
            System.out.printf("%3d ", nums[i]);
        }
        for (int i = 0; i < length; i++) {
            cnt[(nums[i]/digit) % 10]++;
        }
        for (int i = 1; i <= length - 1; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }
        for (int i = length - 1; i >= 0; i--) {
            int cntValue = (nums[i] / digit) % 10;
            int newIdx = cnt[cntValue] - 1;
            temp[newIdx] = nums[i];
            cnt[cntValue]--;
        }
        for (int i = 0; i < length; i++) {
            nums[i] = temp[i];
        }
        System.out.println("\n\n" + digit + "의 자리 정렬 후 값");
        for (int i = 0; i < length; i++) {
            System.out.printf("%3d ", nums[i]);
        }
    }
}
