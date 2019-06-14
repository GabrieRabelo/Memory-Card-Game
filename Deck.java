/**
 * This class is a part of SE Introduction class work.
 *
 * @author Gabriel Rabelo
 * @version 9/jul/2019
 */
import java.util.Random;
public class Deck{
    private Card[][] deck;
    private int pos;
    
    /**
     * This method instances a new deck of cards with a standard cardAmount.
     */
    public Deck(){
        int cardAmount=4;
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
                if(pos==8){ pos = 0; }
            }
        }
    }
    
    /**
     * This method shuffle the matrix to get a new randomized matrix.
     */
    public void shuffle(){
        Random rn = new Random();
        for(int j=0;j<deck.length;j++){   
            for(int i=0;i<deck.length;i++){
                int r = rn.nextInt(4);
                
            }
        }
    }
    
    /**
     * This method show the card to check the value toString and show to the user.
     */    
    public void showCard(int a, int b){
        if(a>0||a<4 && b>0 || b<4) deck[a][b].showCard();
        return;
    }
    
    /**
     * This method compares 2 cards value and set it's value to -1 if equals.
     */
    public boolean compareCards(int a, int b, int c, int d){
        if(deck[a][b].getValue()==deck[c][d].getValue()){
            compareTrue(a,b,c,d);
            return true;
        }
        else {
            compareFalse(a,b,c,d);
            return false;
        }
    }
    
    public void compareTrue(int a, int b, int c, int d){
        deck[a][b].setValue(-1);
        deck[c][d].setValue(-1);
    }
    
    public void compareFalse(int a, int b, int c, int d){
        deck[a][b].hideCard();
        deck[c][d].hideCard();
    }
    
    /**
     * This method is used to test all cards value in the matrix;
     */
    public void showAll(){
        for(int j=0;j<deck.length;j++){
            for(int i=0;i<deck.length;i++){
                deck[i][j].showCard();
            }
        }
    }
    
    /**
     * Print the whole deck positions.
     */
    public String toString(){
        String msg = "";
        for(int j=0;j<deck.length;j++){
            msg += j+1 + " ";
            for(int i=0; i<deck.length; i++){
                msg += deck[i][j] + " ";
            }
            msg += "\n\n";
        }
        return "\f   1    2    3    4 \n" + msg;
    }
}
