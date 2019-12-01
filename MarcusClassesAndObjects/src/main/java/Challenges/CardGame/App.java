package Challenges.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    private List<Card> deck;
    
    private String[] suits = {"Hearts, Spades, Diamonds, Clubs"};
    
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "Joker", "Queen", "King"};

    public App(Card[] Deck) {
        this.deck = new ArrayList<Card>();
    }
    
    
    
    public void run() {
        fillDeck();
        shuffleDeck();
        
        int totalHands = 4;
        int handSize = 5;
        
        Card[][] allHands = new Card[4][5];
        
        for (int i = 0; i < totalHands; i++) {
            allHands[i] = (Card[])dealHand(handSize).toArray();
        }
    }
    
    public void fillDeck() {
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }
    
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    public List<Card> dealHand(int handSize){
        return deck;
    }
}
