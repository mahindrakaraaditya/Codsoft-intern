import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    static class Question {
        String question;
        String[] options;
        int correctAnswerIndex;

        public Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public boolean isCorrect(int userAnswerIndex) {
            return userAnswerIndex == correctAnswerIndex;
        }
    }

    private ArrayList<Question> questions = new ArrayList<>();
    private int score = 0;
    private boolean timeUp = false;

    public QuizApplication() {
        // Initialize questions
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, 0));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"Shakespeare", "Dickens", "Hemingway", "Austen"}, 0));
        questions.add(new Question("What is 5 + 7?", new String[]{"10", "11", "12", "13"}, 2));
        // Add more questions as needed
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            displayQuestion(question);
            timeUp = false;
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    timeUp = true;
                    System.out.println("\nTime's up!");
                }
            }, 10000); // 10 seconds per question

            int answer = -1;
            while (!timeUp) {
                System.out.print("Select an option (0-3): ");
                if (scanner.hasNextInt()) {
                    answer = scanner.nextInt();
                    if (answer >= 0 && answer < question.options.length) {
                        break;
                    } else {
                        System.out.println("Invalid option. Try again.");
                    }
                } else {
                    scanner.next(); // clear invalid input
                }
            }
            timer.cancel();

            if (!timeUp && answer != -1 && question.isCorrect(answer)) {
                score++;
            }

            System.out.println("Correct answer was: " + question.options[question.correctAnswerIndex]);
            System.out.println();
        }

        displayResults();
        scanner.close();
    }

    public void displayQuestion(Question question) {
        System.out.println("Question: " + question.question);
        for (int i = 0; i < question.options.length; i++) {
            System.out.println(i + ": " + question.options[i]);
        }
    }

    public void displayResults() {
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        QuizApplication quiz = new QuizApplication();
        quiz.startQuiz();
    }
}
