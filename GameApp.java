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
        Utilities.startScreen();
        Scanner in = new Scanner(System.in);
        int menuOption=0;
        boolean load = false;
        do{
            Utilities.window();
            System.out.println("            - Menu -\n");
            System.out.println("         1 - Novo Jogo");
            System.out.println("         2 - Carregar Jogo");
            System.out.println("         3 - Recorde atual");
            System.out.println("         0 - Sair");
            menuOption = in.nextInt();
            
            switch(menuOption){
                case 1: startGame(load); break;
                case 2: load = true; startGame(load); break;
                case 3: Highscore.menuHighscore(); break;
                case 0: break;
                default: System.out.println("Opção inválida");
            }
        }while(menuOption!=0);
    }
    
    public static void startGame(boolean load) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        Deck deck1 = new Deck();
        boolean bScore=false;
        int score=0;
        int round=1;
        if(load == true){
            //ler arquivos de carregamento
        }
        
        for(int i=0;i<=500;i++){
            round = i;
            System.out.println(deck1);
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            int c1, l1, c2, l2;
            boolean verify = true;
            
            //First card
            do{
                do{
                    System.out.println("\nDigite o número da coluna. (1 a 6)");
                    System.out.println("9 - Pausa");
                    c1 = in.nextInt();
                    if (c1 == 9) {
                        boolean exit = pause(score, round);
                        if (exit == true) return;
                    }
                        
                }while(c1<1 || c1>6);
                 do{
                    System.out.println("\nDigite o número da linha. (1 a 6)");
                    l1 = in.nextInt();
                }while(l1<1 || l1>6);
                verify = deck1.verifyValue(c1-1,l1-1);
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*\n\n");
                }
            }while(verify==false);
            
            deck1.showCard(c1-1,l1-1);
            System.out.println(deck1);
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            //Second card
            do{
                do{
                    System.out.println("\nDigite o número da coluna. (1 a 6)");
                    c2 = in.nextInt();
                }while(c2<1 || c2>6);
                do{
                    System.out.println("\nDigite o número da linha. (1 a 6)");
                    l2 = in.nextInt();
                }while(l2<1 || l2>6);
                verify = deck1.verifyValue(c2-1,l2-1);
                if (verify == false) {
                    System.out.println("\n*Carta inválida, tente novamente*\n\n");
                }
            }while(verify==false);
            
            deck1.showCard(c2-1,l2-1);
            System.out.println(deck1);
            System.out.println("Rodada nº " + i + "\nRestam " + (36-(score*2)) +" cartas.");
            
            Utilities.waitTurn(1500);
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
    
    public static boolean pause(int score, int round) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        int option = 0, option1 = 0;
        do{
            System.out.println("\n1 - Salvar\n2 - Sair\n3 - Voltar");
            option = in.nextInt();
            LoadNSave.save(score, round);
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
