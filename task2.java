import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        int[] intArray = { 21, 2, 4, 545, 6543, 234, 435, 656, 435, -43, -2111, 43, 0, -444 };
        int d = new Random().nextInt(2);
        System.out.println(d);
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
