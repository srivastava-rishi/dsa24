package named;

public class AllPossibleSubString {

    static String input = "geeks";

    /*
    formula : -
    n(n+1)/2
    5(5+1)/2
    30/2
    15 possible substring
    */

    // g
    // ge
    // gee
    // geek
    // geeks
    // e
    // ee
    // eek
    // eeks
    // e
    // ek
    // eks
    // k
    // ks
    // s


    // geeks
    public static void main(String args[]) {
        for (int i = 0; i < input.length(); i++) {
            // This will tell you starting  from where you want to get all possible substring
            // case1: - G
            // case2: - e
            // ... tile case^n :-  = s
            String temp = "";
            // Her j  initial value is i so it will start getting
            for (int j = i; j < input.length(); j++) {
                temp = temp + input.charAt(j);
                System.out.println(temp);
            }
        }
    }
}
