// ===============================
// Chapter 7 Code Solutions
// ===============================

import java.util.*;

enum Face { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
enum Suit { HEARTS, DIAMONDS, CLUBS, SPADES }

class Card {
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() { return face; }
    public Suit getSuit() { return suit; }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}

class DeckOfCards {
    private List<Card> deck;
    private int currentCard;
    private Random random;

    public DeckOfCards() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Face face : Face.values()) {
                deck.add(new Card(face, suit));
            }
        }
        currentCard = 0;
        random = new Random();
    }

    // Fisher-Yates shuffle
    public void shuffle() {
        for (int i = deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Collections.swap(deck, i, j);
        }
        currentCard = 0;
    }

    public Card dealCard() {
        if (currentCard < deck.size()) return deck.get(currentCard++);
        return null;
    }

    public List<Card> dealHand(int n) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < n; i++) hand.add(dealCard());
        return hand;
    }

    // Poker hand evaluation methods
    public static boolean hasPair(List<Card> hand) {
        Map<Face, Integer> counts = countFaces(hand);
        return counts.containsValue(2);
    }

    public static boolean hasTwoPairs(List<Card> hand) {
        Map<Face, Integer> counts = countFaces(hand);
        int pairs = 0;
        for (int val : counts.values()) if (val == 2) pairs++;
        return pairs == 2;
    }

    public static boolean hasThreeOfKind(List<Card> hand) {
        return countFaces(hand).containsValue(3);
    }

    public static boolean hasFourOfKind(List<Card> hand) {
        return countFaces(hand).containsValue(4);
    }

    public static boolean hasFlush(List<Card> hand) {
        Suit suit = hand.get(0).getSuit();
        for (Card c : hand) if (c.getSuit() != suit) return false;
        return true;
    }

    public static boolean hasStraight(List<Card> hand) {
        List<Integer> values = new ArrayList<>();
        for (Card c : hand) values.add(c.getFace().ordinal());
        Collections.sort(values);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) != values.get(i-1) + 1) return false;
        }
        return true;
    }

    public static boolean hasFullHouse(List<Card> hand) {
        Map<Face, Integer> counts = countFaces(hand);
        return counts.containsValue(3) && counts.containsValue(2);
    }

    private static Map<Face, Integer> countFaces(List<Card> hand) {
        Map<Face, Integer> counts = new HashMap<>();
        for (Card c : hand) counts.put(c.getFace(), counts.getOrDefault(c.getFace(), 0) + 1);
        return counts;
    }
}

// HeartRates class for Exercise 7.22
class HeartRates {
    private String firstName;
    private String lastName;
    private int birthMonth, birthDay, birthYear;

    public HeartRates(String firstName, String lastName, int month, int day, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthMonth = month;
        this.birthDay = day;
        this.birthYear = year;
    }

    public int getAge() {
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthYear;
        if (today.get(Calendar.MONTH) + 1 < birthMonth ||
            (today.get(Calendar.MONTH) + 1 == birthMonth && today.get(Calendar.DAY_OF_MONTH) < birthDay)) {
            age--;
        }
        return age;
    }

    public int getMaxHeartRate() {
        return 220 - getAge();
    }

    public String getTargetHeartRate() {
        int max = getMaxHeartRate();
        int lower = (int)(max * 0.50);
        int upper = (int)(max * 0.85);
        return lower + " - " + upper;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " DOB: " + birthDay + "/" + birthMonth + "/" + birthYear;
    }
}

public class Chapter7_Code {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        List<Card> playerHand = deck.dealHand(5);
        List<Card> dealerHand = deck.dealHand(5);

        System.out.println("Player Hand: " + playerHand);
        System.out.println("Dealer Hand: " + dealerHand);

        System.out.println("Player has flush? " + DeckOfCards.hasFlush(playerHand));
        System.out.println("Dealer has straight? " + DeckOfCards.hasStraight(dealerHand));

        // HeartRates demo
        HeartRates hr = new HeartRates("John", "Doe", 5, 15, 1990);
        System.out.println(hr);
        System.out.println("Age: " + hr.getAge());
        System.out.println("Max HR: " + hr.getMaxHeartRate());
        System.out.println("Target HR: " + hr.getTargetHeartRate());
    }
}