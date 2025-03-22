package slidingWindow;

import java.util.ArrayList;

public class MaximumOfAllSubArray {


    static int a = 4;

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int windowSize = 3;
        int i = 0, j = 0;

        a = 6;

        ArrayList<Integer> answer = new ArrayList();
        int currentMaximum = 0;


        while (j < arr.length) {
            currentMaximum = Math.max(currentMaximum, arr[j]);

            //
            if (j - i + 1 < windowSize) {
                j++;
            }
            //
            if (j - i + 1 == windowSize) {
                answer.add(currentMaximum);
                i++;
                j++;
            }
        }

        System.out.println(answer);
    }
}
