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
        int cardAmount=6; //amount of columns in the matrix, also the amount of lines.
        deck = new Card[cardAmount][cardAmount];
        pos = 0; //pos used to give the initial value of the card class.
        fill(); //fill the matrix with card objects
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
                if(pos==18){ pos = 0; }
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
        if(a>0||a<6 && b>0 || b<6) deck[a][b].showCard();
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
    
    public boolean verifyValue(int a, int b){
        if(deck[a][b].getValue()==-1 || deck[a][b].getStatus()==true) return false;
        else return true;
    }
    
    private void compareTrue(int a, int b, int c, int d){
        deck[a][b].setValue(-1);
        deck[c][d].setValue(-1);
    }
    
    /**
     * This method hides both cards after denied their equity.
     * @param a First card matrix line index.
     * @param b First card matrix column index.
     * @param c Second card matrix line index.
     * @param d Second card matrix column index.
     */
    public void compareFalse(int a, int b, int c, int d){
        if(deck[a][b].getValue()!=-1) deck[a][b].hideCard();
        if(deck[c][d].getValue()!=-1) deck[c][d].hideCard();
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
        return "\f   1    2    3    4    5    6 \n" + msg;
    }
}
