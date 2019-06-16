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
    public static void main (String args[]){
        Utilities.startScreen();
        Scanner in = new Scanner(System.in);
        int menuOption=0;
        boolean load = false;
        do{
            System.out.println("\f|**||**| Jogo da Memória  |**||**|");
            System.out.println("|**||**| |**||**||**||**| |**||**|");
            System.out.println("\n            - Menu -\n");
            System.out.println("        1 - Novo Jogo");
            System.out.println("        2 - Carregar");
            System.out.println("        3 - Como jogar");
            System.out.println("        0 - Sair");
            menuOption = in.nextInt();
            
            switch(menuOption){
                case 1: startGame(load);
                case 2: { load = true;
                    startGame(load);
                }
                case 3:
                case 0: break;
            }
        }while(menuOption!=0);
    }
    
    private static void startGame(boolean load){
        Scanner in = new Scanner(System.in);
        Deck deck1 = new Deck();
        boolean bScore=false, save=false;
        int score=0;
        int round=1;
        if(load == false){ ; }
        else if(load == true){
            //ler arquivos de carregamento
        }
        
        for(int i=round;i<=100;i++){
            
            System.out.println(deck1);
            System.out.println("Jogada nº: " + i);
            
            int c1, l1, c2, l2;
            boolean verify = true;
            
            //First card
            do{
                do{
                    System.out.println("\nDigite o número da coluna.");
                    c1 = in.nextInt();
                }while(c1<1 || c1>6);
                 do{
                    System.out.println("\nDigite o número da linha.");
                    l1 = in.nextInt();
                }while(l1<1 || l1>6);
                verify = deck1.verifyValue(c1-1,l1-1);
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*");
                    Utilities.waitTurn(2000); 
                }
            }while(verify==false);
            
            deck1.showCard(c1-1,l1-1);
            System.out.println(deck1);
            System.out.println("Jogada nº: " + i);
            
            //Second card
            do{
                do{
                    System.out.println("\nDigite o número da coluna.");
                    c2 = in.nextInt();
                }while(c2<1 || c2>6);
                do{
                    System.out.println("\nDigite o número da linha.");
                    l2 = in.nextInt();
                }while(l2<1 || l2>6);
                verify = deck1.verifyValue(c2-1,l2-1);
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*");
                    Utilities.waitTurn(2000); 
                }
            }while(verify==false);
            
            deck1.showCard(c2-1,l2-1);
            System.out.println(deck1);
            System.out.println("Jogada nº: " + i);
            
            Utilities.waitTurn(1500);
            bScore = deck1.compareCards(c1-1, l1-1, c2-1, l2-1); //boolean return of compare cards
            if (bScore == true) { score += 1; }
            bScore = false;
            
            
            if(score == 18){
                System.out.println("Parabéns, você ganhou com " + i + "jogadas.");
                break;
            }
            
        }
        
    }
}
