package homework22java;

public class FiveTaskFibanacci {
    public static void main(String[] args) {
            int first = 0;
            int second = 1;
            System.out.print("Fibonacci numbers up to 7: ");

        while (first <= 7) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
}