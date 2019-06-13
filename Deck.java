/**
 * This class is a part of SE Introduction class work.
 *
 * @author Gabriel Rabelo
 * @version 9/jul/2019
 */

public class Deck{
    private Card[][] deck;
    private int pos;
    
    /**
     * This method instances a new deck of cards with a standard cardAmount.
     */
    public Deck(){
        int cardAmount=5;
        deck = new Card[cardAmount][cardAmount];
        pos = 0;
        fill();
    }
    
    /**
     * This method fill all cards in the deck array, 
     */
    public void fill(){
        int pos=0;
        for(int j =0;j<deck.length;j++){
            for(int i=0;i<deck.length;i++){
                deck[i][j] = new Card(pos);
                pos++;
                if(pos>14){ pos = 0; }
            }
        }
    }
    
    public void showCard(int a, int b){
        if(a>0||a<4 && b>0 || b<4) deck[a][b].showCard();
        return;
    }
    
    public void showAll(){
        for(int j=0;j<deck.length;j++){
            for(int i=0;i<deck.length;i++){
                deck[i][j].showCard();
            }
        }
    }
        
    public String toString(){
        String msg = "";
        for(int j=0;j<deck.length;j++){
            msg += j+1 + " ";
            for(int i=0; i<deck.length; i++){
                msg += deck[i][j] + " ";
            }
            msg += "\n\n";
        }
        return "\f   1    2    3    4    5 \n" + msg;
    }
}
