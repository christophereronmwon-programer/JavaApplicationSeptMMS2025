import java.util.Random;
import java.util.Arrays;

public class Chap7_1 {
    public enum Face { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    public static void main(String[] args) {
        // Initialize deck (52 cards represented by their index 0 to 51)
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        shuffleDeck(deck);

        // Deal a 5-card hand
        int[] hand = new int[5];
        System.arraycopy(deck, 0, hand, 0, 5);

        System.out.println("Dealt Hand:");
        displayHand(hand);

        // Evaluate the hand
        System.out.println("\nHand Evaluation:");
        System.out.println("Has Pair: " + hasPair(hand));
        System.out.println("Has Two Pairs: " + hasTwoPairs(hand));
        System.out.println("Has Three of a Kind: " + hasThreeOfAKind(hand));
        System.out.println("Has Four of a Kind: " + hasFourOfAKind(hand));
        System.out.println("Has Flush: " + hasFlush(hand));
        System.out.println("Has Straight: " + hasStraight(hand));
        System.out.println("Has Full House: " + hasFullHouse(hand));
    }

    // Fisher-Yates Shuffling Algorithm
    public static void shuffleDeck(int[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static Face getFace(int card) {
        return Face.values()[card % 13];
    }

    public static Suit getSuit(int card) {
        return Suit.values()[card / 13];
    }

    public static void displayHand(int[] hand) {
        for (int card : hand) {
            System.out.printf("%s of %s\n", getFace(card), getSuit(card));
        }
    }

    // Helper to get counts of each face value in the hand
    private static int[] getFaceCounts(int[] hand) {
        int[] counts = new int[13];
        for (int card : hand) {
            counts[getFace(card).ordinal()]++;
        }
        return counts;
    }

    public static boolean hasPair(int[] hand) {
        for (int count : getFaceCounts(hand)) {
            if (count == 2) return true;
        }
        return false;
    }

    public static boolean hasTwoPairs(int[] hand) {
        int pairs = 0;
        for (int count : getFaceCounts(hand)) {
            if (count == 2) pairs++;
        }
        return pairs == 2;
    }

    public static boolean hasThreeOfAKind(int[] hand) {
        for (int count : getFaceCounts(hand)) {
            if (count == 3) return true;
        }
        return false;
    }

    public static boolean hasFourOfAKind(int[] hand) {
        for (int count : getFaceCounts(hand)) {
            if (count == 4) return true;
        }
        return false;
    }

    public static boolean hasFlush(int[] hand) {
        Suit firstSuit = getSuit(hand[0]);
        for (int i = 1; i < hand.length; i++) {
            if (getSuit(hand[i]) != firstSuit) return false;
        }
        return true;
    }

    public static boolean hasStraight(int[] hand) {
        int[] counts = getFaceCounts(hand);
        // Find the first face present
        int start = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                start = i;
                break;
            }
        }
        // Check for 5 consecutive faces
        if (start <= 8) {
            for (int i = start; i < start + 5; i++) {
                if (counts[i] != 1) return false;
            }
            return true;
        }
        // Special case: Ace-low straight (Ace, 2, 3, 4, 5)
        if (counts[12] == 1 && counts[0] == 1 && counts[1] == 1 && counts[2] == 1 && counts[3] == 1) {
            return true;
        }
        return false;
    }

    public static boolean hasFullHouse(int[] hand) {
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : getFaceCounts(hand)) {
            if (count == 3) hasThree = true;
            if (count == 2) hasTwo = true;
        }
        return hasThree && hasTwo;
    }
}