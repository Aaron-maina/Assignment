import java.util.Scanner;

public class ExamProgram {
    // Sample results for coursework and exam (these could be fetched from a database or another source)
    private static int[] courseworkResults = {85, 78, 90, 70, 88}; // Assume ass1, ass2, ass3, cat1, cat2
    private static int finalExamResult = 82; // Assume final exam score

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults();
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);
        
        scanner.close();
    }

    private static void viewCourseworkResults() {
        System.out.println("Coursework Results:");
        for (int i = 0; i < courseworkResults.length; i++) {
            System.out.println("Assessment " + (i + 1) + ": " + courseworkResults[i]);
        }
        int courseworkAssessmentsDone = countCourseworkAssessments();
        System.out.println("Total coursework assessments done: " + courseworkAssessmentsDone);
        if (hasCompletedTwoThirds(courseworkAssessmentsDone)) {
            System.out.println("The student has completed 2/3 of the coursework.");
        } else {
            System.out.println("The student has NOT completed 2/3 of the coursework and must repeat.");
        }
    }

    private static void viewExamResults() {
        int courseworkScore = calculateCourseworkScore();
        int totalScore = courseworkScore + finalExamResult;
        
        System.out.println("Coursework Score (50%): " + courseworkScore);
        System.out.println("Final Exam Score (50%): " + finalExamResult);
        System.out.println("Total Score: " + totalScore);
    }

    private static int countCourseworkAssessments() {
        int count = 0;
        for (int i = 0; i < courseworkResults.length; i++) {
            if (courseworkResults[i] > 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasCompletedTwoThirds(int courseworkAssessmentsDone) {
        // There are 5 assessments in total (ass1, ass2, ass3, cat1, cat2)
        return courseworkAssessmentsDone >= (2.0 / 3.0) * 5;
    }

    private static int calculateCourseworkScore() {
        int total = 0;
        for (int score : courseworkResults) {
            total += score;
        }
        return total / courseworkResults.length; // Assume equal weighting for simplicity
    }
}
