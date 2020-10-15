package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Figuren.*;
import Figuren.Laeufer;

public class SpielFeldIO {
	private static char[][] scanSymbolMatrix(String filepath) throws FileNotFoundException {
		Scanner in = new Scanner(new File("start.txt"));
		char[][] symbolMatrix = new char[8][8];
		
		for(int y = 0; in.hasNextLine(); y++) {
			symbolMatrix[y] = in.nextLine().toCharArray();
		}
		in.close();
		return symbolMatrix;
	}
	private static Figur[][] formatSchachMatrix(char[][] symbolMatrix){
		Figur[][] out = new Figur[symbolMatrix.length][symbolMatrix[0].length];
		for(int y = 0; y < symbolMatrix.length; y++) {
			for(int x = 0; x < symbolMatrix[y].length; x++) {
				switch(symbolMatrix[y][x]){
				case 'b':
					out[x][y] = new Bauer(true);
				break;
				case 'B':
					out[x][y] = new Bauer(false);
				break;
				case 't':
					out[x][y] = new Turm(true);
				break;
				case 'T':
					out[x][y] = new Turm(false);
				break;			
				case 's':
					out[x][y] = new Springer(true);
				break;			
				case 'S':
					out[x][y] = new Springer(false);
				break;			
				case 'l':
					out[x][y] = new Laeufer(true);
				break;			
				case 'L':
					out[x][y] = new Laeufer(false);
				break;			
//				case 'k':
//					out[x][y] = new Koenig(true);
//				break;			
//				case 'K':
//					out[x][y] = new Koenig(false);
//				break;			
				case 'd':
					out[x][y] = new Dame(true);
				break;			
				case 'D':
					out[x][y] = new Dame(false);
				break;			
				default:
					out[x][y] = new Figur(symbolMatrix[y][x]);
				}
			}
		}
				
		return out;
	}
	public static Figur[][] getMatrix(String filepath) {
		try {
			return formatSchachMatrix(scanSymbolMatrix(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	}
}
