public class MinStartValue1413 {
    public static void main(String[] args) {

        System.out.println("Minimum value: " + minStartValue(new int[]{1, 3, -5, 1, -45}));
        System.out.println(1 % 2);
    }

    public static int minStartValue(int[] nums) {
        var ans = 0;
        var sum = 0;
        for (var number : nums) {
            sum += number;
            ans = Math.min(ans, sum);
        }
        return Math.abs(ans) + 1;
    }
}
