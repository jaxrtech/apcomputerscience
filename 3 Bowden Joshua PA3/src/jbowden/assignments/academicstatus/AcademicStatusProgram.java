package jbowden.assignments.academicstatus;

import jbowden.prompting.Prompt;
import jbowden.prompting.Prompter;

import java.util.Scanner;

class AcademicStatusProgram implements Runnable {
    private Scanner scanner;

    public AcademicStatusProgram() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        final double gpa = Prompter.getInstance().prompt(scanner, new Prompt<Double>() {
            @Override
            public void onError(Exception e) {
                if (e != null) {
                    System.out.printf("Error: %s Try again.\n", e.getMessage());
                }
            }

            @Override
            public void onPrompt() {
                System.out.printf("Enter GPA: ");
            }

            @Override
            public Double onInput() {
                final double gpa = scanner.nextDouble();

                if (gpa < 0.0 || gpa > 4.0) {
                    throw new IllegalStateException("Invalid GPA value.");
                }

                return gpa;
            }
        });

        System.out.printf("Message: %s\n", GPACategory.fromGPA(gpa).getMessage());
    }
}

