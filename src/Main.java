import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number between 1-10 to choose a task: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    measureTime(() -> {
                        System.out.println("Task 1. \nEnter the length of the array and the elements of the array separated by spaces: ");
                        Scanner scanner = new Scanner(System.in);
                        int num = scanner.nextInt(); //Length of the array
                        int[] arr = new int[num];
                        for (int i = 0; i < num; i++) {
                            arr[i] = scanner.nextInt(); //Elements of the array
                        }
                        int min = arr[0];
                        for (int i = 1; i < num; i++) {
                            if (arr[i] < min) {
                                min = arr[i];
                            }
                        }
                        System.out.println("Smallest element: " + min);
                    });
                    break;
                case 2:
                    measureTime(() -> {
                        System.out.println("Task 2. \nEnter the length of the array and the elements of the array separated by spaces: ");
                        Scanner scanner = new Scanner(System.in);
                        int num = scanner.nextInt(); //Length of the array
                        int sum = 0;
                        System.out.println("Enter " + num + " integers:");
                        for (int i = 0; i < num; i++) {
                            sum += scanner.nextInt(); //Elements of the array
                        }
                        double average = (double) sum / num;
                        System.out.println("Average: " + average);
                    });
                    break;
                case 3:
                    measureTime(() -> {
                        System.out.println("Task 3. \nEnter a number to check if it's prime or composite: ");
                        Scanner scanner = new Scanner(System.in);
                        int num = scanner.nextInt(); //Number to check
                        boolean isPrime = true;
                        if (num <= 1) {
                            isPrime = false;
                        } else {
                            for (int i = 2; i <= Math.sqrt(num); i++) {
                                if (num % i == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        }
                        System.out.println(isPrime ? num + " is Prime." : num + " is Composite.");
                    });
                    break;
                case 4:
                    measureTime(() -> {
                        System.out.println("Task 4. \nEnter a number to calculate its factorial: ");
                        Scanner scanner = new Scanner(System.in);
                        int num = scanner.nextInt(); //Number to calculate factorial
                        int factorial = 1;
                        for (int i = 1; i <= num; i++) {
                            factorial *= i;
                        }
                        System.out.println("Factorial of " + num + " is: " + factorial);
                    });
                    break;
                case 5:
                    measureTime(() -> {
                        System.out.println("Task 5. \nEnter the value of n to find the nth Fibonacci number: ");
                        Scanner scanner = new Scanner(System.in);
                        int n = scanner.nextInt(); //Value of n
                        int a = 0, b = 1;
                        int fib = 0;
                        if (n == 0) {
                            fib = 0;
                        } else if (n == 1) {
                            fib = b;
                        } else {
                            for (int i = 2; i <= n; i++) {
                                fib = a + b;
                                a = b;
                                b = fib;
                            }
                        }
                        System.out.println("The " + n + "Fibonacci number is: " + fib);
                    });
                    break;
                case 6:
                    measureTime(() -> {
                        System.out.println("Task 6. \nEnter two numbers 'a' and 'b' to calculate a^b: ");
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt(); //Value of a
                        int b = scanner.nextInt(); //Value of b
                        long result = power(a, b);
                        System.out.println(a + "^" + b + " = " + result);
                    });
                    break;
                case 7:
                    measureTime(() -> {
                        System.out.println("Task 7. \nEnter the number of integers to reverse followed by the integers separated by spaces: ");
                        Scanner scanner = new Scanner(System.in);
                        int num = scanner.nextInt(); //Number of integers to reverse
                        int[] arr = new int[num];
                        System.out.println("Enter " + num + " integers:");
                        for (int i = 0; i < num; i++) {
                            arr[i] = scanner.nextInt(); //Integers to reverse
                        }
                        System.out.println("Reversed array:");
                        for (int i = num - 1; i >= 0; i--) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    });
                    break;
                case 8:
                    measureTime(() -> {
                        System.out.println("Task 8. \nEnter a string to check if it contains only digits: ");
                        Scanner scanner = new Scanner(System.in);
                        String s = scanner.nextLine(); //String to check
                        boolean allDigits = true;
                        for (char c : s.toCharArray()) {
                            if (!Character.isDigit(c)) {
                                allDigits = false;
                                break;
                            }
                        }
                        System.out.println(allDigits ? "The string contains only digits." : "The string contains characters other than digits.");
                    });
                    break;
                case 9:
                    measureTime(() -> {
                        System.out.println("Task 9. \nEnter two integers 'n' and 'k' to calculate the binomial coefficient C(n, k): ");
                        Scanner scanner = new Scanner(System.in);
                        int n = scanner.nextInt(); //Value of n
                        int k = scanner.nextInt(); //Value of k
                        int result = binomialCoefficient(n, k);
                        System.out.println("Binomial Coefficient C(" + n + ", " + k + ") = " + result);
                    });
                    break;
                case 10:
                    measureTime(() -> {
                        System.out.println("Task 10. \nEnter two integers 'a' and 'b' to calculate their greatest common divisor (GCD): ");
                        Scanner scanner = new Scanner(System.in);
                        int a = scanner.nextInt(); //Value of a
                        int b = scanner.nextInt(); //Value of b
                        int gcd = gcd(a, b);
                        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
                    });
                    break;
                default:
                    System.out.println("Please choose the right task number");
            }
        }
    }

    public static void measureTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();

        double totalTime = (endTime - startTime) / 1000000000.0;

        System.out.println("Execution time: " + totalTime + " seconds");
    }

    // Power method for task 6
    private static long power(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    // Binomial coefficient method for task 9
    private static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < k; i++) {
            numerator *= (n - i);
        }

        for (int i = 1; i <= k; i++) {
            denominator *= i;
        }

        return numerator / denominator;
    }


    // GCD (greatest common divisor) method for task 10
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
