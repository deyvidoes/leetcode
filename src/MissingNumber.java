import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(missingNumber2(new int[]{2, 1, 3, 4, 5, 6, 7, 8, 0}));
        System.out.println(missingNumber3(new int[]{2, 1, 3, 4, 5, 6, 7, 8, 0}));
    }

    public static int missingNumber(int[] nums) {
        var arr = new int[nums.length + 1];
        for (var number : nums)
            arr[number]++;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 0)
                return i;

        return -1;
    }

    public static int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0)
            return 0;

        if (nums[nums.length - 1] != nums.length)
            return nums.length;

        for (int i = 1; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return -1;
    }
    //0,1,3
    public static int missingNumber3(int[] nums) {
        var sum = 0;
        var length = nums.length;
        for (int i = 0; i < length; i++) {
            sum = sum + i;
            sum = sum - nums[i];
        }

        return sum + length;
    }


}
