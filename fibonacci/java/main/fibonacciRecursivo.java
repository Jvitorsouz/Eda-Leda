import java.util.Scanner;

class fibonacciRecursivo {

    public static void main(String[] args) {

        fibonacciRecursivo fibonacci = new fibonacciRecursivo();
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        System.out.println(fibonacci.fibonacciRecursivo(key));
    }

    public int fibonacciRecursivo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
    }

}