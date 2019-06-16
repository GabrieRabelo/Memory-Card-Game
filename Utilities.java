
/**
 * Write a description of class Utilities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Utilities{
    
    
    public static void waitTurn(int ms){
        try { Thread.sleep(ms); }
        catch (InterruptedException e) { e.printStackTrace();}
        return;
    }
    
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
