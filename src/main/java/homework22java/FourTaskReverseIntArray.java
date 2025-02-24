package homework22java;

import java.util.Arrays;

public class FourTaskReverseIntArray {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        System.out.println("Default array: " + Arrays.toString(intArray));


        for (int i = 0; i < intArray.length; i++) {
            if (i < intArray.length / 2) {
                int temp = intArray[i];
                intArray[i] = intArray[intArray.length - 1 - i];
                intArray[intArray.length - 1 - i] = temp;
            }
        }
        System.out.println("\nReverse array: " + Arrays.toString(intArray));
    }
}