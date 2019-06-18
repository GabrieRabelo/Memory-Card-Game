 /**
 * This class is the main class of the Game.
 *
 * @author Gabriel Rabelo
 * @version 09/jun/2019
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameApp{
    public static void main (String args[]) throws FileNotFoundException{
        Utilities.startScreen(); // Start screen of the game animation.
        Scanner in = new Scanner(System.in);
        int menuOption=0;
        do{
            Utilities.window(); //Name of the game static
            System.out.println("            - Menu -\n");
            System.out.println("         1 - Novo Jogo");
            System.out.println("         2 - Carregar Jogo");
            System.out.println("         3 - Recorde atual");
            System.out.println("         0 - Sair");
            menuOption = in.nextInt();
            
            switch(menuOption){
                case 1: startGame(); break; 
                case 3: Highscore.menuHighscore(); break; //best player atm
                case 0: break;
                default: System.out.println("Opção inválida");
            }
        }while(menuOption!=0);
    }
    
    public static void startGame() throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        Deck deck1 = new Deck(); //instances a new deck(cards matrix)
        boolean bScore=false; //if true increases the score in the end of the round if cards match
        int score=0; //game score, max 17 to win
        int round=1;
        for(int i=round;i<=500;i++){
            System.out.println(deck1); //deck to string (\f in the start to clear the prompt
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            int c1, l1, c2, l2; //column and lines variables, first and second card
            boolean verify = true; //verify if the values can be played, otherwise need to play again
            
            //First card
            do{
                do{
                    System.out.println("\nDigite o número da coluna. (1 a 6)");
                    System.out.println("9 - Pausa"); //only pauses in the first try to not compromise the looping
                    c1 = in.nextInt(); //column1
                    if (c1 == 9) {
                        boolean exit = pause(); //boolean to return if true
                        if (exit == true) return;
                    }
                        
                }while(c1<1 || c1>6);
                 do{
                    System.out.println("\nDigite o número da linha. (1 a 6)");
                    l1 = in.nextInt(); //line1
                }while(l1<1 || l1>6);
                verify = deck1.verifyValue(c1-1,l1-1); //must be -1 to decrease the index in  the matrix
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*\n\n");
                }
            }while(verify==false);
            
            deck1.showCard(c1-1,l1-1); //turn the card
            System.out.println(deck1);
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            //Second card
            do{
                do{
                    System.out.println("\nDigite o número da coluna. (1 a 6)");
                    c2 = in.nextInt(); //card2column
                }while(c2<1 || c2>6);
                do{
                    System.out.println("\nDigite o número da linha. (1 a 6)");
                    l2 = in.nextInt(); //card2line
                }while(l2<1 || l2>6);
                verify = deck1.verifyValue(c2-1,l2-1);
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*\n\n");
                }
            }while(verify==false);
            
            deck1.showCard(c2-1,l2-1);
            System.out.println(deck1);
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            Utilities.waitTurn(1500); // after show the cards give a time to see them and turn back
            bScore = deck1.compareCards(c1-1, l1-1, c2-1, l2-1); //boolean return of compare cards
            if (bScore == true) { score += 1; }
            bScore = false;
            
            
            if(score == 17){
                System.out.println("Parabéns, você ganhou com " + i + " rodadas.");
                Highscore.checkWinner(i);
                System.out.println("\nDigite qualquer coisa para sair");
                String exit = in.next();
                return;
            }
            
            
        }
        
    }
    
    public static boolean pause(){
        Scanner in = new Scanner(System.in);
        int option = 0, option1 = 0;
        do{
            System.out.println("\n2 - Sair\n3 - Voltar");
            option = in.nextInt();
            //if(option == 1) ;//metodo salvar
            if(option == 2) {
                do{
                    System.out.println("Deseja realmente sair?\n1 - Sim\n2 - Voltar");
                    option1 = in.nextInt();
                    if (option1 == 1) return true;
                }while(option1<1 || option>2);
            }
        }while(option<1 || option>3);
        return false;
    }
}
