package named.longestsubstringwithoutrepeatingcharacters;

import java.util.ArrayList;

public class Approach1LongestNonRepeatingSubString {

    static String input = "abcabcbb";

    static int longestSubstringCount = Integer.MIN_VALUE;

    public static void ifContainDuplicate(String subString) {



        ArrayList<Character> list = new ArrayList<>();
        boolean containDuplicate = false;
        for (int i = 0; i < subString.length(); i++) {
            if (list.contains(subString.charAt(i))) {
                containDuplicate = true;
                break;
            }
            list.add(subString.charAt(i));
        }

        if (!containDuplicate) {
            longestSubstringCount = Math.max(longestSubstringCount,subString.length());
        }
    }

    public static void main(String args[]) {

        if(input.isBlank() || input.isEmpty()){
            System.out.println(0);
        }

        for (int i = 0; i < input.length(); i++) {
            String temp = "";
            for (int j = i; j < input.length(); j++) {
                temp = temp + input.charAt(j);
                ifContainDuplicate(temp);
            }
        }
        System.out.println(longestSubstringCount);
    }
}
