import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        var result = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        var result2 = majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (var number : nums)
            map.put(number, map.getOrDefault(number, 0) + 1);

        for (var key : map.keySet())
            if (map.get(key) > nums.length / 2)
                return key;

        return -1;
    }

    //sorting array first
    public static int majorityElement2(int[] nums) {
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        var countMax = 1;
        var max = 1;
        var result = 0;

        for (var i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                countMax++;
                if (countMax > max)
                    result = nums[i];
            } else {
                if (countMax > max) {
                    result = nums[i];
                    max = countMax;
                }
                countMax = 1;
            }
        }

        return result;
    }

    public static int majorityElement3(int[] nums) {
        mergeSort(nums);
        return nums[nums.length / 2];
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2)
            return;

        //Divide array into half
        var middle = arr.length / 2;

        int[] left = new int[middle];
        for (var i = 0; i < middle; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - middle];
        for (var i = middle; i < arr.length; i++)
            right[i - middle] = arr[i];

        //Sort each half
        mergeSort(left);
        mergeSort(right);

        //Merge the result
        mergeArrays(left, right, arr);
    }

    public static void mergeArrays(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

    }
}
