
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
    public static boolean save(int score, int round)throws FileNotFoundException {
        PrintWriter dataSave = new PrintWriter("save.txt");
        dataSave.println(score);
        dataSave.println(round);
        
        
        dataSave.close();
        System.out.println("Jogo salvo com sucesso");
        return true;
    }
   
    /*public static String load(Deck deck1, int round, int score)throws FileNotFoundException {
        File origenLoadChessman = new File(file);
        Scanner dataLoadChessman = new Scanner(origenLoadChessman);
        boolean arrL = true;
        Piece chessman;
        String lineGet = "";
        String fxLine = "";
        String type = "";
        char alive = 0;
        int team = 0;
        int posX = 0;
        int posY = 0;

        if(dataLoadChessman.hasNextLine())
            fxLine = dataLoadChessman.nextLine();
            else return "LOAD FAIL.";
        if(dataLoadChessman.hasNextLine())
            lineGet = dataLoadChessman.nextLine();
            else return "LOAD FAIL.";
        if(lineGet.equals("true")) fxLine += "T";
            else fxLine += "F";

        for(int i = 0; i < 17; i++){
            if(dataLoadChessman.hasNextLine()){
                lineGet = dataLoadChessman.nextLine();
                posX = Character.getNumericValue(lineGet.charAt(0));
                posY = Character.getNumericValue(lineGet.charAt(3));
                team = Character.getNumericValue(lineGet.charAt(6));
                alive = lineGet.charAt(9);
                type = lineGet.substring(12);
            
                if(arrL){
                    chessman1.add(new Piece(posX, posY, team, type));
                    if(alive != '1')chessman1.get(i).setDefeat(true);
                }else{
                chessman2.add(new Piece(posX, posY, team, type));
                if(alive != '1')chessman2.get(i).setDefeat(true);
                }
                if(i == 16){
                if(arrL != false){i = -1; arrL = false;}
                    else i++;
                }
            }else return "LOAD FAIL.";
        }
        dataLoadChessman.close();
        return fxLine;
    }*/
}