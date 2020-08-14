import java.util.HashMap;
import java.util.LinkedList;

//1460. Make Two Arrays Equal by Reversing Sub-arrays
//Input: target = [1,2,3,4], arr = [2,4,1,3]
//Output: true
//Explanation: You can follow the next steps to convert arr to target:
//1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
//2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
//3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
//There are multiple ways to convert arr to target, this is not the only way to do so.

//Constraints:
//target.length == arr.length
//1 <= target.length <= 1000
//1 <= target[i] <= 1000
//1 <= arr[i] <= 1000
public class CanBeEqual {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(canBeEqualWithinConstraints(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (var number : target) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        for (var number : arr) {
            if (!map.containsKey(number))
                return false;

            if (map.get(number) == 1)
                map.remove(number);
            else
                map.put(number, map.get(number) - 1);
        }

        return map.isEmpty();
    }

    public static boolean canBeEqualWithinConstraints(int[] target, int[] arr) {
        var mapArray = new int[1001];
        for(var number : target)
            mapArray[number] = ++mapArray[number];

        for(var number : arr)
            mapArray[number] = --mapArray[number];

        for(var number : target)
            if(mapArray[number] != 0)
                return false;

        return true;
    }
}
