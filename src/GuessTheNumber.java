import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Map<String, Integer> playerScores = new HashMap<>();
        boolean playAgain;

        do {
            System.out.print(" Introdu numele tău: ");
            String playerName = scanner.next();

            int maxAttempts = 10;
            int numberToGuess = random.nextInt(100) + 1;
            int userGuess = 0;
            int attempts = 0;
            int score = maxAttempts;

            System.out.println("Am generat un număr între 1 și 100. Încearcă să-l ghicești!");
            System.out.println("Ai " + maxAttempts + " încercări.");

            while (userGuess != numberToGuess && attempts < maxAttempts) {
                System.out.print(" Introdu un număr: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Prea mic! Încearcă un număr mai mare.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Prea mare! Încearcă un număr mai mic.");
                } else {
                    System.out.println("Felicitări! Ai ghicit numărul în " + attempts + " încercări.");
                    score = maxAttempts - attempts + 1;
                }

                if (userGuess != numberToGuess) {
                    int attemptsLeft = maxAttempts - attempts;
                    System.out.println("Încercări rămase: " + attemptsLeft);
                }
            }

            if (userGuess == numberToGuess) {
                System.out.println("Scorul tău pentru această rundă este: " + score);
            } else {
                System.out.println("Ai epuizat toate încercările. Numărul corect era: " + numberToGuess);
                System.out.println("Mai mult noroc data viitoare!");
                score = 0; // Scor 0 dacă nu a ghicit numărul
            }

            // Adăugare scor la scorul total al jucătorului
            playerScores.put(playerName, playerScores.getOrDefault(playerName, 0) + score);

            // Afișare clasament actualizat
            System.out.println("\nClasamentul actual:");
            playerScores.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " puncte"));

            System.out.print("\nVrei să joci din nou? (da/nu): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("da");

        } while (playAgain);

        System.out.println("Mulțumim că ai jucat!");
    }
}


