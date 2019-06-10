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

public class Game{
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int menuOption=0;
        do{
            System.out.println("\f== Memory Card Game ==");
            System.out.println("\n-Menu-");
            System.out.println("1 - Novo Jogo");
            System.out.println("2 - Carregar Jogo");
            System.out.println("3 - Regras");
            System.out.println("0 - Sair");
            menuOption = in.nextInt();
            
            switch(menuOption){
                case 1: 
                case 2:
                case 3:
                case 0: break;
            }
        }while(menuOption!=0);
    }
}
