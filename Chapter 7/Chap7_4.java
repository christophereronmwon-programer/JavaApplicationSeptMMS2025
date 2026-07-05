import java.util.Scanner;
import java.util.Random;

public class Chap7_4 {
    public enum Face { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int playerWins = 0;
        int dealerWins = 0;
        int ties = 0;

        System.out.println("Starting a 20-game stretch against the AI...");

        for (int game = 1; game <= 20; game++) {
            System.out.printf("\n================ GAME %d =================\n", game);
            int[] deck = new int[52];
            for (int i = 0; i < deck.length; i++) deck[i] = i;
            shuffleDeck(deck);

            int[] playerHand = new int[5];
            int[] dealerHand = new int[5];
            int deckIndex = 0;

            for (int i = 0; i < 5; i++) {
                playerHand[i] = deck[deckIndex++];
                dealerHand[i] = deck[deckIndex++];
            }

            // Player Phase
            System.out.println("Your Hand:");
            displayHand(playerHand);
            
            System.out.print("How many cards to replace? (0-3): ");
            int replaceCount = input.nextInt();
            if (replaceCount > 0 && replaceCount <= 3) {
                for (int i = 0; i < replaceCount; i++) {
                    System.out.print("Enter index position to drop (0 to 4): ");
                    int dropIndex = input.nextInt();
                    playerHand[dropIndex] = deck[deckIndex++];
                }
                System.out.println("Your New Hand:");
                displayHand(playerHand);
            }

            // Dealer Phase
            deckIndex = executeDealerTurn(dealerHand, deck, deckIndex);

            // Final Evaluation
            int pScore = evaluateHandRank(playerHand);
            int dScore = evaluateHandRank(dealerHand);

            System.out.println("\n--- Final Reveal ---");
            System.out.print("Player Score Tier: " + pScore + " | ");
            System.out.println("Dealer Score Tier: " + dScore);
            System.out.println("Dealer Hand was:");
            displayHand(dealerHand);

            if (pScore > dScore) {
                System.out.println("Outcome: You Win!");
                playerWins++;
            } else if (dScore > pScore) {
                System.out.println("Outcome: Computer Wins!");
                dealerWins++;
            } else {
                System.out.println("Outcome: Tie!");
                ties++;
            }
        }

        System.out.println("\n================ FINAL TOURNAMENT REPORT ================");
        System.out.printf("Player Wins: %d | Dealer Wins: %d | Ties: %d\n", playerWins, dealerWins, ties);
    }

    public static int executeDealerTurn(int[] hand, int[] deck, int deckIndex) {
        int score = evaluateHandRank(hand);
        if (score >= 4) return deckIndex;

        int[] counts = new int[13];
        for (int card : hand) counts[card % 13]++;

        if (score == 3 || score == 2 || score == 1) {
            for (int i = 0; i < hand.length; i++) {
                if (counts[hand[i] % 13] == 1) hand[i] = deck[deckIndex++];
            }
        } else {
            for (int i = 0; i < hand.length - 1; i++) {
                for (int j = i + 1; j < hand.length; j++) {
                    if ((hand[i] % 13) > (hand[j] % 13)) {
                        int temp = hand[i]; hand[i] = hand[j]; hand[j] = temp;
                    }
                }
            }
            hand[0] = deck[deckIndex++];
            hand[1] = deck[deckIndex++];
            hand[2] = deck[deckIndex++];
        }
        return deckIndex;
    }

    public static void shuffleDeck(int[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = deck[i]; deck[i] = deck[j]; deck[j] = temp;
        }
    }

    public static int evaluateHandRank(int[] hand) {
        if (hasFlush(hand) && hasStraight(hand)) return 8;
        if (hasFourOfAKind(hand)) return 7;
        if (hasFullHouse(hand)) return 6;
        if (hasFlush(hand)) return 5;
        if (hasStraight(hand)) return 4;
        if (hasThreeOfAKind(hand)) return 3;
        if (hasTwoPairs(hand)) return 2;
        if (hasPair(hand)) return 1;
        return 0;
    }

    public static void displayHand(int[] hand) {
        for (int i = 0; i < hand.length; i++) {
            System.out.printf("  [%d] %s of %s\n", i, Face.values()[hand[i] % 13], Suit.values()[hand[i] / 13]);
        }
    }

    private static int[] getFaceCounts(int[] hand) {
        int[] counts = new int[13];
        for (int card : hand) counts[card % 13]++;
        return counts;
    }

    public static boolean hasPair(int[] hand) {
        for (int c : getFaceCounts(hand)) if (c == 2) return true;
        return false;
    }

    public static boolean hasTwoPairs(int[] hand) {
        int p = 0;
        for (int c : getFaceCounts(hand)) if (c == 2) p++;
        return p == 2;
    }

    public static boolean hasThreeOfAKind(int[] hand) {
        for (int c : getFaceCounts(hand)) if (c == 3) return true;
        return false;
    }

    public static boolean hasFourOfAKind(int[] hand) {
        for (int c : getFaceCounts(hand)) if (c == 4) return true;
        return false;
    }

    public static boolean hasFlush(int[] hand) {
        int s = hand[0] / 13;
        for (int i = 1; i < hand.length; i++) if ((hand[i] / 13) != s) return false;
        return true;
    }

    public static boolean hasStraight(int[] hand) {
        int[] counts = getFaceCounts(hand);
        int start = -1;
        for (int i = 0; i < counts.length; i++) { if (counts[i] > 0) { start = i; break; } }
        if (start <= 8 && start != -1) {
            for (int i = start; i < start + 5; i++) if (counts[i] != 1) return false;
            return true;
        }
        return counts[12] == 1 && counts[0] == 1 && counts[1] == 1 && counts[2] == 1 && counts[3] == 1;
    }

    public static boolean hasFullHouse(int[] hand) {
        boolean t = false, w = false;
        for (int c : getFaceCounts(hand)) {
            if (c == 3) t = true;
            if (c == 2) w = true;
        }
        return t && w;
    }
}