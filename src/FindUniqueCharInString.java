import java.util.HashMap;

public class FindUniqueCharInString {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar2("loveleetcode"));
    }

    //Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    //
    //Examples:
    //
    //s = "leetcode"
    //return 0.
    //
    //s = "loveleetcode"
    //return 2.
    public static int firstUniqueChar(String s) {
        var map = new HashMap<Character, Integer>();
        for (var ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        System.out.println(map.size());

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1)
                return i;

        return -1;
    }

    public static int firstUniqueChar2(String s) {
        var charArr = new int[26];
        for (var ch : s.toCharArray())
            charArr[ch - 'a']++;

        for (int i = 0; i < s.length(); i++)
            if (charArr[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
