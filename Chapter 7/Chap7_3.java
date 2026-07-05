import java.util.Random;

public class Chap7_3 {
    public enum Face { DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) deck[i] = i;
        shuffleDeck(deck);

        int[] dealerHand = new int[5];
        int deckIndex = 0;
        for (int i = 0; i < 5; i++) dealerHand[i] = deck[deckIndex++];

        System.out.println("Dealer's Original Hand (Face Down to Player):");
        displayHand(dealerHand);

        deckIndex = executeDealerTurn(dealerHand, deck, deckIndex);

        System.out.println("\nDealer's Hand after drawing:");
        displayHand(dealerHand);
    }

    public static int executeDealerTurn(int[] hand, int[] deck, int deckIndex) {
        int score = evaluateHandRank(hand);

        // If dealer already holds a Straight, Flush, Full House, or Quad: Stand pat.
        if (score >= 4) {
            System.out.println("Dealer stays with a strong hand.");
            return deckIndex;
        }

        int[] counts = new int[13];
        for (int card : hand) counts[card % 13]++;

        // Strategy execution
        if (score == 3) { // Three of a kind: discard the other 2 single cards
            System.out.println("Dealer discards 2 cards.");
            for (int i = 0; i < hand.length; i++) {
                if (counts[hand[i] % 13] == 1) hand[i] = deck[deckIndex++];
            }
        } else if (score == 2) { // Two pair: discard the 5th card
            System.out.println("Dealer discards 1 card.");
            for (int i = 0; i < hand.length; i++) {
                if (counts[hand[i] % 13] == 1) hand[i] = deck[deckIndex++];
            }
        } else if (score == 1) { // One pair: discard the other 3 single cards
            System.out.println("Dealer discards 3 cards.");
            for (int i = 0; i < hand.length; i++) {
                if (counts[hand[i] % 13] == 1) hand[i] = deck[deckIndex++];
            }
        } else { // High card: discard the lowest 3 cards
            System.out.println("Dealer discards 3 lowest cards.");
            // Selection sorting indices by face ordinal value
            for (int i = 0; i < hand.length - 1; i++) {
                for (int j = i + 1; j < hand.length; j++) {
                    if ((hand[i] % 13) > (hand[j] % 13)) {
                        int temp = hand[i];
                        hand[i] = hand[j];
                        hand[j] = temp;
                    }
                }
            }
            // Replace the three lowest cards (indices 0, 1, 2)
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
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
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
        for (int card : hand) System.out.printf("  %s of %s\n", Face.values()[card % 13], Suit.values()[card / 13]);
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