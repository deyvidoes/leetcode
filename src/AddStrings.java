public class AddStrings {
    public static void main(String[] args) {
        System.out.println('2' - '0');
        System.out.println(1 % 10);

        System.out.println(addStrings("123", "993"));

    }

    //Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
    //Constraints:
    //The length of both num1 and num2 is < 5100.
    //Both num1 and num2 contains only digits 0-9.
    //Both num1 and num2 does not contain any leading zero.
    //You must not use any built-in BigInteger library or convert the inputs to integer directly.

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        var index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;

        while (index1 >= 0 || index2 >= 0 || carry != 0) {
            int sum = carry;
            if (index1 >= 0) {
                sum = sum + (num1.charAt(index1) - '0');
                index1--;
            }
            if (index2 >= 0) {
                sum = sum + (num2.charAt(index2) - '0');
                index2--;
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
