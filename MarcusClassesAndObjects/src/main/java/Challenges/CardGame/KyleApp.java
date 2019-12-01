package Challenges.CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KyleApp {
    public static void main(String[] args) {
        //52 cards
        //4 suits (0==hearts, 1==diamonds, 2==clubs, 3==spades)
        // 13 ranks(A, 2-10, J, Q, K)
        
        List<KyleCard> deck = new ArrayList<>();
        
        for (int suit = 0; suit < 13; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                KyleCard card = new KyleCard(rank, suit);
                deck.add(card);
            }
        }
        
        Collections.shuffle(deck);
        
        List<KyleCard> hand1 = new ArrayList<>();
        
        hand1.add(deck.remove(0));
        hand1.add(deck.remove(0));
        hand1.add(deck.remove(0));
        hand1.add(deck.remove(0));
        hand1.add(deck.remove(0));
        
        for (KyleCard c : hand1) {
//            System.out.println(c.getRank() + "::" + c.getSuit());
            String rank = "";
            String suit = "";
            switch(c.getSuit()){
                case 0:
                    suit = "Hearts";
                    break;
                case 1:
                    suit = "Diamonds";
                    break;
                case 2:
                    suit = "Clubs";
                    break;
                case 3:
                    suit = "Spades";
                    break;
            }
            switch(c.getRank()){
                case 1:
                    rank = "Ace";
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    rank = Integer.toString(c.getRank());
                    break;
                case 11:
                    rank = "Jack";
                    break;
                case 12:
                    rank = "Queen";
                    break;
                case 13:
                    rank = "King";
                    break;
            }
            System.out.println(rank + " of " + suit);
        }
    }
}
