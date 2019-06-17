
/**
 * Write a description of class Files here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class LoadNSave{
    private static void verificaVencedor(int pontuacao) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        int pontuacaoVencedor = leitura();
        if(pontuacao > pontuacaoVencedor){
            System.out.print("Parabéns, você é o novo recordista. Insira seu nome: ");
            String nome = teclado.nextLine();
            gravacao(nome,pontuacao);
            System.out.println("Parabéns, " + nome + "!");
        }
    }
    
    private static int leitura() throws FileNotFoundException {
       int valor = 0;
        try{
           File origem = new File("recorde.txt");
           Scanner arquivo = new Scanner(origem);
       
       String nome="";
       if(arquivo.hasNextLine()){
           nome = arquivo.nextLine();
           if(arquivo.hasNextLine()){
               String pontuacao = arquivo.nextLine();
               valor = Integer.parseInt(pontuacao);
           }
       }
       if(valor!=0) System.out.println("Vencedor atual: " + nome + " Pontuacao: " + valor);
       arquivo.close();     
       }
       catch(FileNotFoundException ex){
            System.out.println("Erro, arquivo não encontrado.");
       }
       return valor;
    }
    
    private static void gravacao(String nome, int pontuacao) throws FileNotFoundException{
       PrintWriter arquivo = new PrintWriter("recorde.txt");
       arquivo.println(nome);
       arquivo.println(pontuacao);
       arquivo.close();
    }
}
