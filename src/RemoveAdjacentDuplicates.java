import java.util.Stack;

public class RemoveAdjacentDuplicates {
    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicatesWithoutStack(str));
    }

    //input: abbaca
    //output: ca
    //Time: O(n) | Space: O(n + m) where n is the size of the stack and m the StringBuilder
    public static String removeDuplicates(String str) {
        var stack = new Stack<Character>(); //create a Stack
        for (var ch : str.toCharArray()) { //loop through the characters in the string
            if (!stack.isEmpty()) //if the Stack is not empty, peek the item at the top
                if (stack.peek() == ch) //if the top item matches the current character, pop it from the stack
                    stack.pop();
                else
                    stack.push(ch);     //otherwise push it to the Stack
            else
                stack.push(ch); //if the stack is empty, just push the character
        }

        var result = new StringBuilder(); //create string builder for result String
        for (var ch : stack) //iterate through the stack
            result.append(ch); //append each value to the StringBuilder

        return result.toString(); //return it as a String
    }

    //Time: O(n) | Space: O(n)
    public static String removeDuplicatesWithoutStack(String str) {
        if (str.isEmpty()) //if Empty, return the empty string
            return str;

        var sb = new StringBuilder(); //create StringBuilder
        sb.append(str.charAt(0)); //add the first character to string builder

        for (int i = 1; i < str.length(); i++) { //loop through remaining characters
            //if the last character in the StringBuilder is the same as the current character, remove it
            //Otherwise add it to the StringBuilder
            if (sb.length() >=  1 && sb.charAt(sb.length() - 1) == str.charAt(i))
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(str.charAt(i));
        }
        return sb.toString(); //return it as a String
    }
}
