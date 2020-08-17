import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var arr = new int[]{2, 2, 3, 3, 3, 7, 7, 7};
        System.out.println(findLucky(arr));
        System.out.println(findLuckyWithoutMap(arr));

        System.out.println("====================================");
        var sentence = "i love eating burger";
        var searchWord = "burg";
        System.out.println("Index of prefix: " + isPrefixOfWord(sentence, searchWord));
    }

    //1394. Find Lucky Integer in an Array
    //Time: O(n) | Space: O(n)
    public static int findLucky(int[] arr) {
        if (arr.length == 1 || arr == null)
            return -1;

        //get the frequency of each value and add it to a HashMap
        var map = new HashMap<Integer, Integer>();
        for (var number : arr) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        var current = 0;
        for (var key : map.keySet()) //iterate through all the keys
            if (key > current && map.get(key) == key) //get the biggest key that matches its frequency aka lucky integer
                current = key;

        return current > 0 ? current : -1; //if current is bigger than 0, return it, otherwise return -1
    }

    //1394. Find Lucky Integer in an Array
    //Time: O(n) | Space: O(1)
    public static int findLuckyWithoutMap(int[] arr) {
        if (arr.length == 1 || arr == null)
            return -1;

        var frequencies = new int[501];
        //get the frequency of each value and add it to the array
        for (var number : arr)
            frequencies[number]++;

        var current = 0;
        for (var number : arr)
            if (number > current && frequencies[number] == number)
                current = number;

        return current > 0 ? current : -1; //if current is bigger than 0, return it, otherwise return -1
    }

    //1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
    public static int isPrefixOfWord(String sentence, String searchWord) {
        var sentenceArray = sentence.split(" ");
        for(int i = 0; i < sentenceArray.length; i++)
            if(hasPrefix(searchWord, sentenceArray[i]))
                return i + 1;

        return -1;
    }

    public static boolean hasPrefix(String prefix, String word){
        if(prefix.length() > word.length())
            return false;
        
        for(int i = 0; i < prefix.length(); i++)
            if(word.charAt(i) != prefix.charAt(i))
                return false;

        return true;
    }
}
