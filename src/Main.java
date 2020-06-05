public class Main {

    /**
     * F45 benötigt über 367 Millionen Aufrufe
     * F(45) = 1134903170 calculated with 3672623805 recursive calls.
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public static long fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
