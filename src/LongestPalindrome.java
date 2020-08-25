public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("asdhuasduiasdiqygiasdiagbvuyguasvbdjuacuyscbaisd"));
        System.out.println(longestPalindrome("abccccdd"));
    }

    //Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
    //
    //Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
    //
    //Example 1:
    //Input: s = "abccccdd"
    //Output: 7
    //Explanation:
    //One longest palindrome that can be built is "dccaccd", whose length is 7.
    public static int longestPalindrome(String s) {
        int[] count = new int[58];
        for(var ch : s.toCharArray())
            count[ch - 'A']++;

        var palindromeLength = 0;
        for(var charCount : count){
            palindromeLength += charCount / 2 * 2; //add even chars

            if(palindromeLength % 2 == 0 && charCount % 2 == 1)
                palindromeLength++;
        }
        return palindromeLength;
    }
}
