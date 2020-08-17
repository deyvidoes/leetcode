public class HasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits2(5));
        System.out.println(hasAlternatingBits(4));
        System.out.println(hasAlternatingBits2(4));
    }

    public static boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);

        for(int i = 0; i < binary.length() - 1; i++)
            if(binary.charAt(i) == binary.charAt(i + 1))
                return false;

        return true;
    }

    public static boolean hasAlternatingBits2(int n) {
        int cur = n % 2;
        n /= 2;
        while (n > 0) {
            if (cur == n % 2) return false;
            cur = n % 2;
            n /= 2;
        }
        return true;
    }

}
