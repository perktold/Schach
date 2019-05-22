package Main;

import java.util.Scanner;

//weiße figuren bekommen kleingeschriebene symbole, schwarze bekommen groß geschriebene
//weiße figuren sind unten, schwarze oben
//im ganzen programm wird 0 als erste stelle gesehen

public class Main {
    private static Scanner scannerIn;
    public static void main(String[] args) {
        boolean weißAmZug = true;
        scannerIn = new Scanner(System.in);

        //Frame frame = new Frame(strToInt(args[0]), strToInt(args[1]));
        Frame frame = new Frame(40, 20);
        SpielFeld spielFeld = new SpielFeld(frame);

        spielFeld.ausgabe();

        while (!spielFeld.schachmatt()) {
            while (!spielFeld.spielZug(
                    weißAmZug,
                    getIn("mit welcher Figur willst du ziehen " + weißAmZug),
                    getIn("wohin willst du ziehen " + weißAmZug)
            ));

            spielFeld.ausgabe();
            weißAmZug = !weißAmZug; // anderer Spieler ist im nächsten Zug dran
        }
    }

    public static int strToInt(String in){
        return Integer.parseInt(in);
    }
    private static Koordinaten getIn(String out){
        while(true) {
            System.out.println(out);
            try {
                String strIn = scannerIn.next();
                if(strIn.matches("[a-h][1-8]$"))
                {
                    return new Koordinaten((strIn.charAt(0) - 'a'), strIn.charAt(1) - '1');
                }
            }catch (Exception e){
                System.err.println("das hat nicht geklappt, versuchen sie es erneut");
            }
        }
    }
    public static String getNextLine(){
        while(true) {
            try {
                return scannerIn.nextLine();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
