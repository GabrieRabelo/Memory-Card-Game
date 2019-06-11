/**
 * This class is a part of SE Introduction class work.
 *
 * @author Gabriel Rabelo
 * @version 9/jul/2019
 */

public class Deck{
    private Card[] deck;
    private int pos;
    
    /**
     * This method instances a new deck of cards with a standard cardAmount.
     */
    public Deck(){
        int cardAmount=10;
        deck = new Card[cardAmount];
        pos = 0;
    }
    
    /**
     * This method fill all cards in the deck array, 
     */
    public void fill(){
        for(int i=0;i<deck.length;i++){
            deck[i] = new Card(i);
        }
    }
    
    private void showAll(){
        for(int i=0;i<deck.length;i++){
            deck[i].showCard();
        }
    }
        
    public String toString(){
        String msg = "";
        for(int i=0; i<this.deck.length; i++){
            msg += deck[i] + "  ";
        }
        return msg;
    }
}
