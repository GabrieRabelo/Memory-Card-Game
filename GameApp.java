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
            System.out.println("\f|**||**| Memory Card Game |**||**|");
            System.out.println("|**||**| |**||**||**||**| |**||**|");
            System.out.println("\n        - Main Menu -\n");
            System.out.println("1 - New Game");
            System.out.println("2 - Load");
            System.out.println("3 - How to play");
            System.out.println("0 - Exit");
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
        //deck1.shuffle();
        //deck1.showAll();
        if(load == false){ ; }
        else if(load == true){
            //ler arquivos de carregamento
        }
        while(true){
            System.out.println(deck1);
            int c, l;
            do{
                System.out.println("\n Type a column number to turn");
                c = in.nextInt();
            }while(c<1 || c>4);
             do{
                System.out.println("\n Type a line number to turn");
                l= in.nextInt();
            }while(l<1 || l>4);
            
            deck1.showCard(c-1,l-1);
            
            
            
        }
        
        
    }
    
    public static void startScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("\f|**||**| Memory Card Game |**||**|");
        System.out.println("|**||**| |**||**||**||**| |**||**|");
        System.out.println("\n\n     Type anything to Start.");
        String start = in.nextLine(); 
        waitTurn();
        System.out.println("\f|XD||**| Memory Card Game |**||**|");
        System.out.println("|**||**| |**||**||**||**| |XD||**|");
        waitTurn();
        System.out.println("\f|XD||**| Memory Card Game |=]||**|");
        System.out.println("|=]||**| |**||**||**||**| |XD||**|");
        waitTurn();
        System.out.println("\f|XD||**| Memory Card Game |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn();
        System.out.println("\f|XD||**| Memory Card Game |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn();
        System.out.println("\f|**||**| Memory Card Game |**||**|");
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
