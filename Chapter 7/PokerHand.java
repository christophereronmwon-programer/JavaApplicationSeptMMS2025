

import java.util.*;


class PokerHand {
    enum Face { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
    enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

    static class Card {
        private final Face face;
        private final Suit suit;
        public Card(Face face, Suit suit) { this.face = face; this.suit = suit; }
        public Face getFace() { return face; }
        public Suit getSuit() { return suit; }
        public String toString() { return face + " of " + suit; }
    }

    static class DeckOfCards {
        private List<Card> deck = new ArrayList<>();
        private int currentCard = 0;
        private Random random = new Random();

        public DeckOfCards() {
            for (Suit suit : Suit.values()) {
                for (Face face : Face.values()) {
                    deck.add(new Card(face, suit));
                }
            }
        }

        public void shuffle() {
            for (int i = deck.size() - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                Collections.swap(deck, i, j);
            }
            currentCard = 0;
        }

        public List<Card> dealHand(int n) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < n; i++) hand.add(deck.get(currentCard++));
            return hand;
        }

        // Evaluation helpers
        private static Map<Face,Integer> countFaces(List<Card> hand) {
            Map<Face,Integer> counts = new HashMap<>();
            for (Card c : hand) counts.put(c.getFace(), counts.getOrDefault(c.getFace(),0)+1);
            return counts;
        }

        public static boolean hasPair(List<Card> hand) {
            return countFaces(hand).containsValue(2);
        }
        public static boolean hasTwoPairs(List<Card> hand) {
            int pairs=0; for (int v: countFaces(hand).values()) if (v==2) pairs++;
            return pairs==2;
        }
        public static boolean hasThreeOfKind(List<Card> hand) {
            return countFaces(hand).containsValue(3);
        }
        public static boolean hasFourOfKind(List<Card> hand) {
            return countFaces(hand).containsValue(4);
        }
        public static boolean hasFlush(List<Card> hand) {
            Suit s=hand.get(0).getSuit();
            for (Card c:hand) if(c.getSuit()!=s) return false;
            return true;
        }
        public static boolean hasStraight(List<Card> hand) {
            List<Integer> vals=new ArrayList<>();
            for(Card c:hand) vals.add(c.getFace().ordinal());
            Collections.sort(vals);
            for(int i=1;i<vals.size();i++) if(vals.get(i)!=vals.get(i-1)+1) return false;
            return true;
        }
        public static boolean hasFullHouse(List<Card> hand) {
            Map<Face,Integer> counts=countFaces(hand);
            return counts.containsValue(3)&&counts.containsValue(2);
        }
    }

    public static void main(String[] args) {
        DeckOfCards deck=new DeckOfCards();
        deck.shuffle();
        List<Card> hand=deck.dealHand(5);
        System.out.println("Hand: "+hand);
        System.out.println("Pair? "+DeckOfCards.hasPair(hand));
        System.out.println("Flush? "+DeckOfCards.hasFlush(hand));
    }
}

// 