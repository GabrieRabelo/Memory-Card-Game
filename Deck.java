/**
 * This class is a deck matrix of cards, main matrix of the game.
 *
 * @author Gabriel Rabelo
 * @version v1
 */
import java.util.Random;
public class Deck{
    private Card[][] deck;
    
    /**
     * This method instances a new deck of cards with a standard cardAmount.
     */
    public Deck(){
        int cardAmount=6; //amount of columns in the matrix, also the amount of lines.
        deck = new Card[cardAmount][cardAmount];
        fill();
        shuffle();
    }
    
    /**
     * This method fill all cards in the deck array, 
     */
    public void fill(){
        int pos=0;
        for(int j =0;j<deck.length;j++){
            for(int i=0;i<deck.length;i++){
                deck[i][j] = new Card(pos);
                pos++;//increase 1 in pos to initialize the next card with different value.
                if(pos==18){ pos = 0; } //resets the pos when it's get at 18, to match the pair card and fill the matrix
            }
        }
    }
    
    /**
     * This method shuffle the matrix to get a new randomized matrix.
     */
    public void shuffle(){
        for(int i=0;i<deck.length;i++){
            for(int j=0;j<deck[i].length;j++){
                int i1 = (int) (Math.random()*deck.length);
                int j1 = (int) (Math.random()*deck[i].length);
                Card temp = deck[i][j];
                deck[i][j] = deck[i1][j1];
                deck[i1][j1] = temp;
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
     * This method compares 2 cards value and set its value to -1 if equals.
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
    
    /**
     * This method verify if the value is -1 and change its status to print blank position.
     * @param a card matrix column index
     * @param b card matrix line index
     */
    public boolean verifyValue(int a, int b){
        if(deck[a][b].getValue()==-1 || deck[a][b].getStatus()==true) return false;
        else return true;
    }
    
    /**
     * This method set the value of both cards to -1 hiding its printing.
     * @param a First card matrix column index.
     * @param b First card matrix line index.
     * @param c Second card matrix column index.
     * @param d Second card matrix line index.
     */
    
    public void compareTrue(int a, int b, int c, int d){
        deck[a][b].setValue(-1);
        deck[c][d].setValue(-1);
    }
    
    /**
     * This method hides both cards after denied their equity.
     * @param a First card matrix column index.
     * @param b First card matrix line index.
     * @param c Second card matrix column index.
     * @param d Second card matrix line index.
     */
    public void compareFalse(int a, int b, int c, int d){
        if(deck[a][b].getValue()!=-1) deck[a][b].hideCard();
        if(deck[c][d].getValue()!=-1) deck[c][d].hideCard();
    }
    
    /**
     * This method is used to test all cards value in the matrix;
     */
    private void showAll(){
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
