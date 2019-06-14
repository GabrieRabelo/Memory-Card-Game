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
        startScreen();
        Scanner in = new Scanner(System.in);
        int menuOption=0;
        boolean load = false;
        do{
            System.out.println("\f|**||**| Jogo da Memória  |**||**|");
            System.out.println("|**||**| |**||**||**||**| |**||**|");
            System.out.println("\n        - Menu -\n");
            System.out.println("1 - Novo Jogo");
            System.out.println("2 - Carregar");
            System.out.println("3 - Como jogar");
            System.out.println("0 - Sair");
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
    
    public static void startGame(boolean load){
        Scanner in = new Scanner(System.in);
        Deck deck1 = new Deck();
        boolean bScore=false;
        int score=0, scoreBot=0;
        if(load == false){ ; }
        else if(load == true){
            //ler arquivos de carregamento
        }
        
        for(int i=1;i<30;i++){
            
            System.out.println(deck1);
            System.out.println("Pontuação: " + score + " | Rodada :" + i + "/30");
            
            int c1, l1, c2, l2;
            
            do{
                System.out.println("\n Digite o número da coluna.");
                c1 = in.nextInt();
            }while(c1<1 || c1>4);
             do{
                System.out.println("\n Digite o número da linha.");
                l1 = in.nextInt();
            }while(l1<1 || l1>4);
            
            deck1.showCard(c1-1,l1-1);
            System.out.println(deck1);
            System.out.println("Pontuação: " + score + " | Rodada :" + i + "/30");
            
            do{
                System.out.println("\n Digite o número da coluna.");
                c2 = in.nextInt();
            }while(c2<1 || c2>4);
            do{
                System.out.println("\n Digite o número da linha.");
                l2 = in.nextInt();
            }while(l2<1 || l2>4);
            
            deck1.showCard(c2-1,l2-1);
            System.out.println(deck1);
            System.out.println("Pontuação: " + score + " | Rodada: " + i + "/30");
            
            waitTurn();
            bScore = deck1.compareCards(c1-1, l1-1, c2-1, l2-1);
            if (bScore == true) { score += 100; }
            bScore = false;
        }
        
    }
    
    public static void startScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("\f|**||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |**||**|");
        System.out.println("\n\nDigite qualquer coisa para iniciar.");
        String start = in.nextLine(); 
        waitTurn();
        System.out.println("\f|XD||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |XD||**|");
        waitTurn();
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |**||**||**||**| |XD||**|");
        waitTurn();
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn();
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn();
        System.out.println("\f|**||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |**||**|");
        waitTurn();
        return;
    }
    
    public static void waitTurn(){
        try { Thread.sleep(800); }
        catch (InterruptedException e) { e.printStackTrace();}
        return;
    }
}
