package unnamed.problem1;

/*
Input - "My name ear be"
Output - "be raee man yn"
*/

import java.util.ArrayList;

public class Approach1 {

    static String input = "My name is Eeshan";

    public static void main(String args[]) {
        ArrayList<Integer> spaces = new ArrayList();
        String[] parts = input.split(" ");
        String inputWithOutSpace = String.join("", parts);
       // System.out.println(inputWithOutSpace);
        // count spaces
        for (int i = 0; i < parts.length; i++) {
            spaces.add(parts[i].length());
        }
       // System.out.println(spaces);
        StringBuilder sb = new StringBuilder(inputWithOutSpace).reverse();
        String result = "";
        for (int j = 0; j < spaces.size(); j++) {
            result = result + sb.substring(0, spaces.get(j)) + " ";
            sb = sb.delete(0,spaces.get(j));
        }
        System.out.println(result);
    }
}

/*
The warning you are seeing is likely due to the fact that string concatenation using the + operator inside a loop can be inefficient.
In each iteration, it creates a new String object, which can lead to high memory usage and slower performance. A better approach is
to use a StringBuilder for concatenation within the loop.
 */
