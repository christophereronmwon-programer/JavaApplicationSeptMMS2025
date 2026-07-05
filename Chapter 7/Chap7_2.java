import java.util.Random;

public class Chap7_2 {
    public enum Face { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) deck[i] = i;
        shuffleDeck(deck);

        int[] hand1 = new int[5];
        int[] hand2 = new int[5];

        // Deal alternating cards to simulate a real deal
        int deckIndex = 0;
        for (int i = 0; i < 5; i++) {
            hand1[i] = deck[deckIndex++];
            hand2[i] = deck[deckIndex++];
        }

        System.out.println("--- Hand 1 ---");
        displayHand(hand1);
        int score1 = evaluateHandRank(hand1);
        System.out.println("Rank Score: " + score1);

        System.out.println("\n--- Hand 2 ---");
        displayHand(hand2);
        int score2 = evaluateHandRank(hand2);
        System.out.println("Rank Score: " + score2);

        System.out.println("\nResult:");
        if (score1 > score2) {
            System.out.println("Hand 1 wins!");
        } else if (score2 > score1) {
            System.out.println("Hand 2 wins!");
        } else {
            System.out.println("It's a tie base score!");
        }
    }

    public static void shuffleDeck(int[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Converts hand strengths to a clear numerical tier matrix
    public static int evaluateHandRank(int[] hand) {
        if (hasFlush(hand) && hasStraight(hand)) return 8; // Straight Flush
        if (hasFourOfAKind(hand)) return 7;
        if (hasFullHouse(hand)) return 6;
        if (hasFlush(hand)) return 5;
        if (hasStraight(hand)) return 4;
        if (hasThreeOfAKind(hand)) return 3;
        if (hasTwoPairs(hand)) return 2;
        if (hasPair(hand)) return 1;
        return 0; // High Card
    }

    public static Face getFace(int card) { return Face.values()[card % 13]; }
    public static Suit getSuit(int card) { return Suit.values()[card / 13]; }
    
    public static void displayHand(int[] hand) {
        for (int card : hand) System.out.printf("  %s of %s\n", getFace(card), getSuit(card));
    }

    private static int[] getFaceCounts(int[] hand) {
        int[] counts = new int[13];
        for (int card : hand) counts[getFace(card).ordinal()]++;
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
        Suit s = getSuit(hand[0]);
        for (int i = 1; i < hand.length; i++) if (getSuit(hand[i]) != s) return false;
        return true;
    }

    public static boolean hasStraight(int[] hand) {
        int[] counts = getFaceCounts(hand);
        int start = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) { start = i; break; }
        }
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