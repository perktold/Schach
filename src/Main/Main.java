package Main;

import java.util.Scanner;

import Figuren.Figur;

//weisse figuren bekommen kleingeschriebene symbole, schwarze bekommen gross geschriebene
//weisse figuren sind unten, schwarze oben
//im ganzen programm wird 0 als erste stelle gesehen

public class Main {
    private static Scanner scannerIn;
    public static void main(String[] args) {
        scannerIn = new Scanner(System.in);

        //Frame frame = new Frame(strToInt(args[0]), strToInt(args[1]));
        Frame frame = new Frame(40, 30);
        Figur[][] figurMatrix = SpielFeldIO.getMatrix("start.txt");
        SpielFeld spielFeld = new SpielFeld(frame,figurMatrix); 

        spielFeld.ausgabe();

        while (!spielFeld.schachMatt()) {
            while (!spielFeld.spielZug(
            		getPos("mit welcher Figur willst du ziehen " + (spielFeld.getWeissAmZug()?"weiss":"schwarz")),
                    getPos("wohin willst du ziehen " + (spielFeld.getWeissAmZug()?"weiss":"schwarz"))
            ));

            spielFeld.ausgabe();
        }
    }

    public static int strToInt(String in){
        return Integer.parseInt(in);
    }
    private static Position getPos(String out){
        while(true) {
            System.out.println(out);
            String strIn = scannerIn.next();
            //check if vaild field
            if(strIn.matches("[a-h][1-8]$")){
                //convert to coordinates
                return new Position((strIn.charAt(0) - 'a'), strIn.charAt(1) - '1');
            }else{
            System.err.println("Feld existiert nicht!");
            }
        }
    }
    
    /*public static String getNextLine(){
        while(true) {
            try {
                return scannerIn.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }*/
}
