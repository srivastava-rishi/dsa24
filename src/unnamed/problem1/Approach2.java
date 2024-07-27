package unnamed.problem1;

import java.util.ArrayList;

public class Approach2 {

    static String input = "My name is Eeshan";
    //   na hseE si emanyM


    public static void main(String args[]) {
        ArrayList<Integer> spaces = new ArrayList();
        String[] parts = input.split(" ");
        String inputWithoutSpace = String.join("", parts);
        // count index of spaces
        int temp = 0;
        for (int i = 0; i < parts.length; i++) {
            temp = temp + parts[i].length();
            if (i != parts.length - 1) {
                spaces.add(temp);
            }
            temp++;
        }
        StringBuilder sb = new StringBuilder(inputWithoutSpace).reverse();
        System.out.println(sb);
        String result = "";

        for (int i = 0; i < spaces.size(); i++) {
            String prefix = sb.substring(0, spaces.get(i));
            String suffix = sb.substring(spaces.get(i));
            result = result + prefix + " " + suffix;
            System.out.println("prefix " + prefix);
            System.out.println("suffix " + suffix);
        }

        System.out.println(spaces);
        System.out.println(result);
    }
}
