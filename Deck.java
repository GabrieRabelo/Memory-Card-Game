/**
 * This class is a part of SE Introduction class work.
 *
 * @author Gabriel Rabelo
 * @version 9/jul/2019
 */

public class Deck{
    private Card []deck;
    private int pos;
    
    public Deck(int difficulty){
        int cardAmount=5;
        //if(difficulty==1) cardAmount = 5;
        //else if(difficulty==2) cardAmount = 8;
        //else if(difficulty==3) cardAmount = 15;
        deck = new Card[cardAmount-1];
        pos = 0;
    }
    
    public void fill(){
        for(int i=0;i<deck.length;i++){
            deck[i] = new Card(i);
        }
    }
    
    public String toString(){
        String msg = "";
        for(int i=0; i<this.deck.length; i++){
            msg += deck[i] + " - ";
        }
        return msg;
    }
}
