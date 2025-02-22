package homework22java;

public class EightTaskNumberEqulsArray {

    public static boolean arraysEqual(int[] arrayOne, int[] arrayTwo) {
        if (arrayOne.length != arrayTwo.length) {
            return false;
        }

        for (int i = 0; i < arrayOne.length; i++) {
            if (arrayOne[i] != arrayTwo[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arrayIntegerOne = {10, 20, 30, 50, 60, 70, 80, 90, 100};
        int[] arrayIntegerTwo = {10, 20, 30, 50, 60, 70, 80, 90, 100};
        System.out.println("arrayIntegerOne and arrayIntegerTwo are equal: " + arraysEqual(arrayIntegerOne, arrayIntegerTwo) );
    }
}