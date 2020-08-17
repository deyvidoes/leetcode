public class ComplementOfBase10 {
    public static void main(String[] args) {
        int x = 50;
        int y = 5;

        System.out.println(bitwiseComplement(x));
        System.out.println(bitwiseComplement2(x));
        System.out.println(bitwiseComplement(y));
        System.out.println(bitwiseComplement2(y));

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));
    }

    public static int bitwiseComplement(int N) {
        if (N == 0)
            return 1;

        String binary = Integer.toBinaryString(N);
        // while(N > 0){
        //     binary = ((N % 2) == 0? "0" : "1") + binary;
        //     N = N /2;
        // }

        StringBuilder sb = new StringBuilder();
        for (var ch : binary.toCharArray())
            sb.append(ch == '1' ? '0' : '1');

        return Integer.parseInt(sb.toString(), 2);
    }

    public static int bitwiseComplement2(int N) {
        String binary = Integer.toBinaryString(N);

        int power = 0, answer = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1')
                power++;
            else {
                answer += Math.pow(2, power);
                power++;
            }
        }

        return answer;
    }
}
