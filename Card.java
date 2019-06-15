/**
 * This class is a part of SE Introduction class work.
 *
 * @author Gabriel Rabelo
 * @version 09/jun/2019
 */

public class Card{
    private int value;
    private boolean status;
    
    /**
     * Create a new Card
     */
    public Card(int value){
        this.value = value; //value comes from deck variable pos;
        status = false; //status show or hide the card
    }
    
    /**
     * This method set the card value.
     */
    public void setValue(int value){
        this.value = value;
    }
    
    /**
     * This method return the Card value.
     */
    public int getValue() { return value; }
    public boolean getStatus(){ return status; }
    
    /**
     * This method change the Card status, showing it's value.
     */
    public void hideCard() { status = false; }
    
    /**
     * This method change the Card status, hiding it's value.
     */
    public void showCard() { status = true;  }
    
    /**
     * This method return the value or card status if hidden.
     */
    public String toString(){
        if (status==false) return "|**|";
        String output;
        switch(value){
            case -1: output = "    "; break; //value when the card match with the equal card.
            case 0: output = "|=)|"; break;
            case 1: output = "|=(|"; break;
            case 2: output = "|=]|"; break;
            case 3: output = "|=[|"; break;
            case 4: output = "|=/|"; break;
            case 5: output = "|=X|"; break;
            case 6: output = "|=S|"; break;
            case 7: output = "|=D|"; break;
            case 8: output = "|=O|"; break;
            case 9: output = "|=C|"; break;
            case 10: output = "|=I|"; break;
            case 11: output = "|=B|"; break;
            case 12: output = "|=P|"; break;
            case 13: output = "|XD|"; break;
            case 14: output = "|XP|"; break;
            case 15: output = "|=T|"; break;
            case 16: output = "|=*|"; break;
            case 17: output = "|:>|"; break;
            case 18: output = "|:<|"; break;
            default: output = "|er|";
    }
        return output;
    }
}
