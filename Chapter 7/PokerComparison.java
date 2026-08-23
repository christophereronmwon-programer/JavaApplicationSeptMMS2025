
class PokerComparison {
    public static void main(String[] args) {
        PokerHand.DeckOfCards deck=new PokerHand.DeckOfCards();
        deck.shuffle();
        List<PokerHand.Card> player=deck.dealHand(5);
        List<PokerHand.Card> dealer=deck.dealHand(5);
        System.out.println("Player: "+player);
        System.out.println("Dealer: "+dealer);
        System.out.println("Player has flush? "+PokerHand.DeckOfCards.hasFlush(player));
        System.out.println("Dealer has straight? "+PokerHand.DeckOfCards.hasStraight(dealer));
    }
}

