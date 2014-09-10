package jbowden.assignments.evenodd;

import java.util.Scanner;

public class EvenOddProgram implements Runnable {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        final int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        switch (n % 2) {
            case 0:
                System.out.println("Even");
                break;
            default:
                System.out.println("Odd");
                break;
        }
    }
}
