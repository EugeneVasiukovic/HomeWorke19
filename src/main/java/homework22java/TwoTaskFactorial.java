package homework22java;

public class TwoTaskFactorial {

    public static void main(String[] args) {
        int numberOfFactorial = 5;
        int count = 1;
        while (numberOfFactorial > 0){
            count *= numberOfFactorial;
            numberOfFactorial--;
        }
        System.out.println("Number of a factorial " + 5 +" equals " + count);
    }
}