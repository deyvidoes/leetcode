import java.util.HashMap;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
        System.out.println(findTheDifference2("abcd", "abcde"));
    }

    //Given two strings s and t which consist of only lowercase letters.
    //String t is generated by random shuffling string s and then add one more letter at a random position.
    //Find the letter that was added in t.
    //
    //Example:
    //Input:
    //s = "abcd"
    //t = "abcde"
    //Output:
    //e
    //Explanation:
    //'e' is the letter that was added.
    public static char findTheDifference(String s, String t) {
        var map = new HashMap<Character, Integer>();
        for (var ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (var ch : s.toCharArray()) {
            if (map.get(ch) == 1)
                map.remove(ch);
            else
                map.put(ch, map.get(ch) - 1);
        }

        for (var key : map.keySet())
            return key;

        return ' ';
    }

    public static char findTheDifference2(String s, String t) {
        var arr = new int[26];
        for (var ch : t.toCharArray())
            arr[ch - 'a']++;

        for (var ch : s.toCharArray())
            arr[ch - 'a']--;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 1)
                return (char) (i + 'a');

        return ' ';
    }
}