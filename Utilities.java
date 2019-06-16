
/**
 * Write a description of class Utilities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Utilities{
    /**
     * Menu game name, created a method because it repeats in some menu screen.
     */
    public static void window(){
       System.out.println("\f|**||**| Jogo da Memória  |**||**|");
       System.out.println("|**||**| |**||**||**||**| |**||**|\n\n");
       return;
    }
    
    /**
     * POO method to force the app to wait, important to see the cards turning.
     * @param ms Time to wait in miliseconds.
     */
    public static void waitTurn(int ms){
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { e.printStackTrace();}
        return;
    }
    
    /**
     * This method is the animation of the start Screen.
     */
    public static void startScreen(){
        Scanner in = new Scanner(System.in);
        System.out.println("\f|**||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |**||**|");
        System.out.println("\n\nDigite qualquer coisa para iniciar.");
        String start = in.nextLine(); 
        waitTurn(800);
        System.out.println("\f|XD||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |XD||**|");
        waitTurn(800);
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |**||**||**||**| |XD||**|");
        waitTurn(800);
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn(800);
        System.out.println("\f|XD||**| Jogo da Memória  |=]||**|");
        System.out.println("|=]||**| |=D||**||**||**| |XD||=D|");
        waitTurn(800);
        System.out.println("\f|**||**| Jogo da Memória  |**||**|");
        System.out.println("|**||**| |**||**||**||**| |**||**|");
        waitTurn(800);
        return;
    }
}
