package Main;

public class Frame {
	private char [] [] canvas;
	Frame(int x, int y){
		canvas = new char[x][y];
		fillWithSpaces();
	}
	public void fillWithSpaces() {
		for(int i = 0; i < this.canvas.length; i++) {
			for(int j = 0; j < this.canvas[i].length; j++) {
				this.canvas[i][j] = ' ';
			}
		}
	}
	public void set (int x, int y, char content) {
		this.canvas[x][y] = content;
	}
	private void clearTerminal() {
	    for(int i = 0; i < this.getHeight(); i ++) {
	    	System.out.println();
	    }
	}
	public void draw() {
		clearTerminal();
		for(int i = 0; i < this.getHeight(); i ++) {
			for(int j = 0; j < this.getWidth(); j ++) {
				System.out.print(this.canvas[j][i]);
			}
			System.out.println();
		}
	}
	public int getWidth() {
		return canvas.length;
	}
	public int getHeight() {
		return canvas[0].length;
	}
}