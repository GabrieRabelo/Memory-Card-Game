
/**
 * Write a description of class Highscore here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Highscore{
    /**
     * This method check if the player is the winner at the end of the game.
     */
    public static void checkWinner(int score) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int winnerScore = read();
        if(score < winnerScore){
            System.out.print("Parabéns, você é o novo recordista. Insira seu nome: ");
            String name = in.nextLine();
            write(name,score);
            System.out.println("Parabéns, " + name + "!");
        }
    }
    
    /**
     * This method red the file to compare with the current winner.
     */
    public static int read() throws FileNotFoundException {
       int value = 0;
       try{
           File origem = new File("highscore.txt");
           Scanner file = new Scanner(origem);
       
       String name="";
       if(file.hasNextLine()){
           name = file.nextLine();
           if(file.hasNextLine()){
               String score = file.nextLine();
               value = Integer.parseInt(score);
           }
       }
       if(value!=0) System.out.println("Vencedor atual: " + name + " Rodada: " + value);
       file.close();     
       }
       catch(FileNotFoundException ex){
            System.out.println("Erro, aquivo não encontrado.");
       }
       return value;
    }
    
    /**
     * This method saves the new winner in the file.
     */
    public static void write(String name, int score) throws FileNotFoundException{
       PrintWriter file = new PrintWriter("highscore.txt");
       file.println(name);
       file.println(score);
       file.close();
    }
    
    /**
     * This method shows the Highest score file. Used in main menu.
     */
    public static void menuHighscore() throws FileNotFoundException {
       Utilities.window();
       Scanner in = new Scanner(System.in);
       int value = 0;
       try{
           File origem = new File("highscore.txt");
           Scanner file = new Scanner(origem);
       
       String name="";
       if(file.hasNextLine()){
           name = file.nextLine();
           if(file.hasNextLine()){
               String score = file.nextLine();
               value = Integer.parseInt(score);
           }
       }
       if(value!=0) System.out.println("\nVencedor atual: " + name + " \nVenceu em apenas " + value + " rodadas.");
       file.close();
       }
       catch(FileNotFoundException ex){
            System.out.println("Erro, aquivo não encontrado.");
       }
       System.out.println("\nDigite qualquer coisa para voltar.");
       String exit = in.next();
    }
}
